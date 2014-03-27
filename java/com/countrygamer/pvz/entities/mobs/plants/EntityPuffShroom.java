package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;

public class EntityPuffShroom extends EntityShroomShooterBase {
	public EntityPuffShroom(World world) {
		super(world, new ItemStack(PvZ.nightPlants, 1, 0));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		setMaxHealth(PvZ.basePlantHealth / 2);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(
				this.baseHealth);
	}

	public void dropFewItems(boolean par1, int par2) {
		dropItem(PvZ.shroomPod, 1);
	}

	public void onUpdate() {
		super.onUpdate();
		int lightBright = this.worldObj.getBlockLightValue((int) this.posX,
				(int) this.posY, (int) this.posZ);

		if ((this.worldObj != null)
				&& (!this.worldObj.isRemote)
				&& (((this.worldObj.getWorldTime() < 0L) || (this.worldObj
						.getWorldTime() > 12000L)) || ((this.worldObj
						.getWorldTime() >= 12000L) && (this.worldObj
						.getWorldTime() <= 23999L))))
			;
	}
}