package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFumeShroom extends ModelBase
{
  ModelRenderer Shape1;
  ModelRenderer Shape2;
  ModelRenderer Shape3;
  ModelRenderer Shape4;

  public ModelFumeShroom()
  {
    this.textureWidth = 64;
    this.textureHeight = 32;

    this.Shape1 = new ModelRenderer(this, 0, 19);
    this.Shape1.addBox(0.0F, 0.0F, 0.0F, 7, 7, 6);
    this.Shape1.setRotationPoint(-3.0F, 17.0F, -2.0F);
    this.Shape1.setTextureSize(64, 32);
    this.Shape1.mirror = true;
    setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
    this.Shape2 = new ModelRenderer(this, 0, 0);
    this.Shape2.addBox(0.0F, 0.0F, 0.0F, 9, 6, 8);
    this.Shape2.setRotationPoint(-4.0F, 11.0F, -3.0F);
    this.Shape2.setTextureSize(64, 32);
    this.Shape2.mirror = true;
    setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
    this.Shape3 = new ModelRenderer(this, 40, 4);
    this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
    this.Shape3.setRotationPoint(-0.5333334F, 13.0F, -4.0F);
    this.Shape3.setTextureSize(64, 32);
    this.Shape3.mirror = true;
    setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
    this.Shape4 = new ModelRenderer(this, 39, 9);
    this.Shape4.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1);
    this.Shape4.setRotationPoint(-0.9333333F, 12.5F, -5.0F);
    this.Shape4.setTextureSize(64, 32);
    this.Shape4.mirror = true;
    setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.Shape1.render(f5);
    this.Shape2.render(f5);
    this.Shape3.render(f5);
    this.Shape4.render(f5);
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