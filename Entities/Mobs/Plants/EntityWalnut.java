package com.countrygamer.pvz.entities.mobs.plants;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;

public class EntityWalnut extends EntityPlantBase {
	public EntityWalnut(World par1World) {
		super(par1World, new ItemStack(PvZ.sunlight, 1, 0));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		setMaxHealth(PvZ.basePlantHealth * 16);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(
				this.baseHealth);
	}

	public void onEntityUpdate() {
		super.onEntityUpdate();

		int r = 10;
		List<?> rEntities = this.worldObj.getEntitiesWithinAABB(
				EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.posX
						- r, this.posY, this.posZ - r, this.posX + r,
						this.posY + 1.0D, this.posZ + r));

		ArrayList<EntityLivingBase> otherMob = new ArrayList<EntityLivingBase>();
		for (int i = 0; i < rEntities.size(); i++) {
			EntityLivingBase ent = (EntityLivingBase) rEntities.get(i);
			if ((ent.getCreatureAttribute() == PvZ.plantAttribute)
					|| ((ent instanceof EntityPlayer))) {
				rEntities.remove(ent);
				otherMob.add(ent);
			} else {
				if ((((EntityCreature) ent).getEntityToAttack() instanceof EntityWalnut))
					continue;
			}
		}
	}
}