package com.countrygamer.pvz.entities.mobs.plants;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.countrygamer.pvz.PvZ;

public class EntityPlantBase extends EntityGolem {
	private String texture;
	private String livingSound;
	private String hurtSound;
	private String deathSound;
	public int baseHealth;
	public ItemStack spawnStack;
	public float range = 10.0F;

	public EntityPlantBase(World world, ItemStack spawnStack) {
		super(world);

		setSize(1.0F, 0.8F);
		ai();

		this.spawnStack = spawnStack;
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public String getTexture() {
		return this.texture;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return PvZ.plantAttribute;
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public void onUpdate() {
		this.moveStrafing = (this.moveForward = 0.0F);

		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(
				0.0D);
		super.onUpdate();
	}

	public void knockBack(Entity par1Entity, float par2, double par3,
			double par5) {
	}

	protected void jump() {
	}

	protected void collideWithEntity(Entity par1Entity) {
	}

	public boolean canBePushed() {
		return false;
	}

	public boolean canAttackClass(Class par1Class) {
		return (!creeperCheck(par1Class)) && (!ghastCheck(par1Class));
	}

	protected boolean creeperCheck(Class par1Class) {
		return par1Class == EntityCreeper.class;
	}

	protected boolean ghastCheck(Class par1Class) {
		return par1Class == EntityGhast.class;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		setMaxHealth(PvZ.basePlantHealth);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(
				this.baseHealth);
	}

	public void setMaxHealth(int health) {
		this.baseHealth = health;
	}

	public void ai() {
		getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));

		this.stepHeight = 0.0F;
		canBreatheUnderwater();
	}
}