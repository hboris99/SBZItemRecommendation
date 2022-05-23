package com.sbz.itemrecommendationwar.Repository;
import com.sbz.itemrecommendationwar.Model.*;
import java.util.ArrayList;
import java.util.List;


public class ItemRepository  {
	private List<Item> allItems = new ArrayList<Item>();
	public ItemRepository() {
		Item doransShield = new Item(PlayerClass.TANK, "Dorans Shield", 200, 0, 0.0, 0, SpecialPassive.NONE, 0, 0, 
				   0, 0, 0.0, true, 450, 0, 0, 0.0, false);
		Item doransSword = new Item(PlayerClass.MARKSMAN, "Dorans sword", 150, 0, 0.0, 0, SpecialPassive.NONE, 8, 0, 
				   0, 0, 0.0, false, 450, 5, 0, 0.0, false);
		Item sunfireCape = new Item(PlayerClass.TANK, "Sunfire cape", 300, 0, 0.0, 0, SpecialPassive.BURN_ENEMIES, 0, 0, 
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
		Item locket = new Item(PlayerClass.MARKSMAN, "locket", 300, 0, 0.0, 0, SpecialPassive.BURN_ENEMIES, 0, 0, 
				   50, 40, 0.0, false, 3400, 0, 0, 0.0, true);
		
		allItems.add(doransShield);
		allItems.add(doransSword);
		allItems.add(sunfireCape);
		allItems.add(fimbulWinter);
		allItems.add(warmogsArmour);
		allItems.add(shieldBow);
		allItems.add(phantomDancer);
		allItems.add(infinityEdge);
		allItems.add(locket);
 
	}
	public List<Item> findAll(){
		return allItems;
	}
	public Item findItemByName(String name) {
		for(Item i : allItems) {
			if(i.getName().equals(name)) {
				return i;
			}
		}
		return new Item("Not Found");
	}
}
