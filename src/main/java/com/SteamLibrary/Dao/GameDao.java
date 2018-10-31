package com.SteamLibrary.Dao;

import com.SteamLibrary.Model.Game;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GameDao implements IGameDao{

    private boolean addCreateTime = true;
    private boolean addModifyTime = true;
    private boolean addReadTime = true;

    public boolean isAddCreateTime() {
        return addCreateTime;
    }

    public void setAddCreateTime(boolean addCreateTime) {
        this.addCreateTime = addCreateTime;
    }

    public boolean isAddModifyTime() {
        return addModifyTime;
    }

    public void setAddModifyTime(boolean addModifyTime) {
        this.addModifyTime = addModifyTime;
    }

    public boolean isAddReadTime() {
        return addReadTime;
    }

    public void setAddReadTime(boolean addReadTime) {
        this.addReadTime = addReadTime;
    }

    private List<Game> db = new ArrayList<Game>();
    public boolean create(int id, String name, String companyName) {
        Game game = new Game(id,name,companyName);
        if(!isPrepertyIdUnique(game))
        {
            game.setCreateTime(LocalDateTime.now());
            db.add(game);
            return true;
        }
        else
            throw new IllegalArgumentException("ID must be unique" + game.getId());
    }
    public List<Game> readAll() {
        for(Game g : db)
            g.setReadTime(LocalDateTime.now());
        return db;
    }
    public Game read(int id){
        for(Game g : db){
            if(g.getId() == id) {
             g.setReadTime(LocalDateTime.now());
                return g;
            }
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
        _g.setCreateTime(g.getCreateTime());
        _g.setReadTime(g.getReadTime());
        _g.setModifyTime(g.getModifyTime());
        delete(id);
        _g.setModifyTime(LocalDateTime.now());
        return db.add(_g);
    }
}
