package com.sbz.itemrecommendationwar.DTO;

import java.util.List;

import com.sbz.itemrecommendationwar.Model.Item;
import com.sbz.itemrecommendationwar.Model.PlayerClass;
import com.sbz.itemrecommendationwar.Model.PlayerStats;

public class PlayerDTO {
	public String name;
	public List<Item> boughtItems;
	public List<Item> recommendedItems;
	public boolean isEnemy;
	public int currentGold;
	public int totalGold;
	public PlayerStats stats;
	public String statToItemize;
	public List<Item> enemyItems;
	public List<List<Item>> drlEnemyItems;
	public PlayerClass playerClass;
	public PlayerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlayerDTO(String name, List<Item> boughtItems, List<Item> recommendedItems, boolean isEnemy, int currentGold,
			int totalGold, PlayerStats stats, String statToItemize, List<Item> enemyItems,
			List<List<Item>> drlEnemyItems, PlayerClass playerClass) {
		super();
		this.name = name;
		this.boughtItems = boughtItems;
		this.recommendedItems = recommendedItems;
		this.isEnemy = isEnemy;
		this.currentGold = currentGold;
		this.totalGold = totalGold;
		this.stats = stats;
		this.statToItemize = statToItemize;
		this.enemyItems = enemyItems;
		this.drlEnemyItems = drlEnemyItems;
		this.playerClass = playerClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Item> getBoughtItems() {
		return boughtItems;
	}
	public void setBoughtItems(List<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}
	public List<Item> getRecommendedItems() {
		return recommendedItems;
	}
	public void setRecommendedItems(List<Item> recommendedItems) {
		this.recommendedItems = recommendedItems;
	}
	public boolean isEnemy() {
		return isEnemy;
	}
	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
	}
	public int getCurrentGold() {
		return currentGold;
	}
	public void setCurrentGold(int currentGold) {
		this.currentGold = currentGold;
	}
	public int getTotalGold() {
		return totalGold;
	}
	public void setTotalGold(int totalGold) {
		this.totalGold = totalGold;
	}
	public PlayerStats getStats() {
		return stats;
	}
	public void setStats(PlayerStats stats) {
		this.stats = stats;
	}
	public String getStatToItemize() {
		return statToItemize;
	}
	public void setStatToItemize(String statToItemize) {
		this.statToItemize = statToItemize;
	}
	public List<Item> getEnemyItems() {
		return enemyItems;
	}
	public void setEnemyItems(List<Item> enemyItems) {
		this.enemyItems = enemyItems;
	}
	public List<List<Item>> getDrlEnemyItems() {
		return drlEnemyItems;
	}
	public void setDrlEnemyItems(List<List<Item>> drlEnemyItems) {
		this.drlEnemyItems = drlEnemyItems;
	}
	public PlayerClass getPlayerClass() {
		return playerClass;
	}
	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
	}
}
