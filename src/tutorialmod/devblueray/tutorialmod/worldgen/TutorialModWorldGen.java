package devblueray.tutorialmod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import devblueray.tutorialmod.TutorialMod;

public class TutorialModWorldGen implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0:
			//Generate our surface world
			generateSurface(world, random, chunkX*16, chunkZ*16);
			
		case -1:
			//Generate our nether world
			generateNether(world, random, chunkX*16, chunkZ*16);
			
		case 1:
			//Generate our end world
			generateEnd(world, random, chunkX*16, chunkZ*16);

	
		}
		
	}

	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateNether(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub
		
	}

	private void generateSurface(World world, Random random, int blockXPos, int blockZPos) {
		//this.addOreSpawn(TutorialMod.oreAwesomiumOre, world, random, x = blockXPos, j = blockZPos, MaxX = 16, MaxZ = 16, maxVeinSize = 4-6, chancetospawn = 25, minY, Max Y
		this.addOreSpawn(TutorialMod.oreAwesomiumOre, world, random, blockXPos, blockZPos, 16, 16, 4+random.nextInt(6),25, 38, 100);
		this.addOreSpawn(TutorialMod.oreTinOre, world, random, blockXPos, blockZPos, 16, 16, 4+random.nextInt(6),25, 38, 100);
		this.addOreSpawn(TutorialMod.oreZincOre, world, random, blockXPos, blockZPos, 16, 16, 4+random.nextInt(6),25, 38, 100);
	}

	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		
			for (int i= 0; i < chanceToSpawn; i++) {
				int posX = blockXPos + random.nextInt(maxX);
				int posY = minY + random.nextInt(maxY - minY);
				int posZ = blockZPos + random.nextInt(maxZ);
				(new WorldGenMinable(block, maxVeinSize)).generate(world,random, posX, posY, posZ);
			}
		
	}
	

}
