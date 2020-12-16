package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCity;
    private double area;
    private Long population;
    private Double gdp;
    private String information;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(String nameCity, double area, Long population, Double gdp, String information, Country country) {
        this.nameCity = nameCity;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.information = information;
        this.country = country;
    }

    public City(Long id, String nameCity, double area, Long population, Double gdp, String information, Country country) {
        this.id = id;
        this.nameCity = nameCity;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.information = information;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
