package nucleus.testmod.registrar

import net.minecraft.block.entity.ChestBlockEntity
import nucleus.common.impl.registrar.template.BlockEntityTypeRegistrar
import nucleus.testmod.Nucleus
import nucleus.testmod.block.ExampleChestBlock

open class NBlockEntityTypeRegistrar(namespace: String) : BlockEntityTypeRegistrar(namespace) {
    val chest = register("sample_chest", typeOf<ExampleChestBlock, ChestBlockEntity>(Nucleus.blocks.chest))
}