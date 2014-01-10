package CountryGamer_PlantsVsZombies.Entities.Mobs.Zombies;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityExplorerZombie extends EntityZombie {

	public EntityExplorerZombie(World world) {
		super(world);

		this.setCurrentItemOrArmor(4, new ItemStack(Item.helmetLeather));
		this.setCurrentItemOrArmor(3, new ItemStack(Item.plateLeather));
		this.setCurrentItemOrArmor(2, new ItemStack(Item.legsLeather));
		this.setCurrentItemOrArmor(1, new ItemStack(Item.bootsLeather));
		this.setCurrentItemOrArmor(0, new ItemStack(Block.torchWood));
		
	}

}
