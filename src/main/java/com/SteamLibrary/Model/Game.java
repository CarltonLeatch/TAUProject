package com.SteamLibrary.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Game {
    private int id;
    private String name;
    private String companyName;
    private LocalDate createTime;
    private LocalDate modifyTime;
    private LocalDate readTime;


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

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", readTime=" + readTime +
                '}';
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public void setModifyTime(LocalDate modifyTime) {
        this.modifyTime = modifyTime;
    }

    public void setReadTime(LocalDate readTime) {
        this.readTime = readTime;
    }

    public LocalDate getModifyTime() {
        return modifyTime;
    }



    public LocalDate getReadTime() {
        return readTime;
    }


    public Game(int id, String name, String companyName) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
    }
}
