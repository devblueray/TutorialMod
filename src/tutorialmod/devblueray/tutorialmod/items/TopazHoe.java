package devblueray.tutorialmod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import devblueray.tutorialmod.TutorialMod;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;

public class TopazHoe extends ItemHoe {

	public TopazHoe(ToolMaterial p_i45343_1_) {
		super(p_i45343_1_);
this.setCreativeTab(TutorialMod.tutorialModTab);
		
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(TutorialMod.modid + ":" + this.getUnlocalizedName().substring(5));
		
	}

}
