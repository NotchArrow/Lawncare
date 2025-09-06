package com.notcharrow.lawncare.mixin;

import com.notcharrow.lawncare.config.ConfigManager;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldChunk.class)
public class WorldChunkMixin {
	@Inject(method = "runPostProcessing", at = @At("TAIL"))
	private void afterPostProcessing(CallbackInfo ci) {
		WorldChunk chunk = ((WorldChunk) (Object) this);
		World world = chunk.getWorld();
		ChunkPos chunkPos = chunk.getPos();
		BlockPos.Mutable pos = new BlockPos.Mutable(0, 0, 0);

		for (int x = 0; x < 16; x++) {
			for (int y = chunk.getBottomY(); y < chunk.getTopY(); y++) {
				for (int z = 0; z < 16; z++) {
					int realX = x + chunkPos.getStartX();
					int realZ = z + chunkPos.getStartZ();
					pos.set(realX, y, realZ);

					BlockState state = world.getBlockState(pos);
					Block block = state.getBlock();


					if (block.equals(Blocks.PINK_PETALS) && Math.random() > (ConfigManager.config.pinkPetals * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					}
					else if (block.equals(Blocks.GRASS) && Math.random() > (ConfigManager.config.shortGrass * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if (block.equals(Blocks.TALL_GRASS) && Math.random() > (ConfigManager.config.tallGrass * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if (block.equals(Blocks.FERN) && Math.random() > (ConfigManager.config.shortFerns * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if (block.equals(Blocks.LARGE_FERN) && Math.random() > (ConfigManager.config.tallFerns * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if (block == Blocks.SEAGRASS && Math.random() > (ConfigManager.config.shortSeagrass * 0.01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if (block == Blocks.TALL_SEAGRASS && Math.random() > (ConfigManager.config.tallSeagrass * 0.01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);

					}  else if (block == Blocks.DEAD_BUSH && Math.random() > (ConfigManager.config.deadBushes * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if ((block instanceof FlowerBlock || block instanceof TallFlowerBlock) && Math.random() > (ConfigManager.config.flowers * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					}
					else if (block == Blocks.MOSS_CARPET && Math.random() > (ConfigManager.config.mossCarpet * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if (block == Blocks.VINE && Math.random() > (ConfigManager.config.vines * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if (block == Blocks.SWEET_BERRY_BUSH && Math.random() > (ConfigManager.config.sweetBerries * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					} else if (block == Blocks.CACTUS && Math.random() > (ConfigManager.config.cactus * .01)) {
						world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
					}
				}
			}
		}
	}
}