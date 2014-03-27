package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.countrygamer.pvz.block.plant.tile.client.model.ModelSunflower;
import com.countrygamer.pvz.entities.mobs.plants.EntitySunflower;
import com.countrygamer.pvz.lib.Resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSunflower extends RenderLiving
{
  protected ModelSunflower model;

  @SideOnly(Side.CLIENT)
  public RenderSunflower(ModelBase par1ModelBase, float par2)
  {
    super(par1ModelBase, par2);
    this.model = ((ModelSunflower)this.mainModel);
  }
  @SideOnly(Side.CLIENT)
  public void renderSunflower(EntitySunflower entity, double par2, double par4, double par6, float par8, float par9) {
    super.doRender(entity, par2, par4, par6, par8, par9);
  }
  @SideOnly(Side.CLIENT)
  public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
    label(par1EntityLiving);
    renderSunflower((EntitySunflower)par1EntityLiving, par2, par4, par6, par8, par9);
  }
  @SideOnly(Side.CLIENT)
  public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
    label(par1Entity);
    renderSunflower((EntitySunflower)par1Entity, par2, par4, par6, par8, par9);
  }

  protected ResourceLocation getEntityTexture(Entity entity) {
    return Resources.sunflowerMob;
  }

  public void label(Entity entity)
  {
  }
}