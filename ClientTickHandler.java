package CountryGamer_PlantsVsZombies;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;

public class ClientTickHandler
  implements ITickHandler
{
  public void tickStart(EnumSet<TickType> type, Object[] tickData)
  {
  }

  public void tickEnd(EnumSet<TickType> type, Object[] tickData)
  {
  }

  public EnumSet<TickType> ticks()
  {
    return EnumSet.of(TickType.CLIENT);
  }

  public String getLabel()
  {
    return "SunlightTraceLight";
  }
}