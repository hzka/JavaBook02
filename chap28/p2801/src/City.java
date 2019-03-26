public class City {
    public String cityname;
    public int population;
    public String mayor;//市长
    public City(String cityname,int population,String mayor){
        this.cityname = cityname;
        this.population = population;
        this.mayor = mayor;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getMayor() {
        return mayor;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }
}
