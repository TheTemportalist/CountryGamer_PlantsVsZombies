package com.countrygamer.pvz.entities.mobs.plants;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;

public class EntityMoonShroom extends EntityShroomBase {
	public EntityMoonShroom(World par1World) {
		super(par1World, new ItemStack(PvZ.nightPlants, 1, 3));
	}

	public void dropFewItems(boolean par1, int par2) {
		dropItem(PvZ.moonlight, 2);
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();

		int r = 3;
		List<?> rEntities = this.worldObj.getEntitiesWithinAABB(
				EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.posX
						- r, this.posY - r, this.posZ - r, this.posX + r,
						this.posY + r, this.posZ + r));

		ArrayList<EntityLivingBase> otherMob = new ArrayList<EntityLivingBase>();
		boolean wave = false;

		for (int i = 0; i < rEntities.size(); i++) {
			EntityLivingBase ent = (EntityLivingBase) rEntities.get(i);

			if (ent.getCreatureAttribute() == PvZ.plantAttribute) {
				if (ent.getAITarget() != null) {
					wave = true;
					break;
				}
				wave = false;
			} else {
				rEntities.remove(ent);
				otherMob.add(ent);
			}
		}
		double z;
		/*
		 * if (!wave) { for (EntityLivingBase ent : rEntities) { if ((ent
		 * instanceof EntityShroomBase)) { if (ent.getHealth() !=
		 * ent.getMaxHealth()) { double x = ent.posX + 0.5D; double y = ent.posY
		 * + 0.5D; z = ent.posZ + 0.5D; } }
		 * 
		 * }
		 * 
		 * } else { for (EntityLivingBase ent : otherMob) {
		 * System.out.println("slowness"); ent.addPotionEffect(new
		 * PotionEffect(Potion.moveSlowdown.getId(), 500, 5)); } }
		 */
	}
}