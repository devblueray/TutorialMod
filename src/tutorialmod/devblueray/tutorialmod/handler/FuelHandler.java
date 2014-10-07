package devblueray.tutorialmod.handler;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import devblueray.tutorialmod.TutorialMod;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == TutorialMod.itemTreePitch) return 800;
		
		return 0;
	}
	
}
