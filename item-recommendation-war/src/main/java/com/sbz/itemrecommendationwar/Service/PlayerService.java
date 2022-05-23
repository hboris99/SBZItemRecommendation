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
import com.sbz.itemrecommendationwar.Repository.ItemRepository;
import com.sbz.itemrecommendationwar.Repository.PlayerRepository;


@Service
public class PlayerService{
	@Autowired
	KieContainer kieContainer;
	
	private final ItemRepository itemRepository = new ItemRepository();
	private final PlayerRepository playerRepository = new PlayerRepository();
	
	public Player bestItem() {
		KieSession kieSession = kieContainer.newKieSession();
		
		List<Item> items = itemRepository.findAll();
		List<Player> enemyPlayers = playerRepository.findEnemy();
		List<Player> allyPlayers = playerRepository.findAlly();
		for(Item i : items) {
			if(i.isMythic() && i.getPlayerClass().equals(PlayerClass.MARKSMAN))
				System.out.println("Added this mythic marksman item into the session: " + i.getName());
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
		kieSession.fireAllRules();
		return p;
	}
	public Player findByName(String name) {
		return playerRepository.findByName(name);
	}
}