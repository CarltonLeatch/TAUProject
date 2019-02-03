package com.SteamLibrary.Controller;

import com.SteamLibrary.Model.Game;
import com.SteamLibrary.Service.GameService;
import com.SteamLibrary.Service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/game")
public class GameController {

    @Autowired
    IGameService gameService;

    @GetMapping
    public List<Game> getAll(){
        return gameService.readAll();
    }

    @PostMapping
    public void add(@RequestBody Game game){
        System.out.println(game.toString());
        gameService.create(game.getName(), game.getCompanyName());
    }

    @DeleteMapping("/api/game/{id}")
    public void delete(@PathVariable("id") int id){
        gameService.delete(id);
    }

    @PutMapping("/api/game/{id}")
    public void update(@PathVariable("id")int id, @RequestBody Game game){
        gameService.update(id, game.getName(), game.getCompanyName());
    }
}
