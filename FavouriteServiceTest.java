package com.itc.main.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.itc.main.exception.PlayerAlreadyExistsException;
import com.itc.main.exception.PlayerNotFoundException;
import com.itc.main.model.Player;
import com.itc.main.repository.FavouriteRepository;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class FavouriteServiceTest {
	
	@InjectMocks
	private FavouriteServiceImpl favService;
//	Service service= new Service();
	
	@Mock
	private FavouriteRepository favRepository;
	
	@Test
	public void getNotNullTest() {
		assertThat(favService).isNotNull();
		assertThat(favRepository).isNotNull();
	}
	
	@Test
	public void testsavePlayer() throws PlayerAlreadyExistsException {
		//Get the Object
		 Player pro= new Player();
		  pro.setPid(1);
		  pro.setName("Sachin");
		  pro.setRun((long) 30000);
		  pro.setTeam("India");
		  
		//when , then
		  
		 when(this.favRepository.save(pro))
		  .thenReturn(pro);
		
		 boolean isSave=this.favService.savePlayer(pro);
		 assertEquals(isSave,true);
		 System.out.println("--SUCCESS SAVE Player--");
	}
	

	@Test
	public void testFavPlayer() throws PlayerNotFoundException {
		List<Player> list=new ArrayList();
		list.add(new Player(1,"Sachin",30000,"India"));
		
		when(this.favRepository.findAll())
		.thenReturn(list);
		
		List<Player> list1=this.favService.getFavPlayers();
		
		assertEquals(list1.size(), list.size());
		System.out.println("--SUCCESS TEST GET ALL Player--");
		
	}

		@SuppressWarnings("deprecation")
		@Test
		public void testgetPlayerByName() throws PlayerNotFoundException {
			 //Get the Object
			  Player pro= new Player();
			  pro.setPid(1);
			  pro.setName("Virat");
			  pro.setRun((long)30000);
			  pro.setTeam("India");
			  
			  when(this.favRepository.getById(anyInt()))
			  .thenReturn(pro);
			  
			  Player p=this.favService.getPlayerByName("Virat");
			  
			  assertEquals(p.getName(), pro.getName());
			  System.out.println("--SUCCESS TEST--");
			
		}
		
 
	
	

}
