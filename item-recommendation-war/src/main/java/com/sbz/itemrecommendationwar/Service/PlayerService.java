package com.sbz.itemrecommendationwar.Service;

import java.util.ArrayList;
import java.util.List;

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
	    System.out.println(p.getName());
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
	    System.out.println(p.getName());
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
	    System.out.println(p.getName());
		kieSession.insert(p);
        kieSession.getAgenda().getAgendaGroup("normal").setFocus();
		kieSession.fireAllRules();
		return p;
	}
	
	public Player purchaseItem(int itemId) {
		Player p = playerRepository.findByName("Teodor");
		KieSession kieSession = kieContainer.newKieSession();
		String var = determineDominantEnemyStats();
		System.out.println(var);
		kieSession.setGlobal("dominantStat", var);
		for(Item i :itemRepository.findAll()) {
			if(i.getId() == itemId) {
				p.addPurchasedItem(i);
				updatePlayerStats(p, i );
				
			}
			kieSession.insert(i);

		}
		
		Player enemies = playerRepository.findEnemy().get(0);
		kieSession.insert(p);
		kieSession.insert(enemies);
		 kieSession.getAgenda().getAgendaGroup("normal").setFocus();
			kieSession.fireAllRules();
		return p;
	}
	public String determineDominantEnemyStats() {
		Player enemies = playerRepository.findEnemy().get(0);
		enemies.addPurchasedItem(new Item(8, PlayerClass.MARKSMAN, "Infinity Edge", 0, 0, 0.0, 0, SpecialPassive.INCREASE_CRIT, 65, 0, 
				   0, 0, 0.2, false, 3200, 0, 0, 0.0, false));
		
			int abilityPower = enemies.getStats().getAbilityPower();
			System.out.print(abilityPower);
			int attackDamage = enemies.getStats().getAttackDamage();
			System.out.print(attackDamage);

			if(attackDamage > abilityPower) {
				return "atkdmg";
			}
			return "ability";
		
	}
	private void updatePlayerStats(Player p, Item i) {
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
}