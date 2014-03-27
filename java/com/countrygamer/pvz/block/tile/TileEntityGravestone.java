package com.countrygamer.pvz.block.tile;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;

import com.countrygamer.pvz.lib.Resources;
import com.countrygamer.pvz.lib.Util;

public class TileEntityGravestone extends TileEntity {
	public int facing = -1;
	public int type = 0;
	public ResourceLocation[] typeTexture = { Resources.gravestone,
			Resources.gravestoneReg, Resources.gravestoneFootball,
			Resources.gravestoneFlag, Resources.gravestoneCone,
			Resources.gravestoneBucket };

	private double spawnDelay = 120.0D;
	private int maxNearbyEntities = 10;

	public void updateEntity() {
		double spawnDelay = this.spawnDelay;

		if (!getWorldObj().isRemote) {
			if (spawnDelay > 0.0D) {
				spawnDelay -= 1.0D;
				return;
			}

			if (this.facing == -1) {
				this.facing = 0;
				System.out.println("facing was -1");
			}

			Entity entity = new EntityZombie(getWorldObj());

			List<?> entList = getWorldObj().getEntitiesWithinAABB(
					entity.getClass(),
					AxisAlignedBB.getAABBPool()
							.getAABB(this.xCoord - 3.0D, this.yCoord,
									this.zCoord - 3.0D, this.xCoord + 3.0D,
									this.yCoord, this.zCoord + 3.0D));

			int j = entList.size();
			if (j >= this.maxNearbyEntities) {
				return;
			}
			Util.checkUnder(getWorldObj(), this.xCoord, this.yCoord,
					this.zCoord, 4);
			System.out.println("Spawn wave");

			Util.spawnRandZombie(this.worldObj, this.xCoord, this.yCoord,
					this.zCoord, this.facing, this.type);

			spawnDelay = this.spawnDelay;
		}
		super.updateEntity();
	}

	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);

		this.facing = par1NBTTagCompound.getShort("Facing");
		this.facing = par1NBTTagCompound.getShort("Type");
	}

	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("Facing", (short) this.facing);
		par1NBTTagCompound.setShort("Type", (short) this.type);
		NBTTagList nbttaglist = new NBTTagList();
	}
}