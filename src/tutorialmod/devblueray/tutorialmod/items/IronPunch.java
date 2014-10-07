package devblueray.tutorialmod.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import devblueray.tutorialmod.TutorialMod;

public class IronPunch extends Item {
	public IronPunch() {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setNoRepair();
		this.setCreativeTab(TutorialMod.tutorialModTab);
		
	}
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister) {
	this.itemIcon = iconRegister.registerIcon(TutorialMod.modid + ":" + this.getUnlocalizedName().substring(5));
	
}
}
