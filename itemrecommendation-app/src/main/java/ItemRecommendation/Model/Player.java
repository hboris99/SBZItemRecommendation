package ItemRecommendation.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {
	private PlayerClass playerClass;
	private List<Item> boughtItems;
	private int currentGold;
	private int totalGold;
}
