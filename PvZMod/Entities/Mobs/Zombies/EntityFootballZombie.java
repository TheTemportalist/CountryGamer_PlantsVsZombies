package CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Zombies;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFootballZombie extends EntityZombie
{
  public EntityFootballZombie(World par1World)
  {
    super(par1World);

    setCurrentItemOrArmor(4, new ItemStack(PvZ_Main.footballHelm, 1));

    setCurrentItemOrArmor(3, new ItemStack(PvZ_Main.footballChest, 1));

    setCurrentItemOrArmor(2, new ItemStack(PvZ_Main.footballLegs, 1));

    setCurrentItemOrArmor(1, new ItemStack(PvZ_Main.footballBoots, 1));
  }
}