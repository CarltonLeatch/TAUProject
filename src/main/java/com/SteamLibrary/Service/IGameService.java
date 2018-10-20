package com.SteamLibrary.Service;

import com.SteamLibrary.Model.Game;

import java.util.List;

public interface IGameService {
    boolean create(int id, String name, String companyName);
    List<Game> readAll();
    Game read(int id);
    boolean delete(int id);
    void deleteAll();
    boolean update(int id, String name, String companyName);
}
