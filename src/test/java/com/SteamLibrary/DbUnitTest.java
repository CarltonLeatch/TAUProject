package com.SteamLibrary;

import com.SteamLibrary.Model.Game;
import com.SteamLibrary.Service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class DbUnitTest {


    @Autowired
    GameService gameService;


    @Test
    public void getDatabaseSize(){
        assertEquals(5, gameService.readAll().size());
        gameService.create("Test", "DBUnitTest");
        assertEquals(6, gameService.readAll().size());
    }

    @Test
    public void removeOneRecord(){
        assertEquals(5, gameService.readAll().size());
        gameService.delete(5);
        assertEquals(4,gameService.readAll().size());
    }

    @Test
    public void updateFirstRecord(){
        assertEquals("Riot Games", gameService.read(1).get().getCompanyName());
        gameService.update(1, gameService.read(1).get().getName(), "DBUnit");
        assertEquals("DBUnit", gameService.read(1).get().getCompanyName());
    }

    @Test
    public void getOneRecord(){
        assertEquals("Fortnite", gameService.read(3).get().getName());
    }

    @Test
    public void findByName(){
        assertNotNull(gameService.findByCompanyName("Riot Games"));
    }
}
