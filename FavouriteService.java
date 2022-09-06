package com.itc.main.service;

import java.util.List;

import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;
import com.itc.main.model.Player;

public interface FavouriteService {


	boolean savePlayer(Player player) throws PlayerAlreadyExistsException;
	
//	FoodApp updateItem(FoodApp item) throws ItemNotFoundException;
	
//	boolean deleteItem(int id) throws ItemNotFoundException;
//	
//	FoodApp getItemById(int id) throws ItemNotFoundException;
	
	List<Player> getFavPlayers() throws PlayerNotFoundException;;
	public Player getPlayerByName(String name);

	
}
