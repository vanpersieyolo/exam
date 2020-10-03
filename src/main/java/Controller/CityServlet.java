package Controller;

import Model.City;
import Model.National;
import Service.CityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet("/city")
public class CityServlet extends HttpServlet {

    CityService cityService = new CityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                updateInfor(request,response);
                break;
            case "add":
                add(request,response);
                break;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showAll(request, response);
                break;
            case "detail":
                formDetail(request, response);
                break;
            case "update":
                formUpdate(request, response);
                break;
            case "remove":
                formRemove(request,response);
                break;
            case "remove1":
                remove(request,response);
                break;
            case "add":
                formAdd(request,response);
                break;
        }
    }

    protected void showAll(HttpServletRequest request, HttpServletResponse response) {
        List<City> cityList = cityService.selectAll();
        request.setAttribute("cityList", cityList);
        RequestDispatcher rq = request.getRequestDispatcher("/View/ViewList.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void formDetail(HttpServletRequest request, HttpServletResponse response) {
        int idInput = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getById(idInput);
        request.setAttribute("city", city);
        RequestDispatcher rq = request.getRequestDispatcher("/View/ViewDetail.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void formUpdate(HttpServletRequest request, HttpServletResponse response) {
        int idInput = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getById(idInput);
        List<National> nationalList =  cityService.selectAllNational();
        request.setAttribute("nationalList",nationalList);
        request.setAttribute("city", city);
        RequestDispatcher rq = request.getRequestDispatcher("/View/ViewUpdate.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void updateInfor(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("cityid"));
        String cityName = request.getParameter("cityName");
        int nationalId = Integer.parseInt(request.getParameter("nationalId"));
        long cityArer = Long.parseLong(request.getParameter("cityarea"));
        long cityGdp = Long.parseLong(request.getParameter("cityGdp"));
        String cityDescription = request.getParameter("cityDescription");
        City city = new City(id,cityName,nationalId,cityArer,cityGdp,cityDescription);
        cityService.updateInfor(city);
        try {
            response.sendRedirect("/city?action=showall");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void formRemove(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getById(id);
        request.setAttribute("city",city);
        RequestDispatcher rq = request.getRequestDispatcher("/View/ViewRemove.jsp");
        try {
            rq.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void remove(HttpServletRequest request , HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        cityService.deteleCity(id);
        showAll(request,response);
    }
    protected void formAdd (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<National> nationalList =  cityService.selectAllNational();
        request.setAttribute("nationalList",nationalList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/View/ViewAdd.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("cityName");
        int nationalId = Integer.parseInt(request.getParameter("nationalId"));
        long area = Long.parseLong(request.getParameter("cityArea"));
        long gdp = Long.parseLong(request.getParameter("cityGDP"));
        String description =request.getParameter("cityDescription");
        City city = new City(nationalId,name,area,gdp,description);
        cityService.insertCity(city);
        try {
            response.sendRedirect("/city?action=");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
