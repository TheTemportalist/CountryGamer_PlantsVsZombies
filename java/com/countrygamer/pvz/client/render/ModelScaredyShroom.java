package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelScaredyShroom extends ModelBase
{
  ModelRenderer UPzSTALK;
  ModelRenderer UPzHEAD;
  ModelRenderer UPzHATz1;
  ModelRenderer UPzHATz2;
  ModelRenderer UPzNOSE;
  ModelRenderer DOWNzSTALK;
  ModelRenderer DOWNzHATz1;
  ModelRenderer DOWNzHATz2;

  public ModelScaredyShroom()
  {
    this.textureWidth = 64;
    this.textureHeight = 32;

    this.UPzSTALK = new ModelRenderer(this, 4, 9);
    this.UPzSTALK.addBox(-1.0F, -8.0F, -1.0F, 2, 8, 2);
    this.UPzSTALK.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.UPzSTALK.setTextureSize(64, 32);
    this.UPzSTALK.mirror = true;
    setRotation(this.UPzSTALK, 0.0F, 0.0F, 0.0F);
    this.UPzHEAD = new ModelRenderer(this, 0, 0);
    this.UPzHEAD.addBox(-2.0F, -4.0F, -2.0F, 4, 5, 4);
    this.UPzHEAD.setRotationPoint(0.0F, 15.0F, 0.0F);
    this.UPzHEAD.setTextureSize(64, 32);
    this.UPzHEAD.mirror = true;
    setRotation(this.UPzHEAD, 0.0F, 0.0F, 0.0F);
    this.UPzHATz1 = new ModelRenderer(this, 16, 5);
    this.UPzHATz1.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6);
    this.UPzHATz1.setRotationPoint(0.0F, 11.0F, 0.0F);
    this.UPzHATz1.setTextureSize(64, 32);
    this.UPzHATz1.mirror = true;
    setRotation(this.UPzHATz1, 0.0F, 0.0F, 0.0F);
    this.UPzHATz2 = new ModelRenderer(this, 20, 0);
    this.UPzHATz2.addBox(-2.0F, -1.0F, -2.0F, 4, 1, 4);
    this.UPzHATz2.setRotationPoint(0.0F, 10.0F, 0.0F);
    this.UPzHATz2.setTextureSize(64, 32);
    this.UPzHATz2.mirror = true;
    setRotation(this.UPzHATz2, 0.0F, 0.0F, 0.0F);
    this.UPzNOSE = new ModelRenderer(this, 23, 15);
    this.UPzNOSE.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 1);
    this.UPzNOSE.setRotationPoint(0.0F, 14.0F, -2.0F);
    this.UPzNOSE.setTextureSize(64, 32);
    this.UPzNOSE.mirror = true;
    setRotation(this.UPzNOSE, 0.0F, 0.0F, 0.0F);
    this.DOWNzSTALK = new ModelRenderer(this, 4, 25);
    this.DOWNzSTALK.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2);
    this.DOWNzSTALK.setRotationPoint(0.0F, 24.0F, 0.0F);
    this.DOWNzSTALK.setTextureSize(64, 32);
    this.DOWNzSTALK.mirror = true;
    setRotation(this.DOWNzSTALK, 0.0F, 0.0F, 0.0F);
    this.DOWNzHATz1 = new ModelRenderer(this, 12, 23);
    this.DOWNzHATz1.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6);
    this.DOWNzHATz1.setRotationPoint(0.0F, 22.0F, 0.0F);
    this.DOWNzHATz1.setTextureSize(64, 32);
    this.DOWNzHATz1.mirror = true;
    setRotation(this.DOWNzHATz1, 0.0F, 0.0F, 0.0F);
    this.DOWNzHATz2 = new ModelRenderer(this, 36, 25);
    this.DOWNzHATz2.addBox(-2.0F, -1.0F, -2.0F, 4, 1, 4);
    this.DOWNzHATz2.setRotationPoint(0.0F, 21.0F, 0.0F);
    this.DOWNzHATz2.setTextureSize(64, 32);
    this.DOWNzHATz2.mirror = true;
    setRotation(this.DOWNzHATz2, 0.0F, 0.0F, 0.0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.UPzSTALK.render(f5);
    this.UPzHEAD.render(f5);
    this.UPzHATz1.render(f5);
    this.UPzHATz2.render(f5);
    this.UPzNOSE.render(f5);
    this.DOWNzSTALK.render(f5);
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