package CountryGamer_PlantsVsZombies;

import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class LiquidChlorophyllFlow extends BlockFlowing
{
  public int opacity;
  public int color;

  protected LiquidChlorophyllFlow(int id)
  {
    super(id, Material.water);
    setHardness(100.0F);
    this.opacity = 1;
    setLightOpacity(this.opacity);
    this.color = 1094427;
    disableStats();

    setTickRandomly(true);
  }

  public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
  {
    return this.color;
  }
}