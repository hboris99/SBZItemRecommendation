package com.sbz.itemrecommendationwar.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbz.itemrecommendationwar.Model.Item;
import com.sbz.itemrecommendationwar.Model.ItemBuyEvent;
import com.sbz.itemrecommendationwar.Model.Player;
import com.sbz.itemrecommendationwar.Model.PlayerClass;
import com.sbz.itemrecommendationwar.Model.PlayerStats;
import com.sbz.itemrecommendationwar.Model.SpecialPassive;
import com.sbz.itemrecommendationwar.Repository.ItemRepository;
import com.sbz.itemrecommendationwar.Repository.PlayerRepository;


@Service
public class PlayerService{
	
	@Autowired
	private KieSession kieSession;
	
	private ItemRepository itemRepository = new ItemRepository();
	private PlayerRepository playerRepository = new PlayerRepository();
	
	
	
	
	public void addAllyPlayer(Player p) {
		playerRepository.addAllyPlayer(p);
	}
	
	public Player bestStarterItem(Player p) {
		
		List<Item> items = itemRepository.findAll();
		for(Item i : items) {
			
			kieSession.insert(i);
		}
		kieSession.insert(p);
        kieSession.getAgenda().getAgendaGroup("starter").setFocus();
		kieSession.fireAllRules();
		return p;
	}

	public Player purchaseStarterItem(String name, int itemId) {
		Player p = playerRepository.findAllyByName(name);
		kieSession.insert(p);
		List<Item> allItems = itemRepository.findAll();
		List<Player> enemies = playerRepository.findEnemy();
		
		kieSession.getAgenda().getAgendaGroup("purchase-starter").setFocus();
		kieSession.fireAllRules();
		List<Item> r = p.getRecommendedItems();
		r.removeIf(i -> (i.getSpecialPassive().equals(SpecialPassive.NONE)));
		p.setRecommendedItems(r);
		return p;
	}
	
	

	
	public List<Item> enemyPurchaseItem(String ally , String name, int id) {
		Player enemy = playerRepository.findEnemyByName(name);
		Player allyPlayer = playerRepository.findAllyByName(ally);

		Item i = itemRepository.findById(id);
		enemy.addPurchasedItem(i);
		
		kieSession.insert(new ItemBuyEvent(enemy.getName(), ally));
		kieSession.getAgenda().getAgendaGroup("purchase").setFocus();
		kieSession.fireAllRules();
		System.out.println(enemy.getBoughtItems());
		List<Item> items = getEnemyItems(allyPlayer, i);
		System.out.println(items);
		return allyPlayer.getRecommendedItems();
	}
	
	public List<Item> getEnemyItems(Player player, Item item) {
		 List<Item> allItems = itemRepository.findAll();
		
		 
		 
		 kieSession.getAgenda().getAgendaGroup("dominant-stat").setFocus();
		 kieSession.fireAllRules();
		 
		 List<Item> flattened = player.getDrlEnemyItems().stream().flatMap(List::stream).collect(Collectors.toList());
		 for(Item i : flattened) {
			 System.out.println(i.getName());
			 System.out.println(i.getPlayerClass());

		 }
		 player.setEnemyItems(flattened);
		 countItemTypes(player);
		return player.getEnemyItems();
	}
	
	public List<Item> countItemTypes(Player player) {
		
		kieSession.getAgenda().getAgendaGroup("itemizing").setFocus();
		kieSession.fireAllRules();
		System.out.println(player.getStatToItemize());
		return recommendNewItems(player);
	}
	
	public List<Item> recommendNewItems(Player player){
		player.setBoughtItems(new ArrayList<Item>());
		kieSession.getAgenda().getAgendaGroup("purchase").setFocus();
		kieSession.fireAllRules();

		player.filterList();
			
		
			
		return player.getRecommendedItems();
		
	}
	
	public void addEnemyPlayer(Player p) {
		playerRepository.addEnemyPlayer(p);
		kieSession.insert(p);
		List<Player> enemies = playerRepository.findEnemy();

		 for(Player pl : enemies) {
			 System.out.println(p);
			 System.out.println(p.getName());
			 if(!pl.getName().equals(p.getName()))
				 kieSession.insert(pl);

		 }
		
	}

	
}