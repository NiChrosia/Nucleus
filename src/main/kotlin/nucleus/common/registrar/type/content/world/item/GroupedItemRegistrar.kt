package nucleus.common.registrar.type.content.world.item

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.ItemGroup
import nucleus.common.datagen.lang.RegistrarPack

open class GroupedItemRegistrar(namespace: String, pack: RegistrarPack, open val group: () -> ItemGroup) : ItemRegistrar(namespace, pack) {
    open val groupedSettings: FabricItemSettings
        get() = FabricItemSettings().group(group())
}