package com.countrygamer.pvz.client.block.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGravestone extends ModelBase
{
  ModelRenderer Shape1;
  ModelRenderer Shape2;

  public ModelGravestone()
  {
    this.textureWidth = 64;
    this.textureHeight = 64;

    this.Shape1 = new ModelRenderer(this, 0, 0);
    this.Shape1.addBox(-5.0F, -15.0F, -1.0F, 10, 15, 2);
    this.Shape1.setRotationPoint(0.0F, 24.0F, 2.0F);
    this.Shape1.setTextureSize(64, 64);
    this.Shape1.mirror = true;
    setRotation(this.Shape1, -0.261799F, 0.0F, 0.0F);
    this.Shape2 = new ModelRenderer(this, 0, 18);
    this.Shape2.addBox(-8.0F, -1.0F, -8.0F, 16, 1, 16);
    this.Shape2.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.Shape2.setTextureSize(64, 64);
    this.Shape2.mirror = true;
    setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.Shape1.render(f5);
    this.Shape2.render(f5);
  }

  public void renderModel(float f5) {
    this.Shape1.render(f5);
    this.Shape2.render(f5);
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