package com.countrygamer.pvz.client.block.tile;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChlorophyllBowl extends ModelBase
{
  ModelRenderer a;
  ModelRenderer b;
  ModelRenderer c;
  ModelRenderer d;
  ModelRenderer e;
  ModelRenderer f;
  ModelRenderer g;
  ModelRenderer h;
  ModelRenderer i;
  ModelRenderer j;
  ModelRenderer k;
  ModelRenderer l;
  ModelRenderer m;
  ModelRenderer n;
  ModelRenderer o;
  ModelRenderer p;
  ModelRenderer q;
  ModelRenderer filled;

  public ModelChlorophyllBowl()
  {
    this.textureWidth = 64;
    this.textureHeight = 64;

    this.a = new ModelRenderer(this, 0, 0);
    this.a.addBox(-4.0F, 0.0F, -4.0F, 8, 2, 8);
    this.a.setRotationPoint(0.0F, 22.0F, 0.0F);
    this.a.setTextureSize(64, 64);
    this.a.mirror = true;
    setRotation(this.a, 0.0F, 0.0F, 0.0F);
    this.b = new ModelRenderer(this, 0, 0);
    this.b.addBox(-6.0F, 0.0F, 0.0F, 12, 2, 1);
    this.b.setRotationPoint(0.0F, 20.0F, 5.0F);
    this.b.setTextureSize(64, 64);
    this.b.mirror = true;
    setRotation(this.b, 0.0F, 0.0F, 0.0F);
    this.c = new ModelRenderer(this, 0, 0);
    this.c.addBox(-6.0F, 0.0F, -1.0F, 12, 2, 1);
    this.c.setRotationPoint(0.0F, 20.0F, -5.0F);
    this.c.setTextureSize(64, 64);
    this.c.mirror = true;
    setRotation(this.c, 0.0F, 0.0F, 0.0F);
    this.d = new ModelRenderer(this, 0, 0);
    this.d.addBox(0.0F, 0.0F, -5.0F, 1, 1, 10);
    this.d.setRotationPoint(4.0F, 21.0F, 0.0F);
    this.d.setTextureSize(64, 64);
    this.d.mirror = true;
    setRotation(this.d, 0.0F, 0.0F, 0.0F);
    this.e = new ModelRenderer(this, 0, 0);
    this.e.addBox(-1.0F, 0.0F, -5.0F, 1, 1, 10);
    this.e.setRotationPoint(-4.0F, 21.0F, 0.0F);
    this.e.setTextureSize(64, 64);
    this.e.mirror = true;
    setRotation(this.e, 0.0F, 0.0F, 0.0F);
    this.f = new ModelRenderer(this, 0, 0);
    this.f.addBox(0.0F, 0.0F, -5.0F, 1, 2, 10);
    this.f.setRotationPoint(5.0F, 20.0F, 0.0F);
    this.f.setTextureSize(64, 64);
    this.f.mirror = true;
    setRotation(this.f, 0.0F, 0.0F, 0.0F);
    this.g = new ModelRenderer(this, 0, 0);
    this.g.addBox(-1.0F, 0.0F, -5.0F, 1, 2, 10);
    this.g.setRotationPoint(-5.0F, 20.0F, 0.0F);
    this.g.setTextureSize(64, 64);
    this.g.mirror = true;
    setRotation(this.g, 0.0F, 0.0F, 0.0F);
    this.h = new ModelRenderer(this, 0, 0);
    this.h.addBox(-4.0F, 0.0F, 0.0F, 8, 1, 1);
    this.h.setRotationPoint(0.0F, 21.0F, 4.0F);
    this.h.setTextureSize(64, 64);
    this.h.mirror = true;
    setRotation(this.h, 0.0F, 0.0F, 0.0F);
    this.i = new ModelRenderer(this, 0, 0);
    this.i.addBox(-4.0F, 0.0F, -1.0F, 8, 1, 1);
    this.i.setRotationPoint(0.0F, 21.0F, -4.0F);
    this.i.setTextureSize(64, 64);
    this.i.mirror = true;
    setRotation(this.i, 0.0F, 0.0F, 0.0F);
    this.j = new ModelRenderer(this, 0, 0);
    this.j.addBox(-8.0F, 0.0F, 0.0F, 16, 4, 1);
    this.j.setRotationPoint(0.0F, 16.0F, 7.0F);
    this.j.setTextureSize(64, 64);
    this.j.mirror = true;
    setRotation(this.j, 0.0F, 0.0F, 0.0F);
    this.k = new ModelRenderer(this, 0, 0);
    this.k.addBox(-8.0F, 0.0F, -1.0F, 16, 4, 1);
    this.k.setRotationPoint(0.0F, 16.0F, -7.0F);
    this.k.setTextureSize(64, 64);
    this.k.mirror = true;
    setRotation(this.k, 0.0F, 0.0F, 0.0F);
    this.l = new ModelRenderer(this, 0, 0);
    this.l.addBox(0.0F, 0.0F, -7.0F, 1, 4, 14);
    this.l.setRotationPoint(7.0F, 16.0F, 0.0F);
    this.l.setTextureSize(64, 64);
    this.l.mirror = true;
    setRotation(this.l, 0.0F, 0.0F, 0.0F);
    this.m = new ModelRenderer(this, 0, 0);
    this.m.addBox(-1.0F, 0.0F, -7.0F, 1, 4, 14);
    this.m.setRotationPoint(-7.0F, 16.0F, 0.0F);
    this.m.setTextureSize(64, 64);
    this.m.mirror = true;
    setRotation(this.m, 0.0F, 0.0F, 0.0F);
    this.n = new ModelRenderer(this, 0, 0);
    this.n.addBox(-7.0F, 0.0F, 0.0F, 14, 1, 1);
    this.n.setRotationPoint(0.0F, 19.0F, 6.0F);
    this.n.setTextureSize(64, 64);
    this.n.mirror = true;
    setRotation(this.n, 0.0F, 0.0F, 0.0F);
    this.o = new ModelRenderer(this, 0, 0);
    this.o.addBox(-7.0F, 0.0F, -1.0F, 14, 1, 1);
    this.o.setRotationPoint(0.0F, 19.0F, -6.0F);
    this.o.setTextureSize(64, 64);
    this.o.mirror = true;
    setRotation(this.o, 0.0F, 0.0F, 0.0F);
    this.p = new ModelRenderer(this, 0, 0);
    this.p.addBox(0.0F, 0.0F, -6.0F, 1, 1, 12);
    this.p.setRotationPoint(6.0F, 19.0F, 0.0F);
    this.p.setTextureSize(64, 64);
    this.p.mirror = true;
    setRotation(this.p, 0.0F, 0.0F, 0.0F);
    this.q = new ModelRenderer(this, 0, 0);
    this.q.addBox(-1.0F, 0.0F, -6.0F, 1, 1, 12);
    this.q.setRotationPoint(-6.0F, 19.0F, 0.0F);
    this.q.setTextureSize(64, 64);
    this.q.mirror = true;
    setRotation(this.q, 0.0F, 0.0F, 0.0F);
    this.filled = new ModelRenderer(this, 0, 18);
    this.filled.addBox(-7.0F, 0.0F, -7.0F, 14, 1, 14);
    this.filled.setRotationPoint(0.0F, 18.0F, 0.0F);
    this.filled.setTextureSize(64, 64);
    this.filled.mirror = true;
    setRotation(this.filled, 0.0F, 0.0F, 0.0F);
  }

  public void renderModel(float f5) {
    this.a.render(f5);
    this.b.render(f5);
    this.c.render(f5);
    this.d.render(f5);
    this.e.render(f5);
    this.f.render(f5);
    this.g.render(f5);
    this.h.render(f5);
    this.i.render(f5);
    this.j.render(f5);
    this.k.render(f5);
    this.l.render(f5);
    this.m.render(f5);
    this.n.render(f5);
    this.o.render(f5);
    this.p.render(f5);
    this.q.render(f5);
    this.filled.render(f5);
  }

  public void render(Entity entity, float f0, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f0, f1, f2, f3, f4, f5);
    setRotationAngles(f0, f1, f2, f3, f4, f5);
    this.a.render(f5);
    this.b.render(f5);
    this.c.render(f5);
    this.d.render(f5);
    this.e.render(f5);
    this.f.render(f5);
    this.g.render(f5);
    this.h.render(f5);
    this.i.render(f5);
    this.j.render(f5);
    this.k.render(f5);
    this.l.render(f5);
    this.m.render(f5);
    this.n.render(f5);
    this.o.render(f5);
    this.p.render(f5);
    this.q.render(f5);
    this.filled.render(f5);
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