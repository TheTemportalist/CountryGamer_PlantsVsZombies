package com.countrygamer.pvz.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnderPlant extends ModelBase
{
  ModelRenderer LLeaf;
  ModelRenderer RLeaf;
  ModelRenderer Stem1;
  ModelRenderer Stem2;
  ModelRenderer Stem3;
  ModelRenderer Head;
  ModelRenderer Spout;
  ModelRenderer RHorn;
  ModelRenderer LHorn;
  ModelRenderer LWing1;
  ModelRenderer LWing2;
  ModelRenderer LWing3;
  ModelRenderer RWing1;
  ModelRenderer RWing2;
  ModelRenderer RWing3;

  public ModelEnderPlant()
  {
    this.textureWidth = 64;
    this.textureHeight = 32;

    this.LLeaf = new ModelRenderer(this, 20, 13);
    this.LLeaf.addBox(0.0F, -0.5F, -5.0F, 5, 1, 5);
    this.LLeaf.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.LLeaf.setTextureSize(64, 32);
    this.LLeaf.mirror = true;
    setRotation(this.LLeaf, -0.1745329F, -0.1745329F, -0.261799F);
    this.RLeaf = new ModelRenderer(this, 20, 13);
    this.RLeaf.addBox(-5.0F, -0.5F, -5.0F, 5, 1, 5);
    this.RLeaf.setRotationPoint(0.0F, 23.0F, 0.0F);
    this.RLeaf.setTextureSize(64, 32);
    this.RLeaf.mirror = true;
    setRotation(this.RLeaf, -0.261799F, 0.1745329F, 0.1745329F);
    this.Stem1 = new ModelRenderer(this, 12, 14);
    this.Stem1.addBox(0.0F, 0.0F, 0.0F, 2, 9, 2);
    this.Stem1.setRotationPoint(-1.0F, 15.0F, -1.0F);
    this.Stem1.setTextureSize(64, 32);
    this.Stem1.mirror = true;
    setRotation(this.Stem1, 0.0F, 0.0F, 0.0F);
    this.Stem2 = new ModelRenderer(this, 0, 20);
    this.Stem2.addBox(0.0F, 0.0F, 0.0F, 2, 5, 2);
    this.Stem2.setRotationPoint(-1.0F, 10.5F, 1.0F);
    this.Stem2.setTextureSize(64, 32);
    this.Stem2.mirror = true;
    setRotation(this.Stem2, -0.4014257F, 0.0F, 0.0F);
    this.Stem3 = new ModelRenderer(this, 0, 14);
    this.Stem3.addBox(0.0F, 0.0F, -4.0F, 2, 2, 4);
    this.Stem3.setRotationPoint(-1.0F, 11.0F, 3.0F);
    this.Stem3.setTextureSize(64, 32);
    this.Stem3.mirror = true;
    setRotation(this.Stem3, -0.6981317F, 0.0F, 0.0F);
    this.Head = new ModelRenderer(this, 0, 6);
    this.Head.addBox(0.0F, -4.0F, -4.0F, 4, 4, 4);
    this.Head.setRotationPoint(-2.0F, 10.0F, 0.0F);
    this.Head.setTextureSize(64, 32);
    this.Head.mirror = true;
    setRotation(this.Head, 0.1745329F, 0.0F, 0.0F);
    this.Spout = new ModelRenderer(this, 0, 0);
    this.Spout.addBox(0.5F, -1.0F, -7.0F, 3, 2, 4);
    this.Spout.setRotationPoint(-2.0F, 10.0F, 0.0F);
    this.Spout.setTextureSize(64, 32);
    this.Spout.mirror = true;
    setRotation(this.Spout, 0.1745329F, 0.0F, 0.0F);
    this.RHorn = new ModelRenderer(this, 0, 0);
    this.RHorn.addBox(0.5F, -5.0F, -2.0F, 1, 1, 1);
    this.RHorn.setRotationPoint(-2.0F, 10.0F, 0.0F);
    this.RHorn.setTextureSize(64, 32);
    this.RHorn.mirror = true;
    setRotation(this.RHorn, 0.1745329F, 0.0F, 0.0F);
    this.LHorn = new ModelRenderer(this, 0, 0);
    this.LHorn.addBox(2.5F, -5.0F, -2.0F, 1, 1, 1);
    this.LHorn.setRotationPoint(-2.0F, 10.0F, 0.0F);
    this.LHorn.setTextureSize(64, 32);
    this.LHorn.mirror = true;
    setRotation(this.LHorn, 0.1745329F, 0.0F, 0.0F);
    this.LWing1 = new ModelRenderer(this, 21, 0);
    this.LWing1.addBox(-1.0F, 0.0F, 0.0F, 10, 1, 1);
    this.LWing1.setRotationPoint(0.5F, 10.0F, 1.5F);
    this.LWing1.setTextureSize(64, 32);
    this.LWing1.mirror = true;
    setRotation(this.LWing1, 0.0F, -0.5235988F, -0.7853982F);
    this.LWing2 = new ModelRenderer(this, 21, 2);
    this.LWing2.addBox(0.0F, 0.0F, 0.0F, 1, 13, 1);
    this.LWing2.setRotationPoint(5.5F, 4.0F, 5.0F);
    this.LWing2.setTextureSize(64, 32);
    this.LWing2.mirror = true;
    setRotation(this.LWing2, 0.261799F, 0.0F, -0.1745329F);
    this.LWing3 = new ModelRenderer(this, 25, 2);
    this.LWing3.addBox(-1.0F, 0.0F, 0.0F, 10, 11, 0);
    this.LWing3.setRotationPoint(0.5333334F, 10.5F, 2.0F);
    this.LWing3.setTextureSize(64, 32);
    this.LWing3.mirror = true;
    setRotation(this.LWing3, 0.20944F, -0.5235988F, -0.7853982F);
    this.RWing1 = new ModelRenderer(this, 21, 0);
    this.RWing1.addBox(-9.0F, 0.0F, 0.0F, 10, 1, 1);
    this.RWing1.setRotationPoint(-0.5F, 10.0F, 1.5F);
    this.RWing1.setTextureSize(64, 32);
    this.RWing1.mirror = true;
    setRotation(this.RWing1, 0.0F, 0.5235988F, 0.7853982F);
    this.RWing2 = new ModelRenderer(this, 21, 2);
    this.RWing2.addBox(-1.0F, 0.0F, 0.0F, 1, 13, 1);
    this.RWing2.setRotationPoint(-5.5F, 4.0F, 5.0F);
    this.RWing2.setTextureSize(64, 32);
    this.RWing2.mirror = true;
    setRotation(this.RWing2, 0.261799F, 0.0F, 0.1745329F);
    this.RWing3.mirror = true;
    this.RWing3 = new ModelRenderer(this, 25, 2);
    this.RWing3.addBox(-9.0F, 0.0F, 0.0F, 10, 11, 0);
    this.RWing3.setRotationPoint(-0.5F, 10.5F, 2.0F);
    this.RWing3.setTextureSize(64, 32);
    this.RWing3.mirror = true;
    setRotation(this.RWing3, 0.20944F, 0.5235988F, 0.7853982F);
    this.RWing3.mirror = false;
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    this.LLeaf.render(f5);
    this.RLeaf.render(f5);
    this.Stem1.render(f5);
    this.Stem2.render(f5);
    this.Stem3.render(f5);
    this.Head.render(f5);
    this.Spout.render(f5);
    this.RHorn.render(f5);
    this.LHorn.render(f5);
    this.LWing1.render(f5);
    this.LWing2.render(f5);
    this.LWing3.render(f5);
    this.RWing1.render(f5);
    this.RWing2.render(f5);
    this.RWing3.render(f5);
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