package com.sbz.itemrecommendationwar.Model;


public class Item {
	
	private int id;
	private PlayerClass playerClass;
	private String name;
	private int healthPoints;
	private int mana;
	private double armourPenetration;
	private int lethality;
	private SpecialPassive specialPassive;
	private int attackDamage;
	private int abilityPower;
	private int armour;
	private int magicResist;
	private double criticalStrikeChance;
	private boolean isStarting;
	private int price;
	private int lifeSteal;
	private int movementSpeed;
	private double attackSpeed;
	private boolean isMythic;
	public String dominantStat;
	
	public int getId() {
		return id;
	}

	public String getDominantStat() {
		return dominantStat;
	}

	public void setDominantStat(String dominantStat) {
		this.dominantStat = dominantStat;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item() {}
	
	public Item(int id, PlayerClass playerClass, String name, int healthPoints, int mana, double armourPenetration,
			int lethality, SpecialPassive specialPassive, int attackDamage, int abilityPower, int armour,
			int magicResist, double criticalStrikeChance, boolean isStarting, int price, int lifeSteal,
			int movementSpeed, double attackSpeed, boolean isMythic, String dominantStat) {
		super();
		this.id = id;
		this.dominantStat = dominantStat;
		this.playerClass = playerClass;
		this.name = name;
		this.healthPoints = healthPoints;
		this.mana = mana;
		this.armourPenetration = armourPenetration;
		this.lethality = lethality;
		this.specialPassive = specialPassive;
		this.attackDamage = attackDamage;
		this.abilityPower = abilityPower;
		this.armour = armour;
		this.magicResist = magicResist;
		this.criticalStrikeChance = criticalStrikeChance;
		this.isStarting = isStarting;
		this.price = price;
		this.lifeSteal = lifeSteal;
		this.movementSpeed = movementSpeed;
		this.attackSpeed = attackSpeed;
		this.isMythic = isMythic;
	}
	public Item(String string) {
		this.name = string;
	}

	public boolean getIsMythic() {
		return isMythic;
	}

	public void setMythic(boolean isMythic) {
		this.isMythic = isMythic;
	}

	public PlayerClass getPlayerClass() {
		return playerClass;
	}
	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public double getArmourPenetration() {
		return armourPenetration;
	}
	public void setArmourPenetration(double armourPenetration) {
		this.armourPenetration = armourPenetration;
	}
	public int getLethality() {
		return lethality;
	}
	public void setLethality(int lethality) {
		this.lethality = lethality;
	}
	public SpecialPassive getSpecialPassive() {
		return specialPassive;
	}
	public void setSpecialPassive(SpecialPassive specialPassive) {
		this.specialPassive = specialPassive;
	}
	public int getAttackDamage() {
		return attackDamage;
	}
	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	public int getAbilityPower() {
		return abilityPower;
	}
	public void setAbilityPower(int abilityPower) {
		this.abilityPower = abilityPower;
	}
	public int getArmour() {
		return armour;
	}
	public void setArmour(int armour) {
		this.armour = armour;
	}
	public int getMagicResist() {
		return magicResist;
	}
	public void setMagicResist(int magicResist) {
		this.magicResist = magicResist;
	}
	public double getCriticalStrikeChance() {
		return criticalStrikeChance;
	}
	public void setCriticalStrikeChance(double criticalStrikeChance) {
		this.criticalStrikeChance = criticalStrikeChance;
	}
	public boolean isStarting() {
		return isStarting;
	}
	public void setStarting(boolean isStarting) {
		this.isStarting = isStarting;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getLifeSteal() {
		return lifeSteal;
	}
	public void setLifeSteal(int lifeSteal) {
		this.lifeSteal = lifeSteal;
	}
	public int getMovementSpeed() {
		return movementSpeed;
	}
	public void setMovementSpeed(int movementSpeed) {
		this.movementSpeed = movementSpeed;
	}
	public double getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	
}
