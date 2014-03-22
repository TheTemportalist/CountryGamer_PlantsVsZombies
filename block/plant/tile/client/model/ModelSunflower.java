package com.countrygamer.pvz.block.plant.tile.client.model;

import net.minecraft.client.model.ModelRenderer;

import com.countrygamer.core.Base.client.ModelBase;

public class ModelSunflower extends ModelBase {
	ModelRenderer	Stem;
	ModelRenderer	Head;
	ModelRenderer	LEAFzL;
	ModelRenderer	LEAFzR;
	ModelRenderer	HLzTzL;
	ModelRenderer	HLzTzR;
	ModelRenderer	HLzLzT;
	ModelRenderer	HLzLzB;
	ModelRenderer	HLzRzT;
	ModelRenderer	HLzRzB;
	ModelRenderer	SHLzLzT;
	ModelRenderer	SHLzLzB;
	ModelRenderer	SHLzRzT;
	ModelRenderer	SHLzRzB;
	ModelRenderer	THLzT;
	ModelRenderer	THLzR;
	ModelRenderer	THLzL;
	
	public ModelSunflower() {
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
		this.HLzTzL.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
		this.HLzTzL.setRotationPoint(1.5F, 8.0F, -0.5F);
		this.HLzTzL.setTextureSize(64, 64);
		this.HLzTzL.mirror = true;
		setRotation(this.HLzTzL, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.HLzTzL);
		
		this.HLzTzR = new ModelRenderer(this, 20, 0);
		this.HLzTzR.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
		this.HLzTzR.setRotationPoint(-1.5F, 8.0F, -0.5F);
		this.HLzTzR.setTextureSize(64, 64);
		this.HLzTzR.mirror = true;
		setRotation(this.HLzTzR, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.HLzTzR);
		
		this.HLzLzT = new ModelRenderer(this, 20, 0);
		this.HLzLzT.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
		this.HLzLzT.setRotationPoint(2.5F, 9.0F, -0.5F);
		this.HLzLzT.setTextureSize(64, 64);
		this.HLzLzT.mirror = true;
		setRotation(this.HLzLzT, 0.0F, 0.0F, 1.570796F);
		this.modelList.add(this.HLzLzT);
		
		this.HLzLzB = new ModelRenderer(this, 20, 0);
		this.HLzLzB.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
		this.HLzLzB.setRotationPoint(2.5F, 12.0F, -0.5F);
		this.HLzLzB.setTextureSize(64, 64);
		this.HLzLzB.mirror = true;
		setRotation(this.HLzLzB, 0.0F, 0.0F, 1.570796F);
		this.modelList.add(this.HLzLzB);
		
		this.HLzRzT = new ModelRenderer(this, 20, 0);
		this.HLzRzT.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
		this.HLzRzT.setRotationPoint(-2.5F, 9.0F, -0.5F);
		this.HLzRzT.setTextureSize(64, 64);
		this.HLzRzT.mirror = true;
		setRotation(this.HLzRzT, 0.0F, 0.0F, -1.570796F);
		this.modelList.add(this.HLzRzT);
		
		this.HLzRzB = new ModelRenderer(this, 20, 0);
		this.HLzRzB.addBox(-1.0F, -3.0F, -0.5F, 2, 3, 2);
		this.HLzRzB.setRotationPoint(-2.5F, 12.0F, -0.5F);
		this.HLzRzB.setTextureSize(64, 64);
		this.HLzRzB.mirror = true;
		setRotation(this.HLzRzB, 0.0F, 0.0F, -1.570796F);
		this.modelList.add(this.HLzRzB);
		
		this.SHLzLzT = new ModelRenderer(this, 28, 0);
		this.SHLzLzT.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.SHLzLzT.setRotationPoint(2.5F, 7.0F, -0.5F);
		this.SHLzLzT.setTextureSize(64, 64);
		this.SHLzLzT.mirror = true;
		setRotation(this.SHLzLzT, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.SHLzLzT);
		
		this.SHLzLzB = new ModelRenderer(this, 28, 2);
		this.SHLzLzB.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
		this.SHLzLzB.setRotationPoint(1.0F, 13.0F, -0.5F);
		this.SHLzLzB.setTextureSize(64, 64);
		this.SHLzLzB.mirror = true;
		setRotation(this.SHLzLzB, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.SHLzLzB);
		
		this.SHLzRzT = new ModelRenderer(this, 28, 0);
		this.SHLzRzT.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.SHLzRzT.setRotationPoint(-3.5F, 7.0F, -0.5F);
		this.SHLzRzT.setTextureSize(64, 64);
		this.SHLzRzT.mirror = true;
		setRotation(this.SHLzRzT, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.SHLzRzT);
		
		this.SHLzRzB = new ModelRenderer(this, 28, 2);
		this.SHLzRzB.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
		this.SHLzRzB.setRotationPoint(-3.0F, 13.0F, -0.5F);
		this.SHLzRzB.setTextureSize(64, 64);
		this.SHLzRzB.mirror = true;
		setRotation(this.SHLzRzB, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.SHLzRzB);
		
		this.THLzT = new ModelRenderer(this, 28, 4);
		this.THLzT.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.THLzT.setRotationPoint(-0.5F, 7.0F, -0.5F);
		this.THLzT.setTextureSize(64, 64);
		this.THLzT.mirror = true;
		setRotation(this.THLzT, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.THLzT);
		
		this.THLzR = new ModelRenderer(this, 28, 4);
		this.THLzR.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.THLzR.setRotationPoint(-3.5F, 10.0F, -0.5F);
		this.THLzR.setTextureSize(64, 64);
		this.THLzR.mirror = true;
		setRotation(this.THLzR, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.THLzR);
		
		this.THLzL = new ModelRenderer(this, 28, 4);
		this.THLzL.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.THLzL.setRotationPoint(2.5F, 10.0F, -0.5F);
		this.THLzL.setTextureSize(64, 64);
		this.THLzL.mirror = true;
		setRotation(this.THLzL, 0.0F, 0.0F, 0.0F);
		this.modelList.add(this.THLzL);
		
	}
	
}
