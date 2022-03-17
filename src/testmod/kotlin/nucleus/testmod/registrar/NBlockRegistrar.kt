package nucleus.testmod.registrar

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Material
import nucleus.common.impl.registrar.template.BlockRegistrar
import nucleus.testmod.block.ExampleChestBlock
import nucleus.testmod.Nucleus

class NBlockRegistrar(namespace: String) : BlockRegistrar(namespace) {
    // explicitly typing blocks with entities is necessary to avoid infinite recursion (i.e., type -> block -> type...)
    val chest: ExampleChestBlock = register("chest", ExampleChestBlock(FabricBlockSettings.of(Material.WOOD)) { Nucleus.blockEntityTypes.chest })
}