package com.itc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itc.main.model.Player;


@Repository
public interface FavouriteRepository extends  JpaRepository<Player, Integer> {

//	Player getPlayerByname(String name);

//	Player findByName(String name);

//	Player getPlayerByName(String name);

	public Player getPlayerByName(String name);

}
