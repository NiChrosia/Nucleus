package nucleus.common

import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import nucleus.test.category.TestCategory

@Suppress("unused")
object Nucleus : ModInitializer {
    override fun onInitialize() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment) {
            TestCategory.launch()
        }
    }
}