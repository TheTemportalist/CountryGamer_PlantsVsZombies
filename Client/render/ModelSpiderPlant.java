package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpiderPlant extends ModelBase
{
  ModelRenderer Stem1;
  ModelRenderer Stem2;
  ModelRenderer Stem3;
  ModelRenderer Spout;
  ModelRenderer Stalk;
  ModelRenderer RightLeg1;
  ModelRenderer RightLeg2;
  ModelRenderer RightLeg3;
  ModelRenderer RightLeg4;
  ModelRenderer LeftLeg1;
  ModelRenderer LeftLeg2;
  ModelRenderer LeftLeg3;
  ModelRenderer LeftLeg4;

  public ModelSpiderPlant()
  {
    this.textureWidth = 64;
    this.textureHeight = 32;

    this.Stem1 = new ModelRenderer(this, 21, 3);
    this.Stem1.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3);
    this.Stem1.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.Stem1.setTextureSize(64, 32);
    this.Stem1.mirror = true;
    setRotation(this.Stem1, 0.0F, 0.0F, 0.0F);
    this.Stem2 = new ModelRenderer(this, 0, 0);
    this.Stem2.addBox(0.0F, 0.0F, 0.0F, 5, 6, 5);
    this.Stem2.setRotationPoint(-1.0F, -6.0F, -1.0F);
    this.Stem2.setTextureSize(64, 32);
    this.Stem2.mirror = true;
    setRotation(this.Stem2, 0.0F, 0.0F, 0.0F);
    this.Stem3 = new ModelRenderer(this, 21, 3);
    this.Stem3.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3);
    this.Stem3.setRotationPoint(0.0F, -8.0F, 0.0F);
    this.Stem3.setTextureSize(64, 32);
    this.Stem3.mirror = true;
    setRotation(this.Stem3, 0.0F, 0.0F, 0.0F);
    this.Spout = new ModelRenderer(this, 21, 9);
    this.Spout.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2);
    this.Spout.setRotationPoint(0.0F, -3.0F, -3.0F);
    this.Spout.setTextureSize(64, 32);
    this.Spout.mirror = true;
    setRotation(this.Spout, 0.0F, 0.0F, 0.0F);
    this.Stalk = new ModelRenderer(this, 37, 0);
    this.Stalk.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
    this.Stalk.setRotationPoint(1.0F, -10.0F, 0.5F);
    this.Stalk.setTextureSize(64, 32);
    this.Stalk.mirror = true;
    setRotation(this.Stalk, 0.0F, 0.0F, 0.0F);
    this.RightLeg1 = new ModelRenderer(this, 20, 0);
    this.RightLeg1.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 1);
    this.RightLeg1.setRotationPoint(1.5F, -10.0F, 0.0F);
    this.RightLeg1.setTextureSize(64, 32);
    this.RightLeg1.mirror = true;
    setRotation(this.RightLeg1, 0.0F, -0.7853982F, -0.5235988F);
    this.RightLeg2 = new ModelRenderer(this, 20, 0);
    this.RightLeg2.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 1);
    this.RightLeg2.setRotationPoint(1.0F, -10.0F, 0.5F);
    this.RightLeg2.setTextureSize(64, 32);
    this.RightLeg2.mirror = true;
    setRotation(this.RightLeg2, 0.0F, -0.1745329F, -0.5235988F);
    this.RightLeg3 = new ModelRenderer(this, 20, 0);
    this.RightLeg3.addBox(-7.0F, 0.0F, -1.0F, 7, 1, 1);
    this.RightLeg3.setRotationPoint(1.0F, -10.0F, 2.5F);
    this.RightLeg3.setTextureSize(64, 32);
    this.RightLeg3.mirror = true;
    setRotation(this.RightLeg3, 0.0F, 0.1745329F, -0.5235988F);
    this.RightLeg4 = new ModelRenderer(this, 20, 0);
    this.RightLeg4.addBox(-7.0F, 0.0F, -1.0F, 7, 1, 1);
    this.RightLeg4.setRotationPoint(1.5F, -10.0F, 3.0F);
    this.RightLeg4.setTextureSize(64, 32);
    this.RightLeg4.mirror = true;
    setRotation(this.RightLeg4, 0.0F, 0.7853982F, -0.5235988F);
    this.LeftLeg1 = new ModelRenderer(this, 20, 0);
    this.LeftLeg1.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1);
    this.LeftLeg1.setRotationPoint(1.5F, -10.0F, 0.0F);
    this.LeftLeg1.setTextureSize(64, 32);
    this.LeftLeg1.mirror = true;
    setRotation(this.LeftLeg1, 0.0F, 0.7853982F, 0.5235988F);
    this.LeftLeg2 = new ModelRenderer(this, 20, 0);
    this.LeftLeg2.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1);
    this.LeftLeg2.setRotationPoint(2.0F, -10.0F, 0.5F);
    this.LeftLeg2.setTextureSize(64, 32);
    this.LeftLeg2.mirror = true;
    setRotation(this.LeftLeg2, 0.0F, 0.1745329F, 0.5235988F);
    this.LeftLeg3 = new ModelRenderer(this, 20, 0);
    this.LeftLeg3.addBox(0.0F, 0.0F, -1.0F, 7, 1, 1);
    this.LeftLeg3.setRotationPoint(2.0F, -10.0F, 2.5F);
    this.LeftLeg3.setTextureSize(64, 32);
    this.LeftLeg3.mirror = true;
    setRotation(this.LeftLeg3, 0.0F, -0.1745329F, 0.5235988F);
    this.LeftLeg4 = new ModelRenderer(this, 20, 0);
    this.LeftLeg4.addBox(0.0F, 0.0F, -1.0F, 7, 1, 1);
    this.LeftLeg4.setRotationPoint(1.5F, -10.0F, 3.0F);
    this.LeftLeg4.setTextureSize(64, 32);
    this.LeftLeg4.mirror = true;
    setRotation(this.LeftLeg4, 0.0F, -0.7853982F, 0.5235988F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.Stem1.render(f5);
    this.Stem2.render(f5);
    this.Stem3.render(f5);
    this.Spout.render(f5);
    this.Stalk.render(f5);
    this.RightLeg1.render(f5);
    this.RightLeg2.render(f5);
    this.RightLeg3.render(f5);
    this.RightLeg4.render(f5);
    this.LeftLeg1.render(f5);
    this.LeftLeg2.render(f5);
    this.LeftLeg3.render(f5);
    this.LeftLeg4.render(f5);
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