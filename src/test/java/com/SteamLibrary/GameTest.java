package com.SteamLibrary;

import com.SteamLibrary.Service.GameService;
import com.SteamLibrary.Service.IGameService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class GameTest {

    private static IGameService gameService;
    @BeforeClass
    public static void initializeObject(){
        gameService = new GameService();
    }
    @Before
    public  void addToDB(){
        gameService.deleteAll();
        gameService.create(1, "League of Legends", "Riot Games");
        gameService.create(2, "Counter Strike GO", "Valve");
        gameService.create(3, "Fortnite", "Epic Games");
        gameService.create(4, "Diablo 3 ", "Blizzard");
        gameService.create(5, "FIFA 2018","Electronic Arts");
    }
    @Test
    public void databaseMustBeInitialized(){
        assertNotNull("Object cannot be null",gameService);
    }
    @Test
    public void databaseHasFiveElements(){
        assertEquals("Database must have at least 5 elements", 5, gameService.readAll().size());
    }
    @Test
    public void gettedObjectFromDatabaseIsNull(){
        assertNull("Object getted from database must not be null", gameService.read(7));
    }
    @Test
    public void gettedObjectFromDatabaseIsNotNull(){
        assertNotNull("Object getted from database is null", gameService.read(1));
    }
    @Test(expected = IllegalArgumentException.class)
    public void objectPropertyIdMustBeUnique(){
        assertTrue("Property ID must be unique", gameService.create(1, "Path of Exile", "Grinding Gear Games"));
    }
    @Test
    public void databaseMustContainDeletedObject(){
        assertTrue("Object must be in database", gameService.delete(2));
    }
    @Test
    public void objectHasChangedNameAndCompanyName(){
        assertTrue("Object should've changed",gameService.update(3,"Call of Duty: Black Ops 4", "Activision"));
    }
}
