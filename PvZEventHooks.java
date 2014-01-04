package CountryGamer_PlantsVsZombies;

import java.util.Random;

import CountryGamer_PlantsVsZombies.Entities.Mobs.Plants.EntityPlantBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class PvZEventHooks
{
  @ForgeSubscribe
  public void onEntityUpdate(LivingEvent.LivingUpdateEvent event)
  {
    EntityLivingBase targetEntity = event.entityLiving;

    if (targetEntity.isPotionActive(PvZ_Main.empower))
    {
      if ((targetEntity.worldObj.rand.nextInt(20) != 0) || 
        (targetEntity.getCreatureAttribute() == PvZ_Main.plantAttribute)) {
        ((EntityPlantBase)targetEntity).heal(((EntityPlantBase)targetEntity).getMaxHealth());
      }
      else if (!(targetEntity instanceof EntityZombie))
      {
        if ((targetEntity instanceof EntityPlayer)) {
          ((EntityPlayer)targetEntity).heal(((EntityPlayer)targetEntity).getMaxHealth());
        }

      }

      if (targetEntity.getActivePotionEffect(PvZ_Main.empower).getDuration() == 0) {
        targetEntity.removePotionEffect(PvZ_Main.empower.id);
        return;
      }
    }
  }
}