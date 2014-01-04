package CountryGamer_PlantsVsZombies.Blocks;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class BlockDarkenedGrass extends Block
{
  private Icon top;
  private Icon bottom;
  private Icon side;
  private Icon[][] iconBuffer;

  public BlockDarkenedGrass(int id, Material mat)
  {
    super(id, mat);
  }

  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister iconReg)
  {
    this.top = iconReg.registerIcon(PvZ_Main.darkenedGrass_top_Tex);
    this.bottom = iconReg.registerIcon(PvZ_Main.darkenedGrass_bottom_Tex);
    this.side = iconReg.registerIcon(PvZ_Main.darkenedGrass_side_Tex);
  }
  @SideOnly(Side.CLIENT)
  public Icon getIcon(int side, int meta) {
    if (side == 0) {
      return this.bottom;
    }
    if (side == 1) {
      return this.top;
    }
    if ((side == 2) || (side == 3) || (side == 4) || (side == 5))
    {
      return this.side;
    }
    return this.top;
  }
}