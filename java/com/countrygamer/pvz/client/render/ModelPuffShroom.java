package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPuffShroom extends ModelBase
{
  ModelRenderer UPzBODY;
  ModelRenderer UPzHATz1;
  ModelRenderer UPzNOSE;
  ModelRenderer UPzHATz2;
  ModelRenderer DOWNzBODY;
  ModelRenderer DOWNzHATz1;
  ModelRenderer DOWNzHATz2;

  public ModelPuffShroom()
  {
    this.textureWidth = 64;
    this.textureHeight = 32;

    this.UPzBODY = new ModelRenderer(this, 0, 13);
    this.UPzBODY.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4);
    this.UPzBODY.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.UPzBODY.setTextureSize(64, 32);
    this.UPzBODY.mirror = true;
    setRotation(this.UPzBODY, 0.0F, 0.0F, 0.0F);
    this.UPzHATz1 = new ModelRenderer(this, 0, 5);
    this.UPzHATz1.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5);
    this.UPzHATz1.setRotationPoint(0.0F, 20.0F, 0.0F);
    this.UPzHATz1.setTextureSize(64, 32);
    this.UPzHATz1.mirror = true;
    setRotation(this.UPzHATz1, 0.0F, 0.0F, 0.0F);
    this.UPzNOSE = new ModelRenderer(this, 14, 1);
    this.UPzNOSE.addBox(-0.5F, -0.5F, -1.0F, 1, 1, 1);
    this.UPzNOSE.setRotationPoint(0.0F, 22.0F, -2.0F);
    this.UPzNOSE.setTextureSize(64, 32);
    this.UPzNOSE.mirror = true;
    setRotation(this.UPzNOSE, 0.0F, 0.0F, 0.0F);
    this.UPzHATz2 = new ModelRenderer(this, 0, 0);
    this.UPzHATz2.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3);
    this.UPzHATz2.setRotationPoint(0.0F, 18.0F, 0.0F);
    this.UPzHATz2.setTextureSize(64, 32);
    this.UPzHATz2.mirror = true;
    setRotation(this.UPzHATz2, 0.0F, 0.0F, 0.0F);
    this.DOWNzBODY = new ModelRenderer(this, 25, 13);
    this.DOWNzBODY.addBox(-2.0F, -3.0F, -2.0F, 4, 3, 4);
    this.DOWNzBODY.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.DOWNzBODY.setTextureSize(64, 32);
    this.DOWNzBODY.mirror = true;
    setRotation(this.DOWNzBODY, 0.0F, 0.0F, 0.0F);
    this.DOWNzHATz1 = new ModelRenderer(this, 23, 5);
    this.DOWNzHATz1.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5);
    this.DOWNzHATz1.setRotationPoint(0.0F, 21.0F, 0.0F);
    this.DOWNzHATz1.setTextureSize(64, 32);
    this.DOWNzHATz1.mirror = true;
    setRotation(this.DOWNzHATz1, 0.0F, 0.0F, 0.0F);
    this.DOWNzHATz2 = new ModelRenderer(this, 27, 0);
    this.DOWNzHATz2.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3);
    this.DOWNzHATz2.setRotationPoint(0.0F, 19.0F, 0.0F);
    this.DOWNzHATz2.setTextureSize(64, 32);
    this.DOWNzHATz2.mirror = true;
    setRotation(this.DOWNzHATz2, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.UPzBODY.render(f5);
    this.UPzHATz1.render(f5);
    this.UPzNOSE.render(f5);
    this.UPzHATz2.render(f5);
    this.DOWNzBODY.render(f5);
    this.DOWNzHATz1.render(f5);
    this.DOWNzHATz2.render(f5);
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