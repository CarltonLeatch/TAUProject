package com.SteamLibrary.Service;

import com.SteamLibrary.Dao.GameDao;
import com.SteamLibrary.Dao.IGameDao;
import com.SteamLibrary.Model.Game;

import java.util.List;

public class GameService implements IGameService {
    private IGameDao _gameDao = new GameDao();
    public boolean create(int id, String name, String companyName) {
        return  _gameDao.create(id,name,companyName);
    }
    public List<Game> readAll() {
        return _gameDao.readAll();
    }
    public Game read(int id){
        return  _gameDao.read(id);
    }
    public boolean delete(int id) {
        return _gameDao.delete(id);
    }
    public void deleteAll(){
        _gameDao.deleteAll();
    }
    public boolean update(int id, String name, String companyName){
        return _gameDao.update(id,name,companyName);
    }
}
