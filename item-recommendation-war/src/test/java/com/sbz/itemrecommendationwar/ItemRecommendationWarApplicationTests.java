package com.sbz.itemrecommendationwar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sbz.itemrecommendationwar.Model.Item;
import com.sbz.itemrecommendationwar.Model.ItemBuyEvent;
import com.sbz.itemrecommendationwar.Model.Player;
import com.sbz.itemrecommendationwar.Model.PlayerClass;
import com.sbz.itemrecommendationwar.Model.PlayerStats;
import com.sbz.itemrecommendationwar.Model.SpecialPassive;
import com.sbz.itemrecommendationwar.Repository.ItemRepository;
import com.sbz.itemrecommendationwar.Service.ItemService;
import com.sbz.itemrecommendationwar.Service.PlayerService;

@SpringBootTest
class ItemRecommendationWarApplicationTests {

	@Autowired
	private KieSession kie;
	@Autowired 
	private PlayerService playerService;
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void starterItem() {
		
		List<Item> items = itemRepository.findAll();
		for(Item i : items) {
			kie.insert(i);
		}
		List<Item> p1Items = new ArrayList<>();
		Player p1 = new Player(PlayerClass.MARKSMAN, new ArrayList<Item>(),2800, 6200, new ArrayList<Item>(), true, "Isidor", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
		kie.insert(p1);
		kie.getAgenda().getAgendaGroup("starter").setFocus();
		int fired = kie.fireAllRules();
		
		Item doransSword = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "atkDmg");
		
		playerService.update(p1);
		kie.dispose();

		assertEquals(1, fired);
		assertEquals(p1.getRecommendedItems().get(0).getName(),doransSword.getName() );
	
	}
	
	
	@Test
	public void multipleEventsNeeded() {
		
		List<Item> items = itemRepository.findAll();
		for(Item i : items) {
			kie.insert(i);
		}
		List<Item> p1Items = new ArrayList<>();
		Item doransSword = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "marksman");
		Item doransSword2 = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "marksman");
		p1Items.add(doransSword);
		p1Items.add(doransSword2);
		Player p1 = new Player(PlayerClass.MARKSMAN,p1Items,2800, 6200, new ArrayList<Item>(), true, "Isidor", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
		kie.insert(p1);

		Player p2 = new Player(PlayerClass.MARKSMAN, new ArrayList<Item>(),2800, 6200, new ArrayList<Item>(), false, "Isidor", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
		kie.insert(p2);
		kie.insert(new ItemBuyEvent(p1.getName(), p2.getName()));

		kie.getAgenda().getAgendaGroup("purchase").setFocus();
		int fired = kie.fireAllRules();
		
		Item doransSword3 = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "atkDmg");
		kie.dispose();

		assertEquals(0, fired);
	
	}
	
	@Test
	public void multipleEventsWorks() {
		
		List<Item> items = itemRepository.findAll();
		for(Item i : items) {
			kie.insert(i);
		}
		List<Item> p1Items = new ArrayList<>();
		Item doransSword = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "marksman");
		Item doransSword2 = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "marksman");
		p1Items.add(doransSword);
		p1Items.add(doransSword2);
		Player p1 = new Player(PlayerClass.MARKSMAN,p1Items,2800, 6200, new ArrayList<Item>(), true, "Isidor", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
		kie.insert(p1);

		Player p2 = new Player(PlayerClass.MARKSMAN, new ArrayList<Item>(),2800, 6200, new ArrayList<Item>(), false, "Isidor", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
		kie.insert(p2);
		kie.insert(new ItemBuyEvent(p1.getName(), p2.getName()));
		kie.insert(new ItemBuyEvent(p1.getName(), p2.getName()));

		kie.getAgenda().getAgendaGroup("purchase").setFocus();
		int fired = kie.fireAllRules();
		kie.dispose();
		Item doransSword3 = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "atkDmg");
		
		assertEquals(1, fired);
	
	}
	
//	@Test
//	public void noNewItemsAdded() {
//		
//		KieSession kie = kieContainer.newKieSession();
//		List<Item> items = itemRepository.findAll();
//		for(Item i : items) {
//			kie.insert(i);
//		}
//		List<Item> p1Items = new ArrayList<>();
//		Player p1 = new Player(PlayerClass.MARKSMAN, p1Items,2800, 6200, new ArrayList<Item>(), true, "Isidor", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
//		kie.insert(p1);
//		Player p2 = new Player(PlayerClass.MARKSMAN, p1Items,2800, 6200, new ArrayList<Item>(), false, "Marko", new PlayerStats(), "",new ArrayList<Item>(), new ArrayList< List<Item>>());
//		
//		kie.getAgenda().getAgendaGroup("starter");
//		int fired = kie.fireAllRules();
//		
//		Item doransSword = new Item(2, PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
//				   0, 0, 0.0, false, 450, 5, 0, 0.0, false, "atkDmg");
//		
//		playerService.update(p1);
//		assertEquals(fired, 1);
//		assertEquals(p1.getRecommendedItems().get(0),doransSword )
//		
//		
//	}

}
