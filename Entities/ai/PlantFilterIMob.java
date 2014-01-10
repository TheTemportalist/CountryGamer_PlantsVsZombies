package CountryGamer_PlantsVsZombies.Entities.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;

public class PlantFilterIMob implements IEntitySelector {

	public static PlantFilterIMob selector = new PlantFilterIMob();

	public boolean isEntityApplicable(Entity entity) {
		return entity instanceof IMob;
	}
}
