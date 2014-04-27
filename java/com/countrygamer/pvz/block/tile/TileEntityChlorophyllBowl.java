package com.countrygamer.pvz.block.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.core.Base.common.item.ItemBase;
import com.countrygamer.core.Base.common.tileentity.TileEntityInventoryBase;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.lib.Util;

public class TileEntityChlorophyllBowl extends TileEntityInventoryBase {

	public int delayControl = 1200 * PvZ.sunlightTimer;
	public int delay = this.delayControl;

	public int sunlightHeld = 0;

	public TileEntityChlorophyllBowl() {
		super("Chlorophyll Bowl", 36, 64);
	}

	public void sunlightControl() {
		World world = this.worldObj;
		int x = this.xCoord;
		int y = this.yCoord;
		int z = this.zCoord;

		if (!world.isRemote)
			if (Util.dayCheck(world)) {
				for (int i = 0; i <= 36; i++) {
					ItemStack slot = getStackInSlot(i);

					if (slot != null) {
						if (slot.getItem() == PvZ.sunlight) {
							ItemBase stackItem = (ItemBase) slot.getItem();
							if (slot.stackSize < stackItem.getMaxStackSize()) {
								slot.stackSize += 1;
								break;
							}
						}
					} else {
						ItemStack givenSunlight = new ItemStack(PvZ.sunlight,
								1, 0);

						setInventorySlotContents(i, givenSunlight);
						break;
					}

				}

			} else if (!Util.dayCheck(world)) {
				for (int i = 0; i <= 36; i++) {
					ItemStack slot = getStackInSlot(i);

					if (slot != null) {
						if (slot.getItem() == PvZ.moonlight) {
							ItemBase stackItem = (ItemBase) slot.getItem();
							if (slot.stackSize < stackItem.getMaxStackSize()) {
								slot.stackSize += 1;
								break;
							}
						}
					} else {
						ItemStack givenSunlight = new ItemStack(PvZ.moonlight,
								1, 0);

						setInventorySlotContents(i, givenSunlight);
						break;
					}
				}
			}
	}

	public void updateEntity() {
		if (this.delay > 0) {
			this.delay -= 1;

			return;
		}
		this.delay = this.delayControl;

		sunlightControl();

	}

}