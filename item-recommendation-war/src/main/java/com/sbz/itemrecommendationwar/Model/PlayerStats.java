package com.sbz.itemrecommendationwar.Model;

import java.util.ArrayList;
import java.util.List;

public class PlayerStats {
	private int healthPoints;
	private int mana;
	private double armourPenetration;
	private int lethality;
	private List<SpecialPassive> specialPassive = new ArrayList();
	private int attackDamage;
	private int abilityPower;
	private int armour;
	private int magicResist;
	private double criticalStrikeChance;
	
	public PlayerStats() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlayerStats(int healthPoints, int mana, double armourPenetration, int lethality,
			List<SpecialPassive> specialPassive, int attackDamage, int abilityPower, int armour, int magicResist,
			double criticalStrikeChance, int lifeSteal, int movementSpeed,
			double attackSpeed) {
		super();
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
	
		this.lifeSteal = lifeSteal;
		this.movementSpeed = movementSpeed;
		this.attackSpeed = attackSpeed;
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
	public List<SpecialPassive> getSpecialPassive() {
		return specialPassive;
	}
	public void setSpecialPassive(List<SpecialPassive> specialPassive) {
		this.specialPassive = specialPassive;
	}
	public void addSpecialPassive(SpecialPassive specialPassive) {
		this.specialPassive.add(specialPassive);
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
	private int lifeSteal;
	private int movementSpeed;
	private double attackSpeed;

}
