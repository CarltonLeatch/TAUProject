package com.SteamLibrary.Dao;

import com.SteamLibrary.Model.Game;

import java.util.List;

public interface IGameDao {
    boolean create(int id, String name, String companyName);
    List<Game> readAll();
    boolean delete(int id);
    Game read(int id);
    void deleteAll();
    boolean update(int id, String name, String companyName);
}
