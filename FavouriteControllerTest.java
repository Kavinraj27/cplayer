package com.itc.main.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itc.main.model.Player;
import com.itc.main.service.FavouriteServiceImpl;


@WebMvcTest(value = FavouriteController.class)


public class FavouriteControllerTest {
	

	@Autowired
	private MockMvc mvc;
	 @MockBean
	 private FavouriteServiceImpl favService;
//	 @InjectMocks
//		private FavouriteController favoriteController;
//	
//
//		private Player cPlayer;
//
//		private List list;
//		
//
//		@Before(value = "")
//		public void setup() {
//			MockitoAnnotations.initMocks(this);
//			mvc = MockMvcBuilders.standaloneSetup(favoriteController).build();
//			cPlayer = new Player();
//			cPlayer.setName("sachin");
//			cPlayer.setPid("1");
//			list = new ArrayList();
//			list.add(cPlayer);
//		}

	 @Test
	 public void testNotNull() {
		 assertNotNull(favService);
		 assertNotNull(mvc);
	 }
	 
	 @Test
	 public  void savePlayer() throws Exception {
		 Player pro=new Player();
		 pro.setPid(1);
		 pro.setName("Rahul");
		 pro.setRun((long) 3000);
		 pro.setTeam("India");
		 
		 when(this.favService.savePlayer(Mockito.any(Player.class)))
		 .thenReturn(pro);
		 
		 String uri="/api/save";
		 String expected=this.mapToJson(pro);
		
		 RequestBuilder rb= MockMvcRequestBuilders
		 .post(uri)
		  .accept(org.springframework.http.MediaType.APPLICATION_JSON)
		  .content(expected)
		  .contentType(org.springframework.http.MediaType.APPLICATION_JSON);
		 
		MvcResult mv=mvc.perform(rb).andReturn();
		String outputJson = mv.getResponse().getContentAsString();
		
		assertThat(outputJson).isEqualTo(expected);
		
		 
	 }
	 
	 
	 @Test
	 public void testGetPlayertByName() throws Exception {
		 Player pro=new Player();
		 pro.setPid(1);
		 pro.setName("Sachin");
		 pro.setRun((long) 30000);
		 pro.setTeam("India");
		 
		when(this.favService.getPlayerByName(Mockito.anyString()))
		 .thenReturn(pro); 
		 
		 String URI="/api/player/Sachin";
		 
		 RequestBuilder rb= MockMvcRequestBuilders
				 .get(URI)
				 .accept(org.springframework.http.MediaType.APPLICATION_JSON);
		 MvcResult mr=mvc.perform(rb).andReturn();
		 
		 String expected=this.mapToJson(pro);
		 String actual=mr.getResponse().getContentAsString();
		 assertThat(actual).isEqualTo(expected);
	 }
	 
	 @Test
	 public void testGetFavPlayers() throws Exception {
		 List<Player> pro=(List<Player>) new Player();
		 ((Player) pro).setPid(1);
		 ((Player) pro).setName("Rohit");
		 ((Player) pro).setRun((long) 30000);
		 ((Player) pro).setTeam("India");
//		 List<Product> prolist = new ArrayList<>();
//		 prolist.add(pro);
		 
		when(this.favService.getFavPlayers())
		 .thenReturn(pro);
		 
		 String URI="/api/products";
		 
		 RequestBuilder rb= MockMvcRequestBuilders
				 .get(URI)
				 .accept(org.springframework.http.MediaType.APPLICATION_JSON);
		 MvcResult mr=mvc.perform(rb).andReturn();
		 
		 String expected=this.mapToJson((Player) pro);
		 String actual=mr.getResponse().getContentAsString();
		 assertThat(actual).isEqualTo(expected);
		 
		 
		 
	 }
	 
	 private String mapToJson(Player pro) throws JsonProcessingException {
		 ObjectMapper om=new ObjectMapper();
		 String s = om.writeValueAsString(pro);
		 
		return s;
	}
	 

}
