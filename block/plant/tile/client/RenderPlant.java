package com.countrygamer.pvz.block.plant.tile.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.countrygamer.core.Base.client.ModelBase;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlant extends TileEntitySpecialRenderer {
	
	protected ModelBase	model;
	private ResourceLocation texture;
	
	public RenderPlant(ModelBase model, ResourceLocation texture){
		this.model = model;
		this.texture = texture;
		
	}
		
	@Override
	public void renderTileEntityAt(TileEntity tileEnt, double x, double y, double z, float f) {
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
		//GL11.glRotatef(rotationAngleModel, 0.0F, 1.0F, 0.0F);
		
		this.bindTexture(this.texture);
		
		this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
	}
	
}
