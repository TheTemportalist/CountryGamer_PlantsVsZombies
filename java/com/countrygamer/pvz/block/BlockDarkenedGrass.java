package com.countrygamer.pvz.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.countrygamer.core.Base.common.block.BlockBase;
import com.countrygamer.pvz.PvZ;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDarkenedGrass extends BlockBase {
	private IIcon top;
	private IIcon bottom;
	private IIcon side;
	private IIcon[][] iconBuffer;

	public BlockDarkenedGrass(Material mat, String modid, String name) {
		super(mat, modid, name);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconReg) {
		this.top = iconReg.registerIcon(PvZ.darkenedGrass_top_Tex);
		this.bottom = iconReg.registerIcon(PvZ.darkenedGrass_bottom_Tex);
		this.side = iconReg.registerIcon(PvZ.darkenedGrass_side_Tex);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (side == 0) {
			return this.bottom;
		}
		if (side == 1) {
			return this.top;
		}
		if ((side == 2) || (side == 3) || (side == 4) || (side == 5)) {
			return this.side;
		}
		return this.top;
	}
}