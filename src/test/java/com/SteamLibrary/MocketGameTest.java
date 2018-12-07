package com.SteamLibrary;


import com.SteamLibrary.Model.Game;
import com.SteamLibrary.Service.GameService;
import com.SteamLibrary.Service.IGameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MocketGameTest {

    @Mock
    IGameService gameDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }



    @Test
    public void addingValueToDatabase(){
        when(gameDao.create("Mockito","Mockito")).thenReturn(true);
        assertTrue(gameDao.create("Mockito","Mockito"));
        verify(gameDao, times(1)).create("Mockito","Mockito");
    }

    @Test(expected = RuntimeException.class)
    public void addingValueToDatabase_throwsExcepion(){
        when(gameDao.create(anyString(), anyString())).thenThrow(RuntimeException.class);
        gameDao.create("First", "Game");
        verify(gameDao).create("Test", "Test");
    }




    @Test
    public void checkReadDateFromGameObject(){
        Game g = new Game("Mockito" , "Mockito");
        g.setReadTime(new Date());


        when(gameDao.read(1)).thenReturn(Optional.ofNullable(g));
        Optional<Game> game = gameDao.read(1);

        assertNotEquals(game.get().getReadTime(), LocalDateTime.now().toLocalDate());

        verify(gameDao).read(1);
    }

    @Test
    public void checkModifyDateFromGameObject(){
        Game g = mock(Game.class);
        when(gameDao.read(1)).thenReturn(Optional.ofNullable(g));
        assertEquals(gameDao.read(1).get().getReadTime(), g.getReadTime());
    }

    @Test
    public void getObjectDataInformations(){
        Game g = mock(Game.class);
        when(gameDao.read(1)).thenReturn(Optional.ofNullable(g));
        gameDao.read(1);

        assertEquals(gameDao.read(1).get().getReadTime(), g.getReadTime());
        assertEquals(gameDao.read(1).get().getModifyTime(), g.getModifyTime());
        assertEquals(gameDao.read(1).get().getCreateTime(), g.getCreateTime());
    }

}
