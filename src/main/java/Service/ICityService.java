package Service;

import Model.City;

import java.util.List;

public interface ICityService {
    List<City> selectAll();
    City getById(int cityId);
    boolean insertCity(City city);
    boolean updateInfor(City city);
    boolean deteleCity (int cityId);
}
