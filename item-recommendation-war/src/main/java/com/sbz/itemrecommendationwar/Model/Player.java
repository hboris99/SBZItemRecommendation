package com.sbz.itemrecommendationwar.Model;

import java.util.ArrayList;
import java.util.List;



public class Player {
	private PlayerClass playerClass;
	private List<Item> boughtItems = new ArrayList<>();
	private int currentGold;
	private int totalGold;
	private List<Item> recommendedItems = new ArrayList<>();
	private boolean isEnemy;
	private String name;
	private PlayerStats stats;
	private String statToItemize;
	public Player() {
		
	}
	
	public PlayerStats getStats() {
		return stats;
	}

	public void setStats(PlayerStats stats) {
		this.stats = stats;
	}

	public Player(PlayerClass playerClass, List<Item> boughtItems, int currentGold, int totalGold, List<Item> recommededItems, boolean isEnemy, String name, PlayerStats stats, String statToItemize ) {
		super();
		this.stats = stats;
		this.playerClass = playerClass;
		this.boughtItems = boughtItems;
		this.currentGold = currentGold;
		this.totalGold = totalGold;
		this.recommendedItems = recommededItems;
		this.isEnemy = isEnemy;
		this.name = name;
		this.statToItemize = statToItemize;
	}
	
	public String getStatToItemize() {
		return statToItemize;
	}

	public void setStatToItemize(String statToItemize) {
		this.statToItemize = statToItemize;
	}

	public void addPurchasedItem(Item item) {
		
		this.boughtItems.add(item);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnemy() {
		return isEnemy;
	}

	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
	}

	public List<Item> getRecommendedItems() {
		return recommendedItems;
	}

	public void setRecommendedItems(List<Item> recommendedItems) {
		this.recommendedItems = recommendedItems;
	}
	
	public void addRecommendedItem(Item item) {
		this.recommendedItems.add(item);
	}
	public PlayerClass getPlayerClass() {
		return playerClass;
	}
	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
	}
	public List<Item> getBoughtItems() {
		return boughtItems;
	}
	public void setBoughtItems(List<Item> boughtItems) {
		this.boughtItems = boughtItems;
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
	public boolean itemIsNotRecommended(String name) {
			for(Item i : getRecommendedItems()) {
				if(i.getName() == name) {
					System.out.println("This item is already recommended: " + i.getName());
					return false;
				}
			}
		
		return true;
	}
}
