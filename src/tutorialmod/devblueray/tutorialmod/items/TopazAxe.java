package devblueray.tutorialmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import devblueray.tutorialmod.TutorialMod;

public class TopazAxe extends ItemAxe {

	public TopazAxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(TutorialMod.tutorialModTab);
	}
	
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister) {
	this.itemIcon = iconRegister.registerIcon(TutorialMod.modid + ":" + this.getUnlocalizedName().substring(5));
	
}
}
