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
import org.mockito.stubbing.OngoingStubbing;

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
        verify(gameDao).create(4,"Test", "Test");
    }




    @Test
    public void checkReadDateFromGameObject(){
        Game g = new Game(1, "Mockito" , "Mockito");
        g.setReadTime(LocalDateTime.now().toLocalDate());


        when(gameDao.read(1)).thenReturn(g);
        Game game = gameDao.read(1);

        assertEquals(game.getReadTime(), LocalDateTime.now().toLocalDate());

        verify(gameDao).read(1);
    }

    @Test
    public void checkModifyDateFromGameObject(){
        Game g = mock(Game.class);
        when(gameDao.read(1)).thenReturn(g);
        gameService.read(1);
        assertEquals(gameService.read(1).getReadTime(), g.getReadTime());
    }

    @Test
    public void getObjectDataInformations(){
        Game g = mock(Game.class);
        when(gameDao.read(1)).thenReturn(g);
        gameService.read(1);

        assertEquals(gameService.read(1).getReadTime(), g.getReadTime());
        assertEquals(gameService.read(1).getModifyTime(), g.getModifyTime());
        assertEquals(gameService.read(1).getCreateTime(), g.getCreateTime());
    }

    @Test
    public void checkReadTimeWhenAddingIsTurnedOff(){
        Game g = new Game(1, "Mock", "Mock");
        gameDao.setAddReadTime(false);
        g.setReadTime(LocalDateTime.now().toLocalDate());
        Game game = new Game(2,"t","t");
        when(gameDao.read(1)).thenReturn(g);
        gameService.read(1);

        assertNotEquals(gameService.read(1).getReadTime(), game.getReadTime());



    }
}
