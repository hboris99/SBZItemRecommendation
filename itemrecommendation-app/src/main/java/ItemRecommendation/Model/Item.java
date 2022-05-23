package ItemRecommendation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
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
	private Boolean isStarting;
	private int price;
	private int lifeSteal;
	private int movementSpeed;
	private double attackSpeed;
	
}
