package com.SteamLibrary.Dao;

import com.SteamLibrary.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGameDao extends JpaRepository<Game, Integer> {

}
