package com.itc.main.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itc.main.model.Player;
import com.itc.main.service.FavouriteServiceImpl;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class FavouriteRepositoryTest {
	

	@Autowired
	private FavouriteRepository favRepository;
	

	public void setFavRepository(FavouriteRepository favRepository) {
		this.favRepository = favRepository;
	}

	public List<Player> items;
		
	@Test
	@Order(1)
	public void testNotNull() {
		assertNotNull(favRepository);
	}

	@Test
	@Order(2)
	public void savePlayerTest() {
		Player pro=new Player(1,"Sachin", 15000,"India");
		Player p=this.favRepository.save(pro);
		assertEquals(p.getPid(),pro.getPid());
      

		System.out.println("--SUCCESS SAVE  TEST--");
		
	}
	
	@Test
	@Order(3)
	public void testgetFavPlayers() {
//		List<Player> list=new ArrayList<Player>();
		Player.save(new Player(1,"Dhoni",30000,"India"));
		
//		int p=this.favRepository.findAll().size();
//		
//		assertEquals(list.size(), p);
//		System.out.println("--SUCCESS GET ALL");
		Player player1 = this.favRepository.getOne(1);
//		assertEquals(player1.get(0).getName(), "Dhoni");
		assertEquals(player1.getPid(), 1);
	}
	
	@Test
	@Order(4)
	public void testgetPlayerByName() {
		List<Player> list=new ArrayList<Player>();
		list.add(new Player(1,"Dhoni",30000,"India"));
		
		int p=this.favRepository.findAll().size();
		
		assertEquals(list.size(), p);
		System.out.println("--SUCCESS GET ALL");
	}



}
