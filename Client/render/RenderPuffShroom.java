package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.countrygamer.pvz.entities.mobs.plants.EntityPuffShroom;
import com.countrygamer.pvz.lib.Resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPuffShroom extends RenderLiving
{
  protected ModelPuffShroom model;
  private static ResourceLocation field_110887_f = Resources.puffShroomMob_0;

  @SideOnly(Side.CLIENT)
  public RenderPuffShroom(ModelBase par1ModelBase, float par2)
  {
    super(par1ModelBase, par2);
    this.model = ((ModelPuffShroom)this.mainModel);
  }
  @SideOnly(Side.CLIENT)
  public void renderPuffShroom(EntityPuffShroom entity, double par2, double par4, double par6, float par8, float par9) {
    super.doRender(entity, par2, par4, par6, par8, par9);
  }
  @SideOnly(Side.CLIENT)
  public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
    renderPuffShroom((EntityPuffShroom)par1EntityLiving, par2, par4, par6, par8, par9);
  }
  @SideOnly(Side.CLIENT)
  public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
    renderPuffShroom((EntityPuffShroom)par1Entity, par2, par4, par6, par8, par9);
  }

  protected ResourceLocation func_110886_a(EntityPuffShroom entity)
  {
    field_110887_f = entity.renderRL;
    return field_110887_f;
  }

  protected ResourceLocation getEntityTexture(Entity par1Entity)
  {
    return func_110886_a((EntityPuffShroom)par1Entity);
  }
}