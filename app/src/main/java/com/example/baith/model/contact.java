package com.example.baith.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class contact implements Serializable {
    private String name;
    private String number;

    public contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @NonNull
    @Override
    public String toString() {
        return "Ten " + name + "Phone number : " + this.number;
    }
}
