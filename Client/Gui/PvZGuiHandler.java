package com.countrygamer.pvz.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.countrygamer.pvz.blocks.tiles.TileEntityGreenhouse;
import com.countrygamer.pvz.items.ItemGuideBook;

import cpw.mods.fml.common.network.IGuiHandler;

public class PvZGuiHandler implements IGuiHandler {
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEnt = world.getTileEntity(x, y, z);
		if ((tileEnt instanceof TileEntityGreenhouse)) {
			return new ContainerGreenhouse(player.inventory,
					(TileEntityGreenhouse) tileEnt);
		}
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEnt = world.getTileEntity(x, y, z);
		if ((tileEnt instanceof TileEntityGreenhouse)) {
			return new GuiGreenhouse(player.inventory,
					(TileEntityGreenhouse) tileEnt);
		}
		if (ID == 3) {
			return new GuiGuide((ItemGuideBook) player.inventory
					.getCurrentItem().getItem());
		}
		return null;
	}
	
}