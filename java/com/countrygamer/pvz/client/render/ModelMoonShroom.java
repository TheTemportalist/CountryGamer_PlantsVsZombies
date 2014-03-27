package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMoonShroom extends ModelBase
{
  ModelRenderer Body;
  ModelRenderer Top1;
  ModelRenderer Top2;
  ModelRenderer Top3;
  ModelRenderer Top4;

  public ModelMoonShroom()
  {
    this.textureWidth = 64;
    this.textureHeight = 32;

    this.Body = new ModelRenderer(this, 28, 11);
    this.Body.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5);
    this.Body.setRotationPoint(-2.5F, 19.0F, -2.5F);
    this.Body.setTextureSize(64, 32);
    this.Body.mirror = true;
    setRotation(this.Body, 0.0F, 0.0F, 0.0F);
    this.Top1 = new ModelRenderer(this, 21, 0);
    this.Top1.addBox(0.0F, 0.0F, 0.0F, 9, 2, 9);
    this.Top1.setRotationPoint(-4.5F, 17.0F, -4.5F);
    this.Top1.setTextureSize(64, 32);
    this.Top1.mirror = true;
    setRotation(this.Top1, 0.0F, 0.0F, 0.0F);
    this.Top2 = new ModelRenderer(this, 0, 15);
    this.Top2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8);
    this.Top2.setRotationPoint(-4.0F, 16.0F, -4.0F);
    this.Top2.setTextureSize(64, 32);
    this.Top2.mirror = true;
    setRotation(this.Top2, 0.0F, 0.0F, 0.0F);
    this.Top3 = new ModelRenderer(this, 0, 7);
    this.Top3.addBox(0.0F, 0.0F, 0.0F, 7, 1, 7);
    this.Top3.setRotationPoint(-3.5F, 15.0F, -3.5F);
    this.Top3.setTextureSize(64, 32);
    this.Top3.mirror = true;
    setRotation(this.Top3, 0.0F, 0.0F, 0.0F);
    this.Top4 = new ModelRenderer(this, 0, 0);
    this.Top4.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
    this.Top4.setRotationPoint(-3.0F, 14.0F, -3.0F);
    this.Top4.setTextureSize(64, 32);
    this.Top4.mirror = true;
    setRotation(this.Top4, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.Body.render(f5);
    this.Top1.render(f5);
    this.Top2.render(f5);
    this.Top3.render(f5);
    this.Top4.render(f5);
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
  }
}