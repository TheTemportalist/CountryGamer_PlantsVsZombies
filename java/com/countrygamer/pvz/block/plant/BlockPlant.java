package com.countrygamer.pvz.block.plant;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

import com.countrygamer.core.Base.common.block.BlockContainerBase;

public class BlockPlant extends BlockContainerBase {
	
	public BlockPlant(Material mat, String modid, String name,
			Class<? extends TileEntity> tileEntityClass) {
		super(mat, modid, name, tileEntityClass);
		this.setBlockBounds();
	}
	
	private void setBlockBounds() {
		this.setBlockBounds(0.44F, 0.0F, 0.44F, 0.56F, 0.95F, 0.56F);
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
}
