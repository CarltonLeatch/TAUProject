package com.SteamLibrary.Service;

import com.SteamLibrary.Dao.IGameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandRunner implements CommandLineRunner {
   @Autowired
   IGameService gameService;
   @Autowired
    IGameDao gameDao;

    @Override
    public void run(String... args) throws Exception {
        gameDao.deleteAll();
        gameService.create( "League of Legends", "Riot Games");
        gameService.create( "Counter Strike GO", "Valve");
        gameService.create( "Fortnite", "Epic Games");
        gameService.create( "Diablo 3 ", "Blizzard");
        gameService.create( "FIFA 2018","Electronic Arts");
    }
}
