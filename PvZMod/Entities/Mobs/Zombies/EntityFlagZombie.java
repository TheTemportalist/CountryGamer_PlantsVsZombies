package CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Zombies;

import CountryGamer_PlantsVsZombies.PvZMod.PvZ_Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFlagZombie extends EntityZombie
{
  public boolean hit = false;

  public EntityFlagZombie(World world) {
    super(world);

    setCurrentItemOrArmor(0, new ItemStack(PvZ_Main.flag, 1));

    int min = 1; int max = 4;
    int entIndex = min + (int)(Math.random() * (max - min + 1));
    switch (entIndex = 1) {
    case 1:
      for (int i = 0; i < 11; i++) {
        EntityZombie ent = new EntityZombie(world);
        ent.setPosition(this.posX, this.posY + 1.0D, this.posZ);
        world.spawnEntityInWorld(ent);
      }
      break;
    case 2:
      break;
    case 3:
      break;
    case 4:
      break;
    case 5:
      break;
    }
  }
}