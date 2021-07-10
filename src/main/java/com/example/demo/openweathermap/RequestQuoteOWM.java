package com.example.demo.openweathermap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestQuoteOWM {
    private City city = new City();
    private int cod;
    private ArrayList<DateList> list = new ArrayList<DateList>();

    public RequestQuoteOWM() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public ArrayList<DateList> getList() {
        return list;
    }

    public void setList(ArrayList<DateList> list) {
        this.list = list;
    }
}
