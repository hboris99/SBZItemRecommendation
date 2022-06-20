package com.sbz.itemrecommendationwar.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@RequestMapping(value = "/starter", method = RequestMethod.GET)
	public void getRecommendation() {
		Player p = playerService.bestStarterItem();
		for(Item i : playerService.findByName(p.getName()).getRecommendedItems())
		System.out.println("These are the starter items recommended: " + i.getName());
	}
	@RequestMapping(value = "/mythic", method = RequestMethod.GET)
	public void getMythicRecommend() {
		Player p = playerService.bestMythicItem();
		for(Item i : playerService.findByName(p.getName()).getRecommendedItems())
		System.out.println("These are the normal items recommended: " + i.getName());
	}
	@RequestMapping(value = "/normal", method = RequestMethod.GET)
	public void getNormalRecommend() {
		Player p = playerService.bestNormalItem();
		for(Item i : playerService.findByName(p.getName()).getRecommendedItems())
		System.out.println("These are the mythic items recommended: " + i.getName());
	}
	
	@PutMapping(value = "/purchase/{id}")
	public ResponseEntity<Player> purchaseItem(@PathVariable int id) {
		Player p = playerService.purchaseItem(id);
		for(Item i : playerService.findByName(p.getName()).getRecommendedItems())
			System.out.println("These are the items recommended after a purchase: " + i.getName());
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	
}
