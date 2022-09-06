package com.itc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;
import com.itc.main.model.Player;
import com.itc.main.service.FavouriteService;

@RestController
@RequestMapping("/api/")
public class FavouriteController {

	@Autowired
	FavouriteService favservice;
	
	@PostMapping("/save")
	public ResponseEntity<?> savePlayer(@RequestBody Player player)
	{
	
		ResponseEntity<?> responseEntity;
		try
		{
		
			
			this.favservice.savePlayer(player);
			responseEntity = new ResponseEntity<Player>(player,HttpStatus.CREATED);
		}
		catch(PlayerAlreadyExistsException e)
		{
			responseEntity = new ResponseEntity<String>("Allready",HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@GetMapping("/players")
		public ResponseEntity<List<Player>> getFavPlayers () throws PlayerNotFoundException{
			List<Player> list=this.favservice.getFavPlayers();

			return new ResponseEntity<List<Player>>(list, HttpStatus.OK);
		
	}

	@GetMapping("/player/{name}")
	public ResponseEntity getPlayerByName(@PathVariable String name) {
		Player player=this.favservice.getPlayerByName(name);
		if(player!=null) {
			return new ResponseEntity<Player>(player,HttpStatus.OK);
	}else
		return new ResponseEntity<String>("Not-found", HttpStatus.NOT_FOUND);
}
}
