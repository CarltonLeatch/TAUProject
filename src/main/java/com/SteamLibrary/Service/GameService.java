package com.SteamLibrary.Service;

import com.SteamLibrary.Dao.IGameDao;
import com.SteamLibrary.Model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("GameService")
public class GameService implements IGameService {

    @Autowired
    private IGameDao _gameDao;

    public boolean create(String name, String companyName) {
        Game game = new Game();
        game.setName(name);
        game.setCompanyName(companyName);
        System.out.println(game.toString());
        _gameDao.save(game);
        return true;
    }

    public List<Game> readAll() {
        _gameDao.findAll().stream().forEach((o)->{
            o.setReadTime(new Date());
            _gameDao.save(o);
        });

        return _gameDao.findAll();
    }

    public Optional<Game> read(int id){
        Optional<Game> game = _gameDao.findById(id);
        game.get().setReadTime(new Date());
        _gameDao.save(game.get());
        return  game;
    }

    public boolean delete(int id) {
        Optional<Game> g = _gameDao.findById(id);
        _gameDao.delete(g.get());
        return true;
    }
    public boolean update(int id, String name, String companyName){
        Optional<Game> g = _gameDao.findById(id);
        Game game = g.get();
        game.setName(name);
        game.setCompanyName(companyName);
        _gameDao.save(game);
        return true;
    }
}
