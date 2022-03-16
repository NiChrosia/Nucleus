package sample.block

import net.minecraft.block.BlockState
import net.minecraft.block.ChestBlock
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.entity.ChestBlockEntity
import net.minecraft.util.math.BlockPos

open class SampleChestBlock(settings: Settings, type: () -> BlockEntityType<out ChestBlockEntity>) : ChestBlock(settings, type) {
    override fun createBlockEntity(pos: BlockPos, state: BlockState): ChestBlockEntity {
        return ChestBlockEntity(pos, state)
    }
}