package com.SteamLibrary;

import com.SteamLibrary.Dao.GameDao;

import com.SteamLibrary.Model.Game;
import com.SteamLibrary.Service.GameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MocketGameTest {

    @Mock
    GameDao gameDao = new GameDao();

    @InjectMocks
    private GameService gameService = new GameService();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void t(){
        gameDao.create(6,"Mockito", "Mockito");
    }

    @Test
    public void addingValueToDatabase(){
        when(gameDao.create(1,"Mockito","Mockito")).thenReturn(true);
        assertTrue(gameService.create(1,"Mockito","Mockito"));
        verify(gameDao, times(1)).create(1, "Mockito","Mockito");
    }

    @Test(expected = RuntimeException.class)
    public void addingValueToDatabase_throwsExcepion(){
        when(gameDao.create(anyInt(),anyString(), anyString())).thenThrow(RuntimeException.class);

        gameService.create(1,"First", "Game");
    }


    Game g = gameDao.read(6);

    @Test
    public void checkReadDateFromGameObject(){
        Game g = new Game(1, "Mockito" , "Mockito");
        g.setReadTime(LocalDateTime.now());
        when(gameDao.create(g.getId(),g.getName(),g.getCompanyName())).thenReturn(true);
        assertTrue(gameDao.create(g.getId(),g.getName(),g.getCompanyName()));

        when(gameDao.read(1)).thenReturn(g);
        Game game = gameDao.read(1);

        assertEquals(game.getReadTime().toLocalDate(), LocalDateTime.now().toLocalDate());
    }
}
