package adaguz.rentalservice.model;

public class Movie {

    private Long id;
    private String name;
    private Category category;
    private CountryOfProduction countryOfProduction;
    private String direction;
    private int yearOfProduction;
    private boolean isAvailable;

    public Movie(String name, Category category, CountryOfProduction countryOfProduction, String direction, int yearOfProduction) {
        this.name = name;
        this.category = category;
        this.countryOfProduction = countryOfProduction;
        this.direction = direction;
        this.yearOfProduction = yearOfProduction;
    }


    public Movie(){

    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CountryOfProduction getCountryOfProduction() {
        return countryOfProduction;
    }

    public void setCountryOfProduction(CountryOfProduction countryOfProduction) {
        this.countryOfProduction = countryOfProduction;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
