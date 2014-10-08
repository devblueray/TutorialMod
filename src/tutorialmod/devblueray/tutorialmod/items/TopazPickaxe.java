package devblueray.tutorialmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import devblueray.tutorialmod.TutorialMod;

public class TopazPickaxe extends ItemPickaxe {

	public TopazPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.setCreativeTab(TutorialMod.tutorialModTab);
		
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(TutorialMod.modid + ":" + this.getUnlocalizedName().substring(5));
		
	}
}


