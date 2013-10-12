package CountryGamer_PlantsVsZombies.PvZMod;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class LiquidChlorophyllStill extends BlockStationary
{
  public int opacity;
  public int color;

  protected LiquidChlorophyllStill(int id)
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