package CountryGamer_PlantsVsZombies.PvZMod;

import CountryGamer_PlantsVsZombies.PvZMod.Blocks.BlockChlorophyllBowl;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.BlockDarkenedGrass;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.BlockDave;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.BlockEndowedGrass;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.BlockGravestone;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.BlockGreenhouse;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityChlorophyllBowl;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityDave;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityGravestone;
import CountryGamer_PlantsVsZombies.PvZMod.Blocks.TileEnts.TileEntityGreenhouse;
import CountryGamer_PlantsVsZombies.PvZMod.Client.Gui.PvZGuiHandler;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Mobs.Plants.EntDec;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityCreeperPod;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityMoonlight;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityPeaPod;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntityShroomPod;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntitySnowPod;
import CountryGamer_PlantsVsZombies.PvZMod.Entities.Projectiles.EntitySunlight;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemBasicPlants;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemChlorophyll;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemFlag;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemFootballBoots;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemFootballChest;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemFootballHelm;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemFootballLegs;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemMoonlight;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemNightPlants;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemPeaPod;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemShroomPod;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemSnowPod;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemSunlight;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemTransTrowel;
import CountryGamer_PlantsVsZombies.PvZMod.Items.ItemTrowel;
import CountryGamer_PlantsVsZombies.PvZMod.Proxy.ServerProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

import java.io.PrintStream;
import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.event.EventBus;

@Mod(modid = "CountryGamer_PlantsVsZombies", name = "Plants Vs Zombies", version = "2.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "PvZ Mod" }, packetHandler = PvZPacketHandler.class)
public class PvZ_Main {
	public static final String modid = "CountryGamer_PlantsVsZombies";
	public static final String modidLower = "countrygamer_plantsvszombies";
	public static final String commonName = "Plants Vs Zombies";
	public static final String mcVersion = "1.6.2";
	public static final String modVersion = "2.3";
	public static final String channel = "PvZ Mod";

	@Mod.Instance("CountryGamer_PlantsVsZombies")
	public static PvZ_Main instance = new PvZ_Main();
	private PvZGuiHandler guiHandler = new PvZGuiHandler();

	@SidedProxy(clientSide = "CountryGamer_PlantsVsZombies.PvZMod.Proxy.ClientProxy", serverSide = "CountryGamer_PlantsVsZombies.PvZMod.Proxy.ServerProxy")
	public static ServerProxy proxy;
	public static String base_Tex = "countrygamer_plantsvszombies:";
	public static Item peaPod;
	public static int peaPod_ID;
	public static Item snowPod;
	public static int snowPod_ID;
	public static Item shroomPod;
	public static int shroomPod_ID;
	public static Item creeperPod;
	public static int creeperPod_ID;
	public static Item sunlight;
	public static int sunlight_ID;
	public static Item chlorophyll;
	public static int chlorophyll_ID;
	public static Item moonlight;
	public static int moonlight_ID;
	public static Item trowel;
	public static int trowel_ID;
	public static Item transTrowel;
	public static int transTrowel_ID;
	public static Item basicPlants;
	public static int basicPlants_ID;
	public static Item nightPlants;
	public static int nightPlants_ID;
	public static Item specialPlants;
	public static int specialPlants_ID;
	public static int[] specialPlantIDs;
	public static Item guideBook;
	public static int guideBook_ID;
	public static Block endowedGrass;
	public static int endowedGrass_ID;
	public static String endowedGrass_top_Tex = base_Tex + "endowedGrass_Top";
	public static String endowedGrass_bottom_Tex = base_Tex
			+ "endowedGrass_Bottom";
	public static String endowedGrass_side_Tex = base_Tex + "endowedGrass_Side";
	public static Block darkenedGrass;
	public static int darkenedGrass_ID;
	public static String darkenedGrass_top_Tex = base_Tex + "darkenedGrass_Top";
	public static String darkenedGrass_bottom_Tex = base_Tex
			+ "darkenedGrass_Bottom";
	public static String darkenedGrass_side_Tex = base_Tex
			+ "darkenedGrass_Side";
	public static Block chlorophyllBowl;
	public static int chlorophyllBowl_ID;
	public static String chlorophyllBowl_Empty_Tex = "/mods/CountryGamer_PlantsVsZombies/textures/blocks/Bowl Empty.png";
	public static String chlorophyllBowl_Filled_Tex = ":assets:" + base_Tex
			+ "textures:blocks:bowlFilled.png";
	public static int chlorophyllBowlModelID;
	public static Block seedBox;
	public static int seedBox_ID;
	public static String seedBox_Top_Tex = base_Tex + "seedBox_top";
	public static String seedBox_Side_Tex = base_Tex + "seedBox_side";
	public static Block gravestone;
	public static Block gravestoneReg;
	public static Block gravestoneFootball;
	public static Block gravestoneFlag;
	public static Block gravestoneCone;
	public static Block gravestoneBucket;
	public static Block[] gravestones = { gravestone, gravestoneReg,
			gravestoneFootball, gravestoneFlag, gravestoneCone,
			gravestoneBucket };

	public static int[] gravestone_ID = new int[6];
	public static String[] gravestoneStr = { "", "Regular", "Football", "Flag",
			"Cone", "Bucket" };
	public static int gravestoneModelID;
	public static Block greenhouse;
	public static int greenhouse_ID;
	public static int greenhouseModelID;
	public static Block chlorophyllLiquidStill;
	public static Block chlorophyllLiquidFlow;
	public static int chlorophyllLiquidStill_ID;
	public static int chlorophyllLiquidFlow_ID;
	public static String chlorophyllLiquidStill_Tex = base_Tex
			+ "Chlorophyll Still";
	public static String chlorophyllLiquidFlow_Tex = base_Tex
			+ "Chlorophyll Flow";
	public static final Material chlorophyllMat = new MaterialLiquid(
			MapColor.waterColor);
	public static Item footballHelm;
	public static int footballHelm_ID;
	public static Item footballChest;
	public static int footballChest_ID;
	public static Item footballLegs;
	public static int footballLegs_ID;
	public static Item footballBoots;
	public static int footballBoots_ID;
	public static Item flag;
	public static int flag_ID;
	public static Potion empower;
	public static int sunlightTimer;
	public static boolean holdSunlight;
	public static int basePodDamage;
	public static int basePlantHealth;
	public static int zombieSpawnDelay;
	public static boolean crops;
	public static double creeperPodRad;
	public static EnumCreatureAttribute plantAttribute = EnumHelper
			.addCreatureAttribute("PLANT");
	public static EnumArmorMaterial footballArmor = EnumHelper
			.addArmorMaterial("FOOTBALL_ARMOR", 12, new int[] { 1, 4, 3, 1 }, 0);
	public static CreativeTabs pvzTab;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		String itemCate = "Item IDs";
		String blockCate = "Block IDs";
		String liquidCate = "Liquid IDs";
		String cropCate = "Crop IDs";
		String ids = "IDs";
		String general = "general";

		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		config.load();

		chlorophyllBowl_ID = config.get(blockCate, "Chlorophyll Bowl", 500)
				.getInt();
		seedBox_ID = config.get(blockCate, "Box of Seeds", 501).getInt();
		greenhouse_ID = config.get(blockCate, "Greenhouse", 502).getInt();
		endowedGrass_ID = config.get(blockCate, "Endowed Grass", 503).getInt();
		darkenedGrass_ID = config.get(blockCate, "Darkened Grass", 504)
				.getInt();
		gravestone_ID[0] = config.get(blockCate, "Normal Gravestone", 505)
				.getInt();
		gravestone_ID[1] = config.get(blockCate, "Regular Gravestone", 506)
				.getInt();
		gravestone_ID[2] = config.get(blockCate, "Football Gravestone", 507)
				.getInt();
		gravestone_ID[3] = config.get(blockCate, "Flag Gravestone", 508)
				.getInt();
		gravestone_ID[4] = config.get(blockCate, "Cone Gravestone", 509)
				.getInt();
		gravestone_ID[5] = config.get(blockCate, "Bucket Gravestone", 510)
				.getInt();

		guideBook_ID = config.get(itemCate, "Plant Guide", 520).getInt();
		chlorophyll_ID = config.get(itemCate, "Chloropyll", 521).getInt();
		sunlight_ID = config.get(itemCate, "Sunlight", 522).getInt();
		moonlight_ID = config.get(itemCate, "Moonlight", 523).getInt();
		basicPlants_ID = config.get(itemCate, "Day Plants", 524).getInt();
		nightPlants_ID = config.get(itemCate, "Night Plants", 525).getInt();
		specialPlants_ID = config.get(itemCate, "Special Plants", 526).getInt();
		trowel_ID = config.get(itemCate, "Trowel", 527).getInt();
		transTrowel_ID = config.get(itemCate, "Transplant Trowel", 528)
				.getInt();
		peaPod_ID = config.get(itemCate, "Pea Pod", 529).getInt();
		snowPod_ID = config.get(itemCate, "Snow Pod", 530).getInt();
		shroomPod_ID = config.get(itemCate, "Shroom Pod", 531).getInt();
		creeperPod_ID = config.get(itemCate, "Creeper Pod", 532).getInt();
		footballHelm_ID = config.get(itemCate, "Football Helmet", 533).getInt();
		footballChest_ID = config.get(itemCate, "Football Chest", 534).getInt();
		footballLegs_ID = config.get(itemCate, "Football Leggings", 535)
				.getInt();
		footballBoots_ID = config.get(itemCate, "Football Boots", 536).getInt();
		flag_ID = config.get(itemCate, "Flag", 537).getInt();

		sunlightTimer = config.get(general,
				"Minutes between sunlight production", 5).getInt();
		basePodDamage = config.get(general, "Basic damage of a Pea Pod", 4)
				.getInt();
		basePlantHealth = config.get(general, "Base health of all Plants", 2)
				.getInt();
		zombieSpawnDelay = config.get(general,
				"Minutes in between waves of zombies. (Whole numbers only!)",
				10).getInt();
		creeperPodRad = config.get(general, "Creeper Pod Explosion Radius",
				1.0D).getDouble(1.0D);

		config.save();

		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if ((f.getName().equals("potionTypes"))
						|| (f.getName().equals("field_76425_a"))) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & 0xFFFFFFEF);

					potionTypes = (Potion[]) (Potion[]) f.get(null);
					Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0,
							potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				System.err
						.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}

		}

		MinecraftForge.EVENT_BUS.register(new PvZEventHooks());
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenderThings();
		proxy.registerTickHandler();

		pvzTab = new CreativeTabs("pvzTab") {
			public ItemStack getIconItemStack() {
				return new ItemStack(PvZ_Main.sunlight, 1, 0);
			}
		};
		LanguageRegistry.instance().addStringLocalization("itemGroup.pvzTab",
				"en_US", "Plants Vs Zombies");

		items();
		armor();
		blocks();
		proxy.registerBlocks();
		harvestLevel();
		entities();
		crafting();

		empower = new PotionEmpower(32, false, 0)
				.setPotionName("potion.empower");
		LanguageRegistry.instance().addStringLocalization("potion.empower",
				"Empower");

		NetworkRegistry.instance().registerGuiHandler(this, this.guiHandler);
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent postEvent) {
	}

	public void items() {
		chlorophyll = new ItemChlorophyll(chlorophyll_ID)
				.setUnlocalizedName("Chlorophyll");
		LanguageRegistry.addName(chlorophyll, "Chlorophyll");

		sunlight = new ItemSunlight(sunlight_ID).setUnlocalizedName("Sunlight");
		LanguageRegistry.addName(sunlight, "Sunlight");
		moonlight = new ItemMoonlight(moonlight_ID)
				.setUnlocalizedName("moonlight");
		LanguageRegistry.addName(moonlight, "Moonlight");

		trowel = new ItemTrowel(trowel_ID).setUnlocalizedName("trowel");
		LanguageRegistry.addName(trowel, "Trowel");
		transTrowel = new ItemTransTrowel(transTrowel_ID)
				.setUnlocalizedName("transTrowel");
		LanguageRegistry.addName(transTrowel, "Transplant Trowel");

		basicPlants = new ItemBasicPlants(basicPlants_ID)
				.setUnlocalizedName("basicPlants");

		String[] cropCodeNames = ItemBasicPlants.itemMetaNames;
		String[] cropGameNames = ItemBasicPlants.itemGameNames;
		for (int i = 0; i < cropCodeNames.length; i++) {
			LanguageRegistry.instance().addStringLocalization(
					"item.basicPlants." + cropCodeNames[i] + ".name",
					cropGameNames[i]);
		}

		nightPlants = new ItemNightPlants(nightPlants_ID)
				.setUnlocalizedName("nightPlants");

		cropCodeNames = ItemNightPlants.itemMetaNames;
		cropGameNames = ItemNightPlants.itemGameNames;
		for (int i = 0; i < cropCodeNames.length; i++) {
			LanguageRegistry.instance().addStringLocalization(
					"item.nightPlants." + cropCodeNames[i] + ".name",
					cropGameNames[i]);
		}

		peaPod = new ItemPeaPod(peaPod_ID).setUnlocalizedName("PeaPod");
		LanguageRegistry.addName(peaPod, "Pea Pod");
		snowPod = new ItemSnowPod(snowPod_ID).setUnlocalizedName("SnowPod");
		LanguageRegistry.addName(snowPod, "Snow Pod");
		shroomPod = new ItemShroomPod(shroomPod_ID)
				.setUnlocalizedName("shroomPod");
		LanguageRegistry.addName(shroomPod, "Shroom Pod");
	}

	public void armor() {
		int footBallMat = proxy.addArmor("football");

		footballHelm = new ItemFootballHelm(footballHelm_ID, footballArmor,
				footBallMat, 0).setUnlocalizedName("football_helmet");
		LanguageRegistry.addName(footballHelm, "Football Helmet");
		footballHelm.setCreativeTab(pvzTab);

		footballChest = new ItemFootballChest(footballChest_ID, footballArmor,
				footBallMat, 1).setUnlocalizedName("football_chest");
		LanguageRegistry.addName(footballChest, "Football Chest");
		footballChest.setCreativeTab(pvzTab);

		footballLegs = new ItemFootballLegs(footballLegs_ID, footballArmor,
				footBallMat, 2).setUnlocalizedName("football_legs");

		LanguageRegistry.addName(footballLegs, "Football Legs");
		footballLegs.setCreativeTab(pvzTab);

		footballBoots = new ItemFootballBoots(footballBoots_ID, footballArmor,
				footBallMat, 3).setUnlocalizedName("football_boots");
		LanguageRegistry.addName(footballBoots, "Football Boots");
		footballBoots.setCreativeTab(pvzTab);

		flag = new ItemFlag(flag_ID).setUnlocalizedName("flag");
		LanguageRegistry.addName(flag, "Flag");
	}

	public void blocks() {
		liquids();
		endowedGrass = new BlockEndowedGrass(endowedGrass_ID, Material.grass)
				.setHardness(0.6F).setStepSound(Block.soundGrassFootstep)
				.setUnlocalizedName("endowedGrass");

		GameRegistry.registerBlock(endowedGrass,
				"CountryGamer_PlantsVsZombiesendowedGrass");
		LanguageRegistry.addName(endowedGrass, "Endowed Grass");
		endowedGrass.setCreativeTab(pvzTab);

		darkenedGrass = new BlockDarkenedGrass(darkenedGrass_ID, Material.grass)
				.setHardness(0.6F).setStepSound(Block.soundGrassFootstep)
				.setUnlocalizedName("darkenedGrass");

		GameRegistry.registerBlock(darkenedGrass,
				"CountryGamer_PlantsVsZombiesdarkenedGrass");
		LanguageRegistry.addName(darkenedGrass, "Darkened Grass");
		darkenedGrass.setCreativeTab(pvzTab);

		GameRegistry.registerTileEntity(TileEntityChlorophyllBowl.class,
				"Chlorophyll Bowl");
		chlorophyllBowl = new BlockChlorophyllBowl(chlorophyllBowl_ID,
				TileEntityChlorophyllBowl.class).setHardness(0.2F)
				.setResistance(3.0F).setUnlocalizedName("chlorophyllBowl");

		GameRegistry.registerBlock(chlorophyllBowl, "chlorophyllBowl");
		LanguageRegistry.addName(chlorophyllBowl, "Chlorophyll Bowl");
		chlorophyllBowl.setCreativeTab(pvzTab);
		chlorophyllBowlModelID = 50;

		GameRegistry.registerTileEntity(TileEntityDave.class,
				"Crazy Dave's Box");
		seedBox = new BlockDave(seedBox_ID, TileEntityDave.class)
				.setHardness(2.5F).setStepSound(Block.soundWoodFootstep)
				.setUnlocalizedName("seedBox");

		LanguageRegistry.addName(seedBox, "Crazy Dave's Box");
		seedBox.setCreativeTab(pvzTab);

		GameRegistry.registerTileEntity(TileEntityGreenhouse.class,
				"Greenhouse");
		greenhouse = new BlockGreenhouse(greenhouse_ID,
				TileEntityGreenhouse.class).setHardness(0.2F)
				.setResistance(3.0F).setUnlocalizedName("greenhouse");

		GameRegistry.registerBlock(greenhouse, "greenhouse");
		LanguageRegistry.addName(greenhouse, "Greenhouse");
		greenhouse.setCreativeTab(pvzTab);
		greenhouseModelID = 52;
	}

	public void gravestones() {
		GameRegistry.registerTileEntity(TileEntityGravestone.class,
				"Gravestone");

		gravestone = new BlockGravestone(gravestone_ID[0], 0,
				TileEntityGravestone.class).setUnlocalizedName("gravestone");

		GameRegistry.registerBlock(gravestone, "gravestone");
		LanguageRegistry.addName(gravestone, "Zombie Gravestone");

		gravestoneReg = new BlockGravestone(gravestone_ID[1], 1,
				TileEntityGravestone.class).setUnlocalizedName("gravestoneReg");

		GameRegistry.registerBlock(gravestoneReg, "gravestoneReg");
		LanguageRegistry.addName(gravestoneReg, "Regular Zombie Gravestone");

		gravestoneFootball = new BlockGravestone(gravestone_ID[2], 2,
				TileEntityGravestone.class)
				.setUnlocalizedName("gravestoneFootball");

		GameRegistry.registerBlock(gravestoneFootball, "gravestoneFootball");
		LanguageRegistry.addName(gravestoneFootball,
				"Football Zombie Gravestone");

		gravestoneFlag = new BlockGravestone(gravestone_ID[3], 3,
				TileEntityGravestone.class)
				.setUnlocalizedName("gravestoneFlag");

		GameRegistry.registerBlock(gravestoneFlag, "gravestoneFlag");
		LanguageRegistry.addName(gravestoneFlag, "Flag Zombie Gravestone");

		gravestoneCone = new BlockGravestone(gravestone_ID[4], 4,
				TileEntityGravestone.class)
				.setUnlocalizedName("gravestoneCone");

		GameRegistry.registerBlock(gravestoneCone, "gravestoneCone");
		LanguageRegistry.addName(gravestoneCone, "Cone Zombie Gravestone");

		gravestoneBucket = new BlockGravestone(gravestone_ID[5], 5,
				TileEntityGravestone.class)
				.setUnlocalizedName("gravestoneBucket");

		GameRegistry.registerBlock(gravestoneBucket, "gravestoneBucket");
		LanguageRegistry.addName(gravestoneBucket, "Bucket Zombie Gravestone");

		gravestoneModelID = 51;

		gravestoneCraft();
	}

	public void gravestoneCraft() {
		GameRegistry.addRecipe(new ItemStack(gravestoneReg, 1), new Object[] {
				"xxx", "xcx", "xxx", Character.valueOf('c'), gravestone,
				Character.valueOf('x'), Item.rottenFlesh });

		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneFootball, 1),
				new Object[] { gravestone, footballHelm, footballChest,
						footballLegs, footballBoots });

		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneFlag, 1),
				new Object[] { gravestone, flag });

		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneCone, 1),
				new Object[] { gravestone });

		GameRegistry.addShapelessRecipe(new ItemStack(gravestoneBucket, 1),
				new Object[] { gravestone, Item.bucketEmpty });

		GameRegistry.addRecipe(new ItemStack(gravestone, 1), new Object[] {
				"xx", "cc", "vv", Character.valueOf('x'), Block.stone,
				Character.valueOf('c'), darkenedGrass, Character.valueOf('v'),
				Item.rottenFlesh });
	}

	public void liquids() {
	}

	public void harvestLevel() {
		MinecraftForge.setToolClass(trowel, "shovel", 2);
		MinecraftForge.setToolClass(transTrowel, "shovel", 5);

		MinecraftForge.setBlockHarvestLevel(chlorophyllBowl, "axe", 0);
		MinecraftForge.setBlockHarvestLevel(seedBox, "axe", 0);
		MinecraftForge.setBlockHarvestLevel(greenhouse, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(gravestone, "pickaxe", 2);
	}

	public void entities() {
		int throwEntityID = 5;
		throwEntityID++;
		EntityRegistry.registerModEntity(EntityPeaPod.class, "Pea Pod",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntitySnowPod.class, "Snow Pod",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntitySunlight.class, "Sunlight",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntityMoonlight.class, "Moonlight",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntityShroomPod.class, "Shroom Pod",
				throwEntityID, this, 64, 1, true);

		throwEntityID++;
		EntityRegistry.registerModEntity(EntityCreeperPod.class, "Creeper Pod",
				throwEntityID, this, 64, 1, true);

		EntDec.mobEnts();
	}

	public void crafting() {
		GameRegistry.addRecipe(new ItemStack(peaPod, 1), new Object[] { " x ",
				"xxx", " x ", Character.valueOf('x'), chlorophyll });

		GameRegistry.addRecipe(new ItemStack(snowPod, 1),
				new Object[] { " x ", "xcx", " x ", Character.valueOf('x'),
						chlorophyll, Character.valueOf('c'), Item.snowball });

		GameRegistry.addRecipe(new ItemStack(shroomPod, 1), new Object[] {
				" x ", "xcx", " x ", Character.valueOf('x'), chlorophyll,
				Character.valueOf('c'), moonlight });

		GameRegistry.addRecipe(new ItemStack(chlorophyllBowl, 1), new Object[] {
				" x ", "xcx", " x ", Character.valueOf('x'), chlorophyll,
				Character.valueOf('c'), Item.bowlEmpty });

		Object[] chloIngred = { Block.tallGrass, Block.leaves, Item.seeds,
				Item.carrot, Item.potato, Block.cactus };

		int[] chloResult = { 3, 4, 2, 2, 2, 5 };

		if (chloIngred.length == chloResult.length) {
			for (int i = 0; i < chloIngred.length; i++) {
				GameRegistry.addShapelessRecipe(new ItemStack(chlorophyll,
						chloResult[i]), new Object[] { chloIngred[i] });
			}
		} else {
			GameRegistry.addShapelessRecipe(new ItemStack(sunlight, 1),
					new Object[] { chlorophyll });
		}

		GameRegistry.addRecipe(new ItemStack(trowel, 1),
				new Object[] { " x ", "xxx", " c ", Character.valueOf('x'),
						Item.ingotIron, Character.valueOf('c'), Item.stick });

		GameRegistry.addShapelessRecipe(new ItemStack(transTrowel, 1),
				new Object[] { trowel, sunlight });

		GameRegistry
				.addRecipe(
						new ItemStack(greenhouse, 1),
						new Object[] { "xxx", "x x", "vcv",
								Character.valueOf('x'), Block.thinGlass,
								Character.valueOf('v'), Block.cobblestone,
								Character.valueOf('c'), Block.dirt });
	}
}