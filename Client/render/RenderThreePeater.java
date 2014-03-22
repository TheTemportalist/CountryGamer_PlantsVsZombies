package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.countrygamer.pvz.block.plant.tile.client.model.ModelThreePeater;
import com.countrygamer.pvz.entities.mobs.plants.EntityThreePeater;
import com.countrygamer.pvz.lib.Resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderThreePeater extends RenderLiving
{
  protected ModelThreePeater model;

  @SideOnly(Side.CLIENT)
  public RenderThreePeater(ModelBase par1ModelBase, float par2)
  {
    super(par1ModelBase, par2);
    this.model = ((ModelThreePeater)this.mainModel);
  }
  @SideOnly(Side.CLIENT)
  public void renderThreePeater(EntityThreePeater entity, double par2, double par4, double par6, float par8, float par9) {
    super.doRender(entity, par2, par4, par6, par8, par9);
  }
  @SideOnly(Side.CLIENT)
  public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
    renderThreePeater((EntityThreePeater)par1EntityLiving, par2, par4, par6, par8, par9);
  }
  @SideOnly(Side.CLIENT)
  public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
    renderThreePeater((EntityThreePeater)par1Entity, par2, par4, par6, par8, par9);
  }

  protected ResourceLocation getEntityTexture(Entity entity) {
    return Resources.threePeaterMob;
  }
}