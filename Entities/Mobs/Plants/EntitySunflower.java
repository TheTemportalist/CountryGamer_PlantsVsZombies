package com.countrygamer.pvz.entities.mobs.plants;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;

public class EntitySunflower extends EntityPlantBase {
	private int delayControl = 600;

	public EntitySunflower(World par1World) {
		super(par1World, new ItemStack(PvZ.basicPlants, 1, 0));
	}

	public void dropFewItems(boolean par1, int par2) {
		dropItem(PvZ.sunlight, 2);
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

		int delay = this.delayControl;
		if (delay > 0) {
			delay--;
			return;
		}
		System.out.println("Delay wave check");
		delay = this.delayControl;
		double z;
		/*
		 * if (!wave) { for (EntityLivingBase ent : rEntities) { if (!(ent
		 * instanceof EntityShroomBase)) { if (ent.getHealth() !=
		 * ent.getMaxHealth()) { if (ent != this) ent.heal(ent.getMaxHealth());
		 * double x = ent.posX + 0.5D; double y = ent.posY + 0.5D; z = ent.posZ
		 * + 0.5D; } }
		 * 
		 * }
		 * 
		 * } else { for (EntityLivingBase ent1 : otherMob) if (!(ent1 instanceof
		 * EntityPlayer)) { System.out.println("slowness");
		 * ent1.addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(),
		 * 500, 5)); } }
		 */
	}
}