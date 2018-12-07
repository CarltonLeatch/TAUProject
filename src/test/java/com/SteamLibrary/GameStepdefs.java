package com.SteamLibrary;

import com.SteamLibrary.Model.Game;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class GameStepdefs {
    Game game;
    String name = "";
    String companyName = "";
    int id;

    @Given("^name is Test$")
    public void name_is_Test() throws Exception {
       name = "Test";
    }

    @Given("^Id is (\\d+)$")
    public void id_is(int arg1) throws Exception {
        id =arg1;
    }

    @Given("^CompanyName is Company$")
    public void companyname_is_Company() throws Exception {
        companyName = "Company";
    }

    @When("^We create object$")
    public void we_create_object() throws Exception {
       game = new Game(name, companyName);
    }

    @Then("^It shouldn't be null$")
    public void it_shouldn_t_be_null() throws Exception {
       assertNotNull(game);
    }

}
