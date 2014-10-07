package devblueray.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import devblueray.tutorialmod.blocks.AwesomiumBlock;
import devblueray.tutorialmod.blocks.OreBlock;
import devblueray.tutorialmod.handler.CraftingHandler;
import devblueray.tutorialmod.handler.FuelHandler;
import devblueray.tutorialmod.items.IronHammer;
import devblueray.tutorialmod.items.IronPunch;
import devblueray.tutorialmod.items.NCItems;
import devblueray.tutorialmod.worldgen.TutorialModWorldGen;


@Mod(modid = TutorialMod.modid, name = "Tutorial Mod", version = TutorialMod.version)



public class TutorialMod {
	
	public static final String modid = "TutorialMod";
	public static final String version = "0.0.1-dev";
	
	TutorialModWorldGen eventWorldGen = new TutorialModWorldGen();
	
	public static CreativeTabs tutorialModTab;
	
	public static Item itemAwesomiumIngot;
	public static Item itemTinIngot;
	public static Item itemTinCog;
	public static Item itemTreePitch;
	public static Item itemIronWasher;
	public static Item itemIronHammer;
	public static Item itemIronPunch;
	public static Item itemIronDisc;
	public static Block oreAwesomiumOre;
	public static Block oreTinOre;
	public static Block oreZincOre;
	
	public static Block blockAwesomiumBlock;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		
		tutorialModTab = new CreativeTabs("tutorialModTab") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(TutorialMod.oreAwesomiumOre);
			}
		};
		
		//Initilizations
		
		//Items
		itemAwesomiumIngot = new NCItems().setUnlocalizedName("AwesomiumIngot");
		itemTinIngot = new NCItems().setUnlocalizedName("TinIngot");
		itemTinCog = new NCItems().setUnlocalizedName("TinCog");
		itemTreePitch = new NCItems().setUnlocalizedName(("TreePitch"));
		itemIronWasher = new NCItems().setUnlocalizedName("IronWasher");
		itemIronDisc = new NCItems().setUnlocalizedName("IronDisc");
		itemIronHammer = new IronHammer().setUnlocalizedName("IronHammer");
		itemIronPunch = new IronPunch().setUnlocalizedName("IronPunch");
		
		
		//Ores
		oreAwesomiumOre = new OreBlock(Material.rock).setBlockName("AwesomiumOre");
		oreTinOre = new OreBlock(Material.rock).setBlockName("TinOre");
		oreZincOre = new OreBlock(Material.rock).setBlockName("ZincOre");
		
		//Blocks
		blockAwesomiumBlock = new AwesomiumBlock(Material.iron).setBlockName("AwesomiumBlock");
		
		
		//WorldGen
		
		
		//Registrations
		
		//Items
		GameRegistry.registerItem(itemAwesomiumIngot, "AwesomiumIngot");
		GameRegistry.registerItem(itemTinIngot, "TinIngot");
		GameRegistry.registerItem(itemTinCog, "TinCog");
		GameRegistry.registerItem(itemTreePitch, "TreePitch");
		GameRegistry.registerItem(itemIronWasher, "IronWasher");
		GameRegistry.registerItem(itemIronDisc, "IronDisc");
		GameRegistry.registerItem(itemIronHammer, "IronHammer");
		GameRegistry.registerItem(itemIronPunch, "IronPunch");
		
		//Blocks
		GameRegistry.registerBlock(blockAwesomiumBlock, "AwesomiumBlock");
		
		//Ores
		GameRegistry.registerBlock(oreAwesomiumOre, "AwesomiumOre");
		GameRegistry.registerBlock(oreTinOre, "TinOre");
		GameRegistry.registerBlock(oreZincOre, "ZincOre");
		
		//WorldGen
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		FMLCommonHandler.instance().bus().register((new CraftingHandler()));
		
		//Recipes
		GameRegistry.addRecipe(new ItemStack(blockAwesomiumBlock),new Object[]{"CCC", "CCC", "CCC", 'C', itemAwesomiumIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(oreAwesomiumOre), new Object[]{itemAwesomiumIngot, Blocks.cobblestone});
		GameRegistry.addRecipe(new ItemStack(itemTinCog, 4), new Object[]{" X ", "XFX", " X ", 'X', itemTinIngot, 'F', Items.flint});
		GameRegistry.addRecipe(new ItemStack(itemIronDisc, 4), new Object[]{"IH", 'I', Items.iron_ingot, 'H', new ItemStack(itemIronHammer,1,OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addRecipe(new ItemStack(itemIronWasher), new Object[]{"DP", 'D', itemIronDisc, 'P', new ItemStack(itemIronPunch, 1, OreDictionary.WILDCARD_VALUE)});
		
		//Smelting
		GameRegistry.addSmelting(oreAwesomiumOre, new ItemStack(itemAwesomiumIngot, 2), 1000);
		
		//Fuel
		GameRegistry.registerFuelHandler(new FuelHandler());
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
	

}
