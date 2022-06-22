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
import com.sbz.itemrecommendationwar.Model.Player;
import com.sbz.itemrecommendationwar.Model.PlayerClass;
import com.sbz.itemrecommendationwar.Model.PlayerStats;
import com.sbz.itemrecommendationwar.Model.SpecialPassive;
import com.sbz.itemrecommendationwar.Repository.ItemRepository;
import com.sbz.itemrecommendationwar.Repository.PlayerRepository;


@Service
public class PlayerService{
	@Autowired
	KieContainer kieContainer;
	
	private final ItemRepository itemRepository = new ItemRepository();
	private final PlayerRepository playerRepository = new PlayerRepository();
	
	public Player bestStarterItem() {
		KieSession kieSession = kieContainer.newKieSession();
		
		List<Item> items = itemRepository.findAll();
		List<Player> enemyPlayers = playerRepository.findEnemy();
		List<Player> allyPlayers = playerRepository.findAlly();
		for(Item i : items) {
			
			kieSession.insert(i);
		}
		//NAPRAVI PLAYERA OVDE RETARDEEEEEEE
//		List<Item> p4Items = new ArrayList<>();
//		Player p4 = new Player(PlayerClass.TANK, p4Items,450, 500, new ArrayList<Item>());
//		kieSession.insert(p4);
//		kieSession.fireAllRules();
//
//		List<Item> p5Items = new ArrayList<>();
//		Player p5 = new Player(PlayerClass.MARKSMAN, p5Items,450, 500, new ArrayList<Item>());
//		kieSession.insert(p5);
		
		Player p = playerRepository.findByName("Teodor");
		kieSession.insert(p);
        kieSession.getAgenda().getAgendaGroup("starter").setFocus();
		kieSession.fireAllRules();
		return p;
	}
	public Player bestMythicItem() {
		List<Item> items = itemRepository.findAll();
		List<Player> enemyPlayers = playerRepository.findEnemy();
		List<Player> allyPlayers = playerRepository.findAlly();
		KieSession kieSession = kieContainer.newKieSession();
		for(Item i : items) {
			
			kieSession.insert(i);
		}
		Player p = playerRepository.findByName("Teodor");
		kieSession.insert(p);
        kieSession.getAgenda().getAgendaGroup("mythic").setFocus();
		kieSession.fireAllRules();
		return p;
	}
	public Player findByName(String name) {
		return playerRepository.findByName(name);
	}
	public Player bestNormalItem() {
		List<Item> items = itemRepository.findAll();
		List<Player> enemyPlayers = playerRepository.findEnemy();
		List<Player> allyPlayers = playerRepository.findAlly();
		KieSession kieSession = kieContainer.newKieSession();
		for(Item i : items) {
			
			kieSession.insert(i);
		}
		Player p = playerRepository.findByName("Teodor");
		kieSession.insert(p);
        kieSession.getAgenda().getAgendaGroup("normal").setFocus();
		kieSession.fireAllRules();
		return p;
	}
	
	public Player purchaseItem(int itemId) {
		Player p = playerRepository.findByName("Teodor");
		 KieSession kieSession = kieContainer.newKieSession();
		 kieSession.insert(p);
		 List<Player> enemies = playerRepository.findEnemy();
		 kieSession.insert(enemies);
		 List<Item> allItems = itemRepository.findAll();
		for(Item i :p.getRecommendedItems()) {
			if(i.getId() == itemId) {
				p.addPurchasedItem(i);
				updatePlayerStats(p, i , enemies);
				
			}
		}
		for(Item i : allItems) {
			kieSession.insert(i);
		}
		
		 kieSession.getAgenda().getAgendaGroup("first-purchase").setFocus();
			
			kieSession.fireAllRules();
		return p;
	}
	
	public void recommendUpdatedItems(Player p) {
		 KieSession kieSession = kieContainer.newKieSession();

	}
	public String determineDominantEnemyStats(List<Player> enemies) {
		List<String> dominantStatList = new ArrayList<>();
		Map<String, Integer> dominantStats = new HashMap<>();
		String stat = "";
		Integer count = 0;
		
		for(Player enemy: enemies) {
			for(Item i : enemy.getBoughtItems()) {
				updateEnemyStats(enemy, i);
				dominantStatList.add(i.getDominantStat());
			}
		}
		for(String stat1 : dominantStatList) {
			count = dominantStats.get(stat1);
			 if (count == null) {
	                count = 0;
	            }
				dominantStats.put(stat1, count + 1);
		}
		for(Map.Entry<String, Integer> entry : dominantStats.entrySet()) {
			if(entry.getValue() > count) {
				count = entry.getValue();
				stat = entry.getKey();
			}
		}
		switch(stat) {
		case "atkDmg":
			return "armour";
		case "abilityPower":
			return "magicResist";
		case "atkSpeed":
			return "hp";
		}
			return stat;
		
	}
	private void updateEnemyStats(Player p, Item i) {
		PlayerStats stats = p.getStats();
		stats.setAbilityPower( stats.getAbilityPower() + i.getAbilityPower());
		stats.setArmour(stats.getArmour() + i.getArmour());
		stats.setArmourPenetration(stats.getArmourPenetration() + i.getArmourPenetration());
		stats.setAttackDamage(stats.getAttackDamage()+ i.getAttackDamage());
		stats.setAttackSpeed(stats.getAttackSpeed() + i.getAttackSpeed());
		stats.setCriticalStrikeChance(stats.getCriticalStrikeChance() + i.getCriticalStrikeChance());
		stats.setHealthPoints(stats.getHealthPoints() + i.getHealthPoints());
		stats.setLethality(stats.getLethality() + i.getLethality());
			stats.setLifeSteal(stats.getLifeSteal() + i.getLifeSteal());
		stats.setMagicResist(stats.getMagicResist() + i.getMagicResist());
		stats.setMana(stats.getMana() + i.getMana());
		stats.setMovementSpeed(stats.getMovementSpeed() + i.getMovementSpeed());
		stats.addSpecialPassive(i.getSpecialPassive());
		p.setStats(stats);
	}
	private void updatePlayerStats(Player p, Item i, List<Player> enemy) {
		PlayerStats stats = p.getStats();
		stats.setAbilityPower( stats.getAbilityPower() + i.getAbilityPower());
		stats.setArmour(stats.getArmour() + i.getArmour());
		stats.setArmourPenetration(stats.getArmourPenetration() + i.getArmourPenetration());
		stats.setAttackDamage(stats.getAttackDamage()+ i.getAttackDamage());
		stats.setAttackSpeed(stats.getAttackSpeed() + i.getAttackSpeed());
		stats.setCriticalStrikeChance(stats.getCriticalStrikeChance() + i.getCriticalStrikeChance());
		stats.setHealthPoints(stats.getHealthPoints() + i.getHealthPoints());
		stats.setLethality(stats.getLethality() + i.getLethality());
			stats.setLifeSteal(stats.getLifeSteal() + i.getLifeSteal());
		stats.setMagicResist(stats.getMagicResist() + i.getMagicResist());
		stats.setMana(stats.getMana() + i.getMana());
		stats.setMovementSpeed(stats.getMovementSpeed() + i.getMovementSpeed());
		stats.addSpecialPassive(i.getSpecialPassive());
		p.setStats(stats);
		p.setStatToItemize(determineDominantEnemyStats(enemy));
	}
	public List<Item> getEnemyItems() {
		List<Player> enemies = playerRepository.findEnemy();
		Player player = playerRepository.findByName("Teodor");
		 List<Item> allItems = itemRepository.findAll();
		 KieSession kieSession = kieContainer.newKieSession();
		 kieSession.insert(player);
		 for(Player p : enemies) {
			 System.out.println(p);
			 System.out.println(p.getName());

			 kieSession.insert(p);
		 }
		 for(Item i : allItems) {
			 kieSession.insert(i);
		 }
		 
		 kieSession.getAgenda().getAgendaGroup("dominant-stat").setFocus();
		 kieSession.fireAllRules();
		 
		 List<Item> flattened = player.getDrlEnemyItems().stream().flatMap(List::stream).collect(Collectors.toList());
		 player.setEnemyItems(flattened);
		 countItemTypes();
		return player.getEnemyItems();
	}
	
	public void countItemTypes() {
		Player player = playerRepository.findByName("Teodor");
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(player);
		Map<Integer,String> num = new HashMap<Integer,String>();
		kieSession.setGlobal("frequency", num);
		kieSession.getAgenda().getAgendaGroup("itemizing").setFocus();
		kieSession.fireAllRules();
		System.out.println(player.getStatToItemize());
	}
}