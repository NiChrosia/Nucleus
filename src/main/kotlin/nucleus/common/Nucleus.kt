package nucleus.common

import net.fabricmc.api.ModInitializer
import nucleus.common.registrar.builtin.MinecraftCategory

@Suppress("unused")
object Nucleus : ModInitializer {
    override fun onInitialize() {
        MinecraftCategory.launch()
    }
}