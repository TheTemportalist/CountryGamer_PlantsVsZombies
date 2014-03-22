package com.countrygamer.pvz.block.plant.tile.client.model;

import net.minecraft.client.model.ModelRenderer;

import com.countrygamer.core.Base.client.ModelBase;

public class ModelSnowPea extends ModelBase {
	ModelRenderer Stem;
	ModelRenderer Head;
	ModelRenderer Mouth;
	ModelRenderer LEAFzL;
	ModelRenderer LEAFzR;
	ModelRenderer HLzTzL;
	ModelRenderer HLzTzR;
	ModelRenderer HLzLzT;
	ModelRenderer HLzTzC;
	ModelRenderer HLzLzB;
	ModelRenderer HLzRzT;
	ModelRenderer HLzRzB;
	ModelRenderer HLzBzC;
	ModelRenderer HLzBzR;
	ModelRenderer HLzBzL;
	
	public ModelSnowPea() {
		super(64, 64);
		
		this.Stem = new ModelRenderer(this, 6, 10);
		this.Stem.addBox(-1.0F, -10.0F, -1.0F, 2, 11, 2);
		this.Stem.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Stem.setTextureSize(64, 64);
		this.Stem.mirror = true;
		setRotation(this.Stem, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.Stem);
		
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.addBox(-2.5F, -5.0F, -2.5F, 5, 5, 5);
		this.Head.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.Head.setTextureSize(64, 64);
		this.Head.mirror = true;
		setRotation(this.Head, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.Head);
		
		this.Mouth = new ModelRenderer(this, 20, 4);
		this.Mouth.addBox(-1.5F, -1.5F, -3.0F, 3, 3, 3);
		this.Mouth.setRotationPoint(0.0F, 11.5F, -2.5F);
		this.Mouth.setTextureSize(64, 64);
		this.Mouth.mirror = true;
		setRotation(this.Mouth, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.Mouth);
		
		this.LEAFzL = new ModelRenderer(this, 0, 23);
		this.LEAFzL.addBox(0.0F, -0.5F, -5.0F, 5, 1, 5);
		this.LEAFzL.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.LEAFzL.setTextureSize(64, 64);
		this.LEAFzL.mirror = true;
		setRotation(this.LEAFzL, -0.1745329F, -0.1745329F, -0.261799F);
		this.modelList.add(this.LEAFzL);
		
		this.LEAFzR = new ModelRenderer(this, 0, 23);
		this.LEAFzR.addBox(-5.0F, -0.5F, -5.0F, 5, 1, 5);
		this.LEAFzR.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.LEAFzR.setTextureSize(64, 64);
		this.LEAFzR.mirror = true;
		setRotation(this.LEAFzR, -0.261799F, 0.1745329F, 0.1745329F);
		this.modelList.add(this.LEAFzR);
		
		this.HLzTzL = new ModelRenderer(this, 20, 0);
		this.HLzTzL.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzTzL.setRotationPoint(1.5F, 9.0F, 2.0F);
		this.HLzTzL.setTextureSize(64, 64);
		this.HLzTzL.mirror = true;
		setRotation(this.HLzTzL, 0.7853982F, 0.0F, 0.0F);
		this.modelList.add(this.HLzTzL);
		
		this.HLzTzR = new ModelRenderer(this, 20, 0);
		this.HLzTzR.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzTzR.setRotationPoint(-1.5F, 9.0F, 2.0F);
		this.HLzTzR.setTextureSize(64, 64);
		this.HLzTzR.mirror = true;
		setRotation(this.HLzTzR, 0.7853982F, 0.0F, 0.0F);
		this.modelList.add(this.HLzTzR);
		
		this.HLzLzT = new ModelRenderer(this, 20, 0);
		this.HLzLzT.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzLzT.setRotationPoint(2.0F, 9.5F, 2.0F);
		this.HLzLzT.setTextureSize(64, 64);
		this.HLzLzT.mirror = true;
		setRotation(this.HLzLzT, 0.349066F, 0.0F, 1.570796F);
		this.modelList.add(this.HLzLzT);
		
		this.HLzTzC = new ModelRenderer(this, 20, 0);
		this.HLzTzC.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzTzC.setRotationPoint(0.0F, 9.0F, 2.0F);
		this.HLzTzC.setTextureSize(64, 64);
		this.HLzTzC.mirror = true;
		setRotation(this.HLzTzC, 0.7853982F, 0.0F, 0.0F);
		this.modelList.add(this.HLzTzC);
		
		this.HLzLzB = new ModelRenderer(this, 20, 0);
		this.HLzLzB.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzLzB.setRotationPoint(2.0F, 11.5F, 2.0F);
		this.HLzLzB.setTextureSize(64, 64);
		this.HLzLzB.mirror = true;
		setRotation(this.HLzLzB, 0.349066F, 0.0F, 1.570796F);
		this.modelList.add(this.HLzLzB);
		
		this.HLzRzT = new ModelRenderer(this, 20, 0);
		this.HLzRzT.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzRzT.setRotationPoint(-2.0F, 9.5F, 2.0F);
		this.HLzRzT.setTextureSize(64, 64);
		this.HLzRzT.mirror = true;
		setRotation(this.HLzRzT, 0.349066F, 0.0F, -1.570796F);
		this.modelList.add(this.HLzRzT);
		
		this.HLzRzB = new ModelRenderer(this, 20, 0);
		this.HLzRzB.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzRzB.setRotationPoint(-2.0F, 11.5F, 2.0F);
		this.HLzRzB.setTextureSize(64, 64);
		this.HLzRzB.mirror = true;
		setRotation(this.HLzRzB, 0.349066F, 0.0F, -1.570796F);
		this.modelList.add(this.HLzRzB);
		
		this.HLzBzC = new ModelRenderer(this, 20, 0);
		this.HLzBzC.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzBzC.setRotationPoint(0.0F, 12.0F, 2.0F);
		this.HLzBzC.setTextureSize(64, 64);
		this.HLzBzC.mirror = true;
		setRotation(this.HLzBzC, -0.5235988F, 0.0F, 0.0F);
		this.modelList.add(this.HLzBzC);
		
		this.HLzBzR = new ModelRenderer(this, 20, 0);
		this.HLzBzR.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzBzR.setRotationPoint(-1.5F, 12.0F, 2.0F);
		this.HLzBzR.setTextureSize(64, 64);
		this.HLzBzR.mirror = true;
		setRotation(this.HLzBzR, -0.5235988F, 0.0F, 0.017453F);
		this.modelList.add(this.HLzBzR);
		
		this.HLzBzL = new ModelRenderer(this, 20, 0);
		this.HLzBzL.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 3);
		this.HLzBzL.setRotationPoint(1.5F, 12.0F, 2.0F);
		this.HLzBzL.setTextureSize(64, 64);
		this.HLzBzL.mirror = true;
		setRotation(this.HLzBzL, -0.5235988F, 0.0F, 0.0F);
		this.modelList.add(this.HLzBzL);
		
	}
	
}
