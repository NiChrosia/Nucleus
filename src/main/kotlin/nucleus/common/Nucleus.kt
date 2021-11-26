package nucleus.common

import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import nucleus.test.NucleusTest
import org.apache.logging.log4j.LogManager

@Suppress("unused")
object Nucleus : ModInitializer {
    val log = LogManager.getLogger()

    override fun onInitialize() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment) {
            val test = NucleusTest()
            test.launch()
            test.pack.dump()
        }
    }
}