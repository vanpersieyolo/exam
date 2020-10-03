package Service;

import Model.City;
import Model.National;

import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityService implements ICityService {
    private String JDBCURl = "jdbc:mysql://localhost:3306/exam?useSSL=false";
    private String JDBCUSERNAME = "root";
    private String JDBCUSERPASSWORD = "123456";

    public CityService() {
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBCURl, JDBCUSERNAME, JDBCUSERPASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<City> selectAll() {
        List<City> cityList = new ArrayList<>();
        City city;
        String query = "{call select_All()}";
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int cityId = Integer.parseInt(rs.getString("cityid"));
                String cityName = rs.getString("cityname");
                long cityArea = Long.parseLong(rs.getString("cityarea"));
                long cityGdp = Long.parseLong(rs.getString("citygdp"));
                String cityDescription = rs.getString("cityDescrion");
                String nationalName = rs.getString("nationalname");
                city = new City(cityId, cityName, cityArea, cityGdp, cityDescription, nationalName);
                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public City getById(int cityId) {
        List<City> cityList1 = new ArrayList<>();
        City city = null;
        for (City city1 : selectAll()) {
            if (cityId == city1.getCityId()) {
                return city1;
            }
        }
        return null;
    }

    @Override
    public boolean insertCity(City city) {
        boolean check = false;
        String query = "{call insert_city(?,?,?,?,?)}";
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setString(1,city.getCityName());
            callableStatement.setInt(2,city.getNationalId());
            callableStatement.setLong(3,city.getCityArea());
            callableStatement.setLong(4,city.getCityGDP());
            callableStatement.setString(5,city.getCityDescription());
            check = callableStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean updateInfor(City city) {
        String query = "{call update_city(?,?,?,?,?,?)}";
        boolean check = false;
        try (Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1, city.getCityId());
            callableStatement.setString(2, city.getCityName());
            callableStatement.setInt(3, city.getNationalId());
            callableStatement.setLong(4, city.getCityArea());
            callableStatement.setLong(5, city.getCityGDP());
            callableStatement.setString(6, city.getCityDescription());
            check = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean deteleCity(int cityId) {
        boolean check = false;
        String query = "{call delete_city(?)}";
        try(Connection connection = getConnection(); CallableStatement callableStatement = connection.prepareCall(query)){
            callableStatement.setInt(1,cityId);
            check = callableStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public List<National> selectAllNational(){
        List<National> nationalList = new ArrayList<>();
        National national ;
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement("select * from nationalofcity")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int nationalId = rs.getInt("nationalid");
                String nationalName = rs.getString("nationalName");
                National national1 = new National(nationalId,nationalName);
                nationalList.add(national1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nationalList;
    }
}
