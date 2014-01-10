package CountryGamer_PlantsVsZombies.Entities.ai;

import java.util.Comparator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;

public class EntityAIPlantTargetSorter implements Comparator {
	private final Entity theEntity;
	private final Class likeEntity;
	private final EntityAIPlantTarget aiTarget;

	public EntityAIPlantTargetSorter(EntityAIPlantTarget aiTarget,
			Entity ownerEntity) {
		this(aiTarget, ownerEntity, ownerEntity.getClass());
	}

	public EntityAIPlantTargetSorter(EntityAIPlantTarget aiTarget,
			Entity ownerEntity, Class searchLikeEntity) {
		this.aiTarget = aiTarget;
		this.theEntity = ownerEntity;
		this.likeEntity = searchLikeEntity;
	}

	public int compareDistanceSq(Entity entity1, Entity entity2) {
		/*
		 * double distanceTo1 = this.theEntity.getDistanceSqToEntity(entity1);
		 * double distanceTo2 = this.theEntity.getDistanceSqToEntity(entity2);
		 * if (distanceTo1 < distanceTo2) return -1; // entity1 higher priority
		 * than entity2 else if (distanceTo1 > distanceTo2) return 1; // entity2
		 * higher priority than entity1 else return 0; // do nothing
		 */

		// New Code
		// 1: get all targeting plants in the area
		// 2: for each plant, if this entity is targetted, decrement the
		// priority
		List list = this.theEntity.worldObj.selectEntitiesWithinAABB(
				this.likeEntity, this.theEntity.boundingBox.expand(
						this.aiTarget.range, 4.0D, this.aiTarget.range), null);

		for (Object likeEntity : list) {
			if (likeEntity != null && likeEntity instanceof EntityCreature) {
				EntityLivingBase likeEntTarget = ((EntityCreature) likeEntity)
						.getAttackTarget();
				if (this.isSameEntity(entity1, likeEntTarget)) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 0;
	}

	public int compare(Object par1Obj, Object par2Obj) {
		return this.compareDistanceSq((Entity) par1Obj, (Entity) par2Obj);
	}

	private boolean isSameEntity(Entity ent1, Entity ent2) {
		double x1 = ent1.posX, y1 = ent1.posY, z1 = ent1.posZ;
		double x2 = ent2.posX, y2 = ent2.posY, z2 = ent2.posZ;
		if (x1 == x2 && y1 == y2 && z1 == z2)
			return true;
		else
			return false;
	}
}
