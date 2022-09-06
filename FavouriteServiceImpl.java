package com.itc.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;
import com.itc.main.model.Player;
import com.itc.main.repository.FavouriteRepository;

@Service

public class FavouriteServiceImpl implements FavouriteService {

	@Autowired
	FavouriteRepository favouriterepo;
//
//	@Override
//	public boolean savePlayer(Player player) throws PlayerAlreadyExistsException {
//
//		Optional<Player> checkPlayer = this.favouriterepo.findById(player.getPid());
//		
//		if(checkPlayer.isPresent())
//			throw new PlayerAlreadyExistsException("Player already exists");
//		
//		this.favouriterepo.save(player);
//		return true;
//	}
//
//	@Override
//	public Player getPlayerByName(String name) {
//		return this.favouriterepo.findByName(name);
//	}
//
//	@Override
//	public List<Player> getFavPlayers() {
//		return this.favouriterepo.findAll();
//	}

	public boolean savePlayer(Player player) throws  PlayerAlreadyExistsException {
		Optional<Player> checkPlayer = this.favouriterepo.findById(player.getPid());
		
		if(checkPlayer.isPresent())
			throw new PlayerAlreadyExistsException();
		
		this.favouriterepo.save(player);
		return true;
	}


	public List<Player> getFavPlayers() throws PlayerNotFoundException {
		return this.favouriterepo.findAll();
	}

	public Player getPlayerByName(String name){
//		return this.favouriterepo.findByName(name);
//		 Player ply = this.favouriterepo.findByName(name).orElse();
//		if(ply == null) {
//			throw new PlayerNotFoundException();
//		}
//		return ply;
//
//		List<Player> plyList =  (List<Player>) this.favouriterepo.findByName(name);
//		if(plyList.size()==0)
//			throw new PlayerNotFoundException();
//		return plyList;
			Player player=this.favouriterepo.getPlayerByName(name);
			if(player!=null) {
				return player;
			}
			else
				return  null;
			}
	}

