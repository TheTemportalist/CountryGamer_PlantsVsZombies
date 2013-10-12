package CountryGamer_PlantsVsZombies.PvZMod.Proxy;

import CountryGamer_PlantsVsZombies.PvZMod.ClientTickHandler;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.RenderChlorophyllBowl;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.RenderGravestone;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.RenderGreenhouse;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityChlorophyllBowl;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityGravestone;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityGreenhouse;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends ServerProxy
{
  public void registerRenderThings()
  {
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChlorophyllBowl.class, new RenderChlorophyllBowl());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGravestone.class, new RenderGravestone());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGreenhouse.class, new RenderGreenhouse());
  }

  public int addArmor(String armor)
  {
    return 0;
  }

  public void registerTickHandler()
  {
    TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
  }
}