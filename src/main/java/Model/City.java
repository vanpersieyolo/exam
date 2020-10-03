package Model;

public class City {
    int cityId;
    int nationalId;
    String cityName;
    long cityArea;
    long cityGDP;
    String cityDescription;
    String nationalName;

    public City(int cityId, int nationalId, String cityName, long cityArea, long cityGDP, String cityDescription) {
        this.cityId = cityId;
        this.nationalId = nationalId;
        this.cityName = cityName;
        this.cityArea = cityArea;
        this.cityGDP = cityGDP;
        this.cityDescription = cityDescription;
    }

    public City(int cityId, String cityName,int nationalId , long cityArea, long cityGDP, String cityDescription) {
        this.cityId = cityId;
        this.nationalId = nationalId;
        this.cityName = cityName;
        this.cityArea = cityArea;
        this.cityGDP = cityGDP;
        this.cityDescription = cityDescription;
    }

    public City(int cityId, String cityName, long cityArea, long cityGDP, String cityDescription, String nationalName) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityArea = cityArea;
        this.cityGDP = cityGDP;
        this.cityDescription = cityDescription;
        this.nationalName = nationalName;
    }

    public City(int nationalId, String cityName, long cityArea, long cityGDP, String cityDescription) {
        this.nationalId = nationalId;
        this.cityName = cityName;
        this.cityArea = cityArea;
        this.cityGDP = cityGDP;
        this.cityDescription = cityDescription;
    }

    public City() {
    }
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public long getCityArea() {
        return cityArea;
    }

    public void setCityArea(long cityArea) {
        this.cityArea = cityArea;
    }

    public long getCityGDP() {
        return cityGDP;
    }

    public void setCityGDP(long cityGDP) {
        this.cityGDP = cityGDP;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
