package nucleus.common.impl.registrar.template.capability

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.ItemGroup

/** Item registrar capability for more easily assigning item groups. */
interface Grouped {
    val group: ItemGroup

    fun groupedSettings(): FabricItemSettings {
        val settings = FabricItemSettings()
        settings.group(group)

        return settings
    }
}