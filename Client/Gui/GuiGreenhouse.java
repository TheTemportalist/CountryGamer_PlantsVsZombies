package com.countrygamer.pvz.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.countrygamer.pvz.block.tile.TileEntityGreenhouse;
import com.countrygamer.pvz.lib.Reference;

public class GuiGreenhouse extends GuiContainer {
	public static final ResourceLocation bkgd = new ResourceLocation(
			Reference.MOD_ID, "textures/gui/greenhouse.png");
	private TileEntityGreenhouse tileEnt;

	public GuiGreenhouse(InventoryPlayer invPlayer, TileEntityGreenhouse tileEnt) {
		super(new ContainerGreenhouse(invPlayer, tileEnt));
		this.tileEnt = tileEnt;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		String s = this.tileEnt.getInventoryName();
		this.fontRendererObj.drawString(s, this.xSize / 2
				- this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(bkgd);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1 = 0;

		i1 = this.tileEnt.getUpgradeProgressScaled(24);
		drawTexturedModalRect(k + 90, l + 35, 176, 14, i1 + 1, 16);
	}
}