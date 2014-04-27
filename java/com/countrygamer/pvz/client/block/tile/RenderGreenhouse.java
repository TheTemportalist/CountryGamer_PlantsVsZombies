package com.countrygamer.pvz.client.block.tile;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.countrygamer.core.Base.common.tileentity.TileEntityInventoryBase;
import com.countrygamer.core.common.lib.CoreUtil;
import com.countrygamer.pvz.PvZ;
import com.countrygamer.pvz.block.tile.TileEntityGreenhouse;
import com.countrygamer.pvz.lib.Resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RenderGreenhouse extends TileEntitySpecialRenderer {

	private ModelGreenhouse aModel;

	private final RenderItem inputRender, modify1Render, outputRender;

	public RenderGreenhouse() {
		this.aModel = new ModelGreenhouse();

		RenderItem basicRender = new RenderItem() {
			@Override
			public byte getMiniBlockCount(ItemStack stack, byte original) {
				return 1;
			}

			@Override
			public byte getMiniItemCount(ItemStack stack, byte original) {
				return 1;
			}

			@Override
			public boolean shouldBob() {
				return true;
			}
		};
		
		this.inputRender = basicRender;
		this.inputRender.setRenderManager(RenderManager.instance);
		this.modify1Render = basicRender;
		this.modify1Render.setRenderManager(RenderManager.instance);
		this.outputRender = basicRender;
		this.outputRender.setRenderManager(RenderManager.instance);

	}

	@SideOnly(Side.CLIENT)
	public void renderAModelAt(TileEntityGreenhouse tileEnt, double x,
			double y, double z, float f) {
		tileEnt.getWorldObj().scheduleBlockUpdate(tileEnt.xCoord,
				tileEnt.yCoord, tileEnt.zCoord, PvZ.greenhouse, 10);

		GL11.glPushMatrix();
		int metadata = tileEnt.getBlockMetadata();
		int rotationAngleModel = 0;
		if (metadata % 4 == 0) {
			rotationAngleModel = 0;
		}
		if (metadata % 4 == 1) {
			rotationAngleModel = 270;
		}
		if (metadata % 4 == 2) {
			rotationAngleModel = 180;
		}
		if (metadata % 4 == 3) {
			rotationAngleModel = 90;
		}
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(rotationAngleModel, 0.0F, 1.0F, 0.0F);

		this.bindTexture(Resources.greenhouse);

		this.aModel.renderModel(0.0625F);
		GL11.glPopMatrix();

		/**
		 * Render the ghost item inside of the Block, slowly spinning Taken from
		 * Pahimar's EE3 Aludel model
		 */
		ItemStack input = tileEnt.getStackInSlot(0);
		ItemStack mod1 = tileEnt.getStackInSlot(1);
		ItemStack mod2 = tileEnt.getStackInSlot(2);
		ItemStack output = tileEnt.getStackInSlot(4);
		GL11.glPushMatrix();
		if (mod1 != null) {
			this.renderItem(tileEnt, this.modify1Render, mod1,
					(float) x + 0.5F, (float) y + 1.0F, (float) z + 0.5F);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		if (output != null) {
			this.renderItem(tileEnt, this.outputRender, output,
					(float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
		}
		GL11.glPopMatrix();

	}

	@SideOnly(Side.CLIENT)
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f) {
		renderAModelAt((TileEntityGreenhouse) tileentity, x, y, z, f);
	}

	private void renderItem(TileEntityInventoryBase tileEnt,
			RenderItem itemRender, ItemStack stack, float x, float y, float z) {
		GL11.glPushMatrix();
		float scaleFactor = CoreUtil.getGhostItemScaleFactor(this.outputRender,
				stack);
		float rotationAngle = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

		EntityItem ghostEntityItem = new EntityItem(tileEnt.getWorldObj());
		ghostEntityItem.hoverStart = 0.0F;
		ghostEntityItem.setEntityItemStack(stack);

		GL11.glTranslatef(x, y, z);
		GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);

		itemRender.doRender(ghostEntityItem, 0, 0, 0, 0, 0);
		GL11.glPopMatrix();
	}

}