package devblueray.tutorialmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import devblueray.tutorialmod.TutorialMod;

public class OreBlock extends Block {

	public OreBlock(Material material) {
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(205.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(TutorialMod.tutorialModTab);
		
		
		
	}
	public Item getItemDropped(int i, Random random, int j) {
		return this == TutorialMod.oreTopazOre ? TutorialMod.itemTopaz : Item.getItemFromBlock(this);
	}
	
	public int quantityDropped(Random random) {
		return this == TutorialMod.oreTopazOre ? 4 + random.nextInt(5) : 1;
		
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(TutorialMod.modid + ":" + this.getUnlocalizedName().substring(5));
				
	}
	
}
