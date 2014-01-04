package CountryGamer_PlantsVsZombies.Entities.Projectiles;

import java.util.Random;

import CountryGamer_PlantsVsZombies.PvZ_Main;
import CountryGamer_PlantsVsZombies.PvZ_Util;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMoonlight extends EntityPodBase
{
  public byte damage = 2;
  public boolean toDamage = false;
  public EntityLivingBase target = null;

  public EntityMoonlight(World world) {
    super(world);
  }
  public EntityMoonlight(World world, EntityLivingBase entLiv) {
    super(world, entLiv);
  }
  public EntityMoonlight(World world, double x, double y, double z) {
    super(world, x, y, z);
  }
  public boolean canAttackWithItem() {
    return false; } 
  protected float getGravityVelocity() { return 0.01F;
  }

  protected void onImpact(MovingObjectPosition movObjPos)
  {
    int x = movObjPos.blockX; int y = movObjPos.blockY; int z = movObjPos.blockZ;
    World world = this.worldObj;
    EntityPlayer player = (EntityPlayer)getThrower();
    Random itemRand = new Random();

    int blockid = world.getBlockId(x, y, z);
    if ((blockid == Block.dirt.blockID) || (blockid == Block.grass.blockID) || (blockid == Block.mycelium.blockID))
    {
      world.setBlock(x, y, z, PvZ_Main.darkenedGrass.blockID);
      setDead();
      return;
    }
    if (blockid == PvZ_Main.endowedGrass.blockID) {
      PvZ_Util.spawnItem(world, x, y, z, new ItemStack(PvZ_Main.sunlight, 1));
      world.setBlock(x, y, z, PvZ_Main.darkenedGrass.blockID);
      setDead();
      return;
    }
    PvZ_Util.spawnItem(world, x, y, z, new ItemStack(PvZ_Main.moonlight, 1));
    setDead();
  }
}