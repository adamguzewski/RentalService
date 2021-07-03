package adaguz.rentalservice.nbp.model;

import nonapi.io.github.classgraph.json.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String currency;
    private int days;
    private double average;
    private LocalDateTime creationDate;

    public Result(long id, String currency, int days, double average, LocalDateTime creationDate) {
        this.id = id;
        this.currency = currency;
        this.days = days;
        this.average = average;
        this.creationDate = creationDate;
    }

    public Result() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
