package com.sbz.itemrecommendationwar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbz.itemrecommendationwar.Model.Item;
import com.sbz.itemrecommendationwar.Model.Player;
import com.sbz.itemrecommendationwar.Service.PlayerService;

@RestController
@RequestMapping("recommend")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void getRecommendation() {
		Player p = playerService.bestItem();
		for(Item i : playerService.findByName(p.getName()).getRecommendedItems())
		System.out.println(i.getName());
	}
	
}
