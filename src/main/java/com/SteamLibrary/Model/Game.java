package com.SteamLibrary.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Game {
    private int id;
    private String name;
    private String companyName;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private LocalDateTime readTime;


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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public LocalDateTime getReadTime() {
        return readTime;
    }

    public void setReadTime(LocalDateTime readTime) {
        this.readTime = readTime;
    }

    public Game(int id, String name, String companyName) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
    }
}
