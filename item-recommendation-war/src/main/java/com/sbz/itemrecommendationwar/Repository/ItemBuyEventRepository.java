package com.sbz.itemrecommendationwar.Repository;

import java.util.ArrayList;
import java.util.List;

import com.sbz.itemrecommendationwar.Model.ItemBuyEvent;

public class ItemBuyEventRepository {
	List<ItemBuyEvent> events = new ArrayList<ItemBuyEvent>();
			
	public void addEvent(ItemBuyEvent e) {
		this.events.add(e);
	}
}
