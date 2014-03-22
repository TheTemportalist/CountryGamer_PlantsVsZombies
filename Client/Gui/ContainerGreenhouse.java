package com.countrygamer.pvz.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.countrygamer.pvz.block.tile.TileEntityGreenhouse;
import com.countrygamer.pvz.lib.Util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerGreenhouse extends Container {
	private TileEntityGreenhouse	tileEnt;
	private int						lastUpgradeTime;
	
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileEnt.isUseableByPlayer(player);
	}
	
	public ContainerGreenhouse(InventoryPlayer invPlayer, TileEntityGreenhouse tileEnt) {
		this.tileEnt = tileEnt;
		
		addSlotToContainer(new Slot(tileEnt, 0, 35, 35));
		
		addSlotToContainer(new Slot(tileEnt, 1, 62, 15));
		
		addSlotToContainer(new Slot(tileEnt, 2, 62, 55));
		
		addSlotToContainer(new Slot(tileEnt, 4, 124, 35));
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters(ICrafting par1ICrafting) {
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.tileEnt.plantUpgradeTime);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if (this.lastUpgradeTime == this.tileEnt.plantUpgradeTime) continue;
			icrafting.sendProgressBarUpdate(this, 0, this.tileEnt.plantUpgradeTime);
		}
		
		this.lastUpgradeTime = this.tileEnt.plantUpgradeTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.tileEnt.plantUpgradeTime = par2;
		}
	}
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotID) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);
		
		if ((slot != null) && (slot.getHasStack())) {
			ItemStack itemStack1 = slot.getStack();
			itemstack = itemStack1.copy();
			
			if ((slotID != 0) && (slotID != 1) && (slotID != 2) && (slotID != 3)) {
				if (Util.isItemInput(itemStack1)) {
					if (!mergeItemStack(itemStack1, 0, 1, false)) {
						return null;
					}
					if (Util.isItemModify1(itemStack1)) {
						if (!mergeItemStack(itemStack1, 1, 2, false)) {
							return null;
						}
						if (Util.isItemModify2(itemStack1)) {
							if (!mergeItemStack(itemStack1, 2, 3, false)) {
								return null;
							}
							if ((slotID >= 4) && (slotID < 30)) {
								if (!mergeItemStack(itemStack1, 30, 39, false)) {
									return null;
								}
								if ((slotID >= 30) && (slotID < 39)
										&& (!mergeItemStack(itemStack1, 4, 30, false)))
									return null;
							}
						}
					}
				}
			}
			else if (!mergeItemStack(itemStack1, 4, 39, false)) {
				return null;
			}
			if (itemStack1.stackSize == 0)
				slot.putStack((ItemStack) null);
			else {
				slot.onSlotChanged();
			}
			if (itemStack1.stackSize == itemstack.stackSize) {
				return null;
			}
			slot.onPickupFromSlot(par1EntityPlayer, itemStack1);
		}
		
		return itemstack;
	}
}
