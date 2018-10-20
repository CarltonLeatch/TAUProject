package com.SteamLibrary.Dao;

import com.SteamLibrary.Model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameDao implements IGameDao{

    private List<Game> db = new ArrayList<Game>();
    public boolean create(int id, String name, String companyName) {
        Game game = new Game(id,name,companyName);
        if(!isPrepertyIdUnique(game))
        {
            db.add(game);
            return true;
        }
        else
            throw new IllegalArgumentException("ID must be unique" + game.getId());
    }
    public List<Game> readAll() {
        return db;
    }
    public Game read(int id){
        for(Game g : db){
            if(g.getId() == id)
                return g;
        }
        return null;
    }
    public boolean isPrepertyIdUnique(Game game){
        boolean check = db.stream().anyMatch(o -> o.getId() == game.getId());
        return check;
    }
    public boolean delete(int id) {
        return db.remove(read(id));
    }
    public void deleteAll(){
        db.clear();
    }
    public boolean update(int id, String name, String companyName){
        Game g = read(id);
        Game _g = new Game(g.getId(), name, companyName);
        delete(id);
        return create(_g.getId(), _g.getName(), _g.getCompanyName());
    }
}
