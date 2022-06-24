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
		Item doransShield = new Item(1, PlayerClass.TANK, "Dorans Shield", 200, 0, 0.0, 0, SpecialPassive.NONE, 0, 0, 
				   0, 0, 0.0, true, 450, 0, 0, 0.0, false, "hp");
		Item doransSword = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "atkDmg");
		Item sunfireCape = new Item(3, PlayerClass.TANK, "Sunfire cape", 300, 0, 0.0, 0, SpecialPassive.BURN_ENEMIES, 0, 0, 
						   50, 40, 0.0, false, 3400, 0, 0, 0.0, true, "resistance");
		
		Item fimbulWinter = new Item(4, PlayerClass.TANK, "Fimbul Winter", 250, 200, 0.0, 0, SpecialPassive.GET_SHIELD, 0, 0, 
				   20, 20, 0.0, false, 2900, 0, 0, 0.0, false, "hp");
		
		Item warmogsArmour = new Item(5, PlayerClass.TANK, "Warmogs armour", 450, 0, 0.0, 0, SpecialPassive.REDUCE_CRIT, 0, 0, 
				   20, 20, 0.0, false, 3000, 0, 0, 0.0, false, "hp");
		
		Item shieldBow = new Item(6, PlayerClass.MARKSMAN, "Immortal Shieldbow", 0, 0, 0.0, 0, SpecialPassive.GET_SHIELD, 50, 0, 
				   0, 0, 0.2, false, 3400, 20, 0, 0.35, true, "atkDmg");
		Item phantomDancer = new Item(7, PlayerClass.MARKSMAN, "Phantom Dancer", 0, 0, 0.0, 0, SpecialPassive.GAIN_MS, 30, 0, 
				   0, 0, 0.2, false, 2800, 0, 50, 0.4, false, "armour");
		Item infinityEdge = new Item(8, PlayerClass.MARKSMAN, "Infinity Edge", 0, 0, 0.0, 0, SpecialPassive.INCREASE_CRIT, 65, 0, 
				   0, 0, 0.2, false, 3200, 0, 0, 0.0, false, "atkDmg");
		Item locket = new Item(9, PlayerClass.MARKSMAN, "locket", 300, 0, 0.0, 0, SpecialPassive.BURN_ENEMIES, 0, 0, 
				   50, 40, 0.0, false, 3400, 0, 0, 0.0, true, "resistance");
		List<Item> p1Items = new ArrayList<>();
		Player p1 = new Player(PlayerClass.MARKSMAN, p1Items,2800, 6200, new ArrayList<Item>(), true, "Boris", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
		p1.addPurchasedItem(infinityEdge);
		p1.addPurchasedItem(shieldBow);

		List<Item> p2Items = new ArrayList<>();
		Player p2 = new Player(PlayerClass.TANK, p2Items,3000, 6400, new ArrayList<Item>(), true, "Nikola", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
		p2.addPurchasedItem(sunfireCape);
		p2.addPurchasedItem(doransSword);
		enemyPlayers.add(p1);
		enemyPlayers.add(p2);
		
		
		
		
		
		
	}
	
	public List<Player> findEnemy(){
		return enemyPlayers;
	}
	public List<Player> findAlly(){
		return allyPlayers;
	}
	
	public Player findAllyByName(String name) {
		for(Player p : allyPlayers) {
			if(p.getName().equals(name))
				return p;
		}
		
		return null;
	}
	public Player findEnemyByName(String name) {
		for(Player p : enemyPlayers) {
			if(p.getName().equals(name))
				return p;
		}
		
		return null;
	}


	public void addAllyPlayer(Player p) {

		this.allyPlayers.add(p);
	}

	public void addEnemyPlayer(Player p) {
		this.enemyPlayers.add(p);
		
	}
}
