package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.countrygamer.pvz.entities.mobs.plants.EntityFumeShroom;
import com.countrygamer.pvz.lib.Resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFumeShroom extends RenderLiving {
	protected ModelFumeShroom model;

	@SideOnly(Side.CLIENT)
	public RenderFumeShroom(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.model = ((ModelFumeShroom) this.mainModel);
	}

	@SideOnly(Side.CLIENT)
	public void renderFumeShroom(EntityFumeShroom entity, double par2,
			double par4, double par6, float par8, float par9) {
		super.doRender(entity, par2, par4, par6, par8, par9);
	}

	@SideOnly(Side.CLIENT)
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2,
			double par4, double par6, float par8, float par9) {
		renderFumeShroom((EntityFumeShroom) par1EntityLiving, par2, par4, par6,
				par8, par9);
	}

	@SideOnly(Side.CLIENT)
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		renderFumeShroom((EntityFumeShroom) par1Entity, par2, par4, par6, par8,
				par9);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return Resources.fumeShroomMob;
	}
}