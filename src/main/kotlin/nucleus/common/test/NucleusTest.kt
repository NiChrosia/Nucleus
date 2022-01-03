package nucleus.common.test

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.gametest.v1.FabricGameTest
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.test.GameTest
import net.minecraft.test.TestContext
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.test.content.TContentCategory

@Suppress("unused")
open class NucleusTest : ModRoot<NucleusTest>("nucleus"), ModInitializer {
    override val content = TContentCategory(this)

    override fun onInitialize() {
        if (FabricLoader.getInstance().isDevelopmentEnvironment) {
            launch(this)
        }
    }

    @GameTest(structureName = FabricGameTest.EMPTY_STRUCTURE)
    fun test(helper: TestContext) {
        assert(Registry.BLOCK.contains(content.block.test)) { "Failed to find test entry in block registry." }
        assert(Registry.ITEM.contains(content.item.test)) { "Failed to find test entry in item registry." }

        helper.complete()
    }
}