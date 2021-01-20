package com.bit.basic.lamd;

public class Country {

    private String continent;

    private String name;

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getContinent() + "---" + this.getName();
    }
}
