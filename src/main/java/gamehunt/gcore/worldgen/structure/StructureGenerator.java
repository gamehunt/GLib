package gamehunt.gcore.worldgen.structure;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.fml.common.IWorldGenerator;

public class StructureGenerator implements IWorldGenerator{
	
	static ArrayList<IStructure> struct_list = new ArrayList<IStructure>();
	
	public static void addStructure(IStructure s){
		if(!struct_list.contains(s)){
			struct_list.add(s);
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
			for(IStructure s : struct_list){
				BlockPos basePos = new BlockPos(chunkX * 16 + random.nextInt(16), 100, chunkZ * 16 + random.nextInt(16));
				if(s.canGenerateHere(world, basePos)){
					final PlacementSettings settings = new PlacementSettings().setRotation(Rotation.NONE);
		            final Template template = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), s.getStructure());
		            if(s.getProcessor() != null){
		            	template.addBlocksToWorld(world, basePos,s.getProcessor(),settings,2);
		            }else{
		            	template.addBlocksToWorld(world, basePos,settings);
		            }
				}
			}
	}

}