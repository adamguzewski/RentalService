package adaguz.rentalservice.model;

import io.swagger.annotations.ApiModelProperty;

public class Movie {

    @ApiModelProperty(notes = "Id of the movie", required = true, example = "1")
    private Long id;
    @ApiModelProperty(notes = "Name of the movie", required = true, example = "Independence day")
    private String name;
    @ApiModelProperty(notes = "Category of the movie", required = true, example = "HORROR")
    private Category category;
    @ApiModelProperty(notes = "Country of production of the movie", required = true, example = "USA")
    private CountryOfProduction countryOfProduction;
    @ApiModelProperty(notes = "Direction of the movie", required = true, example = "GEORGE LUCAS")
    private String direction;
    @ApiModelProperty(notes = "Year of production of the movie", required = true, example = "2019")
    private int yearOfProduction;
    @ApiModelProperty(notes = "It shows the availability of the movie", required = true, example = "true")
    private boolean isAvailable;

    public Movie(String name, Category category, CountryOfProduction countryOfProduction, String direction, int yearOfProduction) {
        this.name = name;
        this.category = category;
        this.countryOfProduction = countryOfProduction;
        this.direction = direction;
        this.yearOfProduction = yearOfProduction;
    }


    public Movie() {

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
