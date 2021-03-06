package devblueray.tutorialmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import devblueray.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class AwesomiumBlock extends Block{
	public AwesomiumBlock(Material material) {
		super(material);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(TutorialMod.tutorialModTab);
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(TutorialMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}
