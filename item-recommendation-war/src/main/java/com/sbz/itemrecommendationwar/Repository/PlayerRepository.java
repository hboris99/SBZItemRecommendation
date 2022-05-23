package com.sbz.itemrecommendationwar.Repository;

import java.util.ArrayList;
import java.util.List;

import  com.sbz.itemrecommendationwar.Model.*;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerRepository {
	
	
	
	private List<Player> allyPlayers = new ArrayList<Player>();
	private List<Player> enemyPlayers = new ArrayList<Player>();
	
	
	public PlayerRepository(){
		//Game started and they've bought items
		Item doransShield = new Item(PlayerClass.TANK, "Dorans Shield", 200, 0, 0.0, 0, SpecialPassive.NONE, 0, 0, 
				   0, 0, 0.0, true, 450, 0, 0, 0.0, false);
		Item doransSword = new Item(PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false);
		Item sunfireCape = new Item(PlayerClass.TANK, "Sunfire cape", 300, 0, 0.0, 0, SpecialPassive.BURN_ENEMIES, 0, 0, 
						   50, 40, 0.0, false, 3400, 0, 0, 0.0, true);
		Item locket = new Item(PlayerClass.MARKSMAN, "locket", 300, 0, 0.0, 0, SpecialPassive.BURN_ENEMIES, 0, 0, 
				   50, 40, 0.0, false, 3400, 0, 0, 0.0, true);
		Item fimbulWinter = new Item(PlayerClass.TANK, "Fimbul Winter", 250, 200, 0.0, 0, SpecialPassive.GET_SHIELD, 0, 0, 
				   20, 20, 0.0, false, 2900, 0, 0, 0.0, false);
		
		Item warmogsArmour = new Item(PlayerClass.TANK, "Warmogs armour", 450, 0, 0.0, 0, SpecialPassive.REDUCE_CRIT, 0, 0, 
				   20, 20, 0.0, false, 3000, 0, 0, 0.0, false);
		
		Item shieldBow = new Item(PlayerClass.MARKSMAN, "Immortal Shieldbow", 0, 0, 0.0, 0, SpecialPassive.GET_SHIELD, 50, 0, 
				   0, 0, 0.2, false, 3400, 20, 0, 0.35, true);
		Item phantomDancer = new Item(PlayerClass.MARKSMAN, "Phantom Dancer", 0, 0, 0.0, 0, SpecialPassive.GAIN_MS, 30, 0, 
				   0, 0, 0.2, false, 2800, 0, 50, 0.4, false);
		Item infinityEdge = new Item(PlayerClass.MARKSMAN, "Infinity Edge", 0, 0, 0.0, 0, SpecialPassive.INCREASE_CRIT, 65, 0, 
				   0, 0, 0.2, false, 3200, 0, 0, 0.0, false);
		List<Item> p1Items = new ArrayList<>();
		p1Items.add(shieldBow);
		Player p1 = new Player(PlayerClass.MARKSMAN, p1Items,2800, 6200, new ArrayList<Item>(), true, "Boris");
		
		List<Item> p2Items = new ArrayList<>();
		p1Items.add(sunfireCape);
		Player p2 = new Player(PlayerClass.TANK, p2Items,3000, 6400, new ArrayList<Item>(), true, "Nikola");
		enemyPlayers.add(p1);
		enemyPlayers.add(p2);
		
		List<Item> p3Items = new ArrayList<>();
		p1Items.add(shieldBow);
		Player p3 = new Player(PlayerClass.MARKSMAN, p3Items,3000, 6400, new ArrayList<Item>(), true, "Perko");
		allyPlayers.add(p3);
		
		
		List<Item> p4Items = new ArrayList<>();
		Player p4 = new Player(PlayerClass.TANK, p4Items,450, 500, new ArrayList<Item>(), true, "Midbeast");
		enemyPlayers.add(p4);
		
		List<Item> p5Items = new ArrayList<>();
		Player p5 = new Player(PlayerClass.MARKSMAN, p5Items,450, 500, new ArrayList<Item>(), false, "Teodor");
		allyPlayers.add(p5);
		
		
		
	}
	
	public List<Player> findEnemy(){
		return enemyPlayers;
	}
	public List<Player> findAlly(){
		return allyPlayers;
	}
	
	public Player findByName(String name) {
		for(Player p : allyPlayers) {
			if(p.getName().equals(name))
				return p;
		}
		
		return null;
	}
}
