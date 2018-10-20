package com.SteamLibrary.Model;

public class Game {
    private int id;
    private String name;
    private String companyName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Game(int id, String name, String companyName) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
    }
}
