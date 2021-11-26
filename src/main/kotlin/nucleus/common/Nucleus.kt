package nucleus.common

import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import nucleus.common.builtin.division.ModRoot
import nucleus.test.content.TContentCategory
import org.apache.logging.log4j.LogManager

@Suppress("unused")
object Nucleus : ModRoot<Nucleus>("nucleus"), ModInitializer {
    override val instance = this
    override val content = TContentCategory(this).collected()

    val log = LogManager.getLogger()

    override fun onInitialize() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment) {
            launch()
            pack.dump()
        }
    }
}