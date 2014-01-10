package CountryGamer_PlantsVsZombies.Entities.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class EntityAIPlantTargetSelector implements IEntitySelector {
	final IEntitySelector field_111103_c;

	final EntityAIPlantTarget entityAiPlantTarget;

	public EntityAIPlantTargetSelector(
			EntityAIPlantTarget par1EntityAINearestAttackableTarget,
			IEntitySelector par2IEntitySelector) {
		this.entityAiPlantTarget = par1EntityAINearestAttackableTarget;
		this.field_111103_c = par2IEntitySelector;
	}

	/**
	 * Return whether the specified entity is applicable to this filter.
	 */
	public boolean isEntityApplicable(Entity par1Entity) {
		return !(par1Entity instanceof EntityLivingBase) ? false
				: (this.field_111103_c != null
						&& !this.field_111103_c.isEntityApplicable(par1Entity) ? false
						: this.entityAiPlantTarget.isSuitableTarget(
								(EntityLivingBase) par1Entity, false));
	}
}
