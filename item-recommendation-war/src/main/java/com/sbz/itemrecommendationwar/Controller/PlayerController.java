package com.sbz.itemrecommendationwar.Controller;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbz.itemrecommendationwar.DTO.PlayerDTO;
import com.sbz.itemrecommendationwar.Model.Item;
import com.sbz.itemrecommendationwar.Model.Player;
import com.sbz.itemrecommendationwar.Service.PlayerService;

@RestController
@RequestMapping("recommend")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	
	@PostMapping(value = "/addAlly")
	public ResponseEntity<Player> registerAlly(@RequestBody PlayerDTO dto){
		dto.setBoughtItems(new ArrayList<Item>());
		dto.setDrlEnemyItems(new ArrayList<List<Item>>());
		dto.setRecommendedItems(new ArrayList<>());
		dto.setEnemyItems(new ArrayList<Item>());
		Player p = new Player(dto.getPlayerClass(), dto.getBoughtItems(), dto.getCurrentGold(),
				dto.getTotalGold(), dto.getRecommendedItems(), dto.isEnemy(), dto.getName(),
				dto.getStats(), dto.getStatToItemize(), dto.getEnemyItems(), dto.getDrlEnemyItems());
		playerService.addAllyPlayer(p);
		playerService.bestStarterItem(p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/addEnemy")
	public ResponseEntity<Player> registerEnemy(@RequestBody PlayerDTO dto){
		dto.setBoughtItems(new ArrayList<Item>());
		dto.setDrlEnemyItems(new ArrayList<List<Item>>());
		dto.setRecommendedItems(new ArrayList<>());
		dto.setEnemyItems(new ArrayList<Item>());
		Player p = new Player(dto.getPlayerClass(), dto.getBoughtItems(), dto.getCurrentGold(),
				dto.getTotalGold(), dto.getRecommendedItems(), dto.isEnemy(), dto.getName(),
				dto.getStats(), dto.getStatToItemize(), dto.getEnemyItems(), dto.getDrlEnemyItems());
		playerService.addEnemyPlayer(p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/{name}/purchase/{id}")
	public ResponseEntity<Player> allyPurchaseItem(@PathVariable String name ,@PathVariable int id ) {
		Player p = playerService.purchaseStarterItem(name, id);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PutMapping(value = "/enemy/{name}/purchase/{id}")
	public ResponseEntity<List<Item>> enemyPurchasedItem(@PathVariable String name, @PathVariable int id, @RequestBody PlayerDTO dto){
		
		List<Item> p = playerService.enemyPurchaseItem(dto.getName(), name, id);
		
		return new ResponseEntity<List<Item>>(p, HttpStatus.OK);
		
	}
	
	
	
}
