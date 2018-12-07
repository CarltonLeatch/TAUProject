package com.SteamLibrary.Service;

import com.SteamLibrary.Model.Game;

import java.util.List;
import java.util.Optional;

public interface IGameService {
    boolean create(String name, String companyName);
    List<Game> readAll();
    Optional<Game> read(int id);
    boolean delete(int id);
    boolean update(int id, String name, String companyName);
}
