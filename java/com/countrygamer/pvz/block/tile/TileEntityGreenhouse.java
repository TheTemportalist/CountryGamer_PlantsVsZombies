package com.countrygamer.pvz.block.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

import com.countrygamer.core.Base.common.tileentity.TileEntityInventoryBase;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.lib.Util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityGreenhouse extends TileEntityInventoryBase {

	private static final int[] input = { 0 };
	private static final int[] modify = { 1, 2, 3 };
	private static final int[] output = { 4 };
	public int plantUpgradeTime;
	public int plantUpgradeTime1 = 400;
	public int upgradeSpeed;
	public int upgradeMultiplyer;
	public int upgradeSpecial;

	public TileEntityGreenhouse() {
		super("Greenhouse", 5, 64);
	}

	// Client Server Sync
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		NBTTagCompound tagCom = pkt.func_148857_g();
		this.readFromNBT(tagCom);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tagCom = new NBTTagCompound();
		this.writeToNBT(tagCom);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord,
				this.zCoord, this.blockMetadata, tagCom);
	}

	public void markDirty() {
		super.markDirty();
		this.getWorldObj().scheduleBlockUpdate(this.xCoord, this.yCoord,
				this.zCoord, PvZ.greenhouse, 10);
	}
	
	public void resync(int delay) {
		super.markDirty();
		this.getWorldObj().scheduleBlockUpdate(this.xCoord, this.yCoord,
				this.zCoord, PvZ.greenhouse, delay);
	}

	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return Util.greenhouseSlotCheck(i, itemStack);
	}

	public int[] getAccessibleSlotsFromSide(int var1) {
		if (var1 == 0) {
			return output;
		}
		if (var1 == 1) {
			return input;
		}
		if ((var1 == 2) || (var1 == 3)) {
			return modify;
		}
		return null;
	}

	public boolean canInsertItem(int i, ItemStack itemStack, int j) {
		return isItemValidForSlot(i, itemStack);
	}

	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public int getUpgradeProgressScaled(int par1) {
		return this.plantUpgradeTime * par1 / this.plantUpgradeTime1;
	}

	public void readFromNBT(NBTTagCompound tagCom) {
		super.readFromNBT(tagCom);

		this.plantUpgradeTime = tagCom.getShort("UpgradeTime");

	}

	public void writeToNBT(NBTTagCompound tagCom) {
		super.writeToNBT(tagCom);
		tagCom.setShort("UpgradeTime", (short) this.plantUpgradeTime);
	}

	public void updateEntity() {
		boolean canUpgrade = false;

		if (!this.worldObj.isRemote) {
			if (canUpgrade()) {
				this.plantUpgradeTime += 1;

				if (this.plantUpgradeTime == this.plantUpgradeTime1) {
					this.plantUpgradeTime = 0;
					upgradeItem();
					canUpgrade = true;
				}
				this.resync(1);
				this.markDirty();
			} else {
				this.plantUpgradeTime = 0;
			}
		}
	}

	private boolean canUpgrade() {
		if ((this.inv[0] != null) && (this.inv[1] != null)) {
			ItemStack itemStackWith = GreenhouseRecipes.smelting().getResult(
					this.inv[0], this.inv[1], this.inv[2]);

			ItemStack itemStackWOut = GreenhouseRecipes.smelting().getResult(
					this.inv[0], this.inv[1], Util.nullStack);
			ItemStack itemStack;
			if (itemStackWith == null)
				itemStack = itemStackWOut;
			else {
				itemStack = itemStackWith;
			}
			if (itemStack == null)
				return false;

			if (this.inv[4] == null) {
				return true;
			}
			if (this.inv[4].stackSize != getInventoryStackLimit()) {
				return true;
			}
			if (!this.inv[4].isItemEqual(itemStack)) {
				return false;
			}
		}
		return false;
	}

	public void upgradeItem() {
		if (canUpgrade()) {
			ItemStack itemStackResultWith = GreenhouseRecipes.smelting()
					.getResult(this.inv[0], this.inv[1], this.inv[2]);

			ItemStack itemStackResultWOut = GreenhouseRecipes.smelting()
					.getResult(this.inv[0], this.inv[1], Util.nullStack);
			ItemStack itemStackResult;
			if (itemStackResultWith == null)
				itemStackResult = itemStackResultWOut;
			else {
				itemStackResult = itemStackResultWith;
			}
			if (this.inv[4] == null) {
				this.inv[4] = itemStackResult.copy();
			} else if ((this.inv[4].isItemEqual(itemStackResult))
					&& (this.inv[4].stackSize + itemStackResult.stackSize <= this.inv[4]
							.getMaxStackSize())) {
				this.inv[4].stackSize += itemStackResult.stackSize;
			}
			this.inv[0].stackSize -= 1;
			this.inv[1].stackSize -= 1;

			if (this.inv[0].stackSize <= 0)
				this.inv[0] = null;
			if (this.inv[1].stackSize <= 0)
				this.inv[1] = null;
			if ((itemStackResult == itemStackResultWith)
					&& (this.inv[2] != null)) {
				this.inv[2].stackSize -= 1;
				if (this.inv[2].stackSize <= 0)
					this.inv[2] = null;
			}

			this.markDirty();
		}
	}

}