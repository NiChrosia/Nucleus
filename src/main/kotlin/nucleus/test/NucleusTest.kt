package nucleus.test

import net.fabricmc.fabric.api.gametest.v1.FabricGameTest
import net.minecraft.test.GameTest
import net.minecraft.test.TestContext
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.Nucleus

@Suppress("unused")
open class NucleusTest {
    @GameTest(structureName = FabricGameTest.EMPTY_STRUCTURE)
    fun test(helper: TestContext) {
        Nucleus.apply {
            check(Registry.BLOCK, content.block.test)
            check(Registry.ITEM, content.item.test)

            helper.complete()
            log.info("Test completed successfully.")
        }
    }

    fun <T> check(registry: Registry<T>, entry: T) {
        val registryEntry = registry.entries.find { it.value == entry }
        val entryId = registryEntry?.key?.value

        check(registry, entryId ?: throw IllegalArgumentException("Given entry is not present in registry."))
    }

    fun <T> check(registry: Registry<T>, key: Identifier) {
        assert(registry.ids.contains(key)) { "Failed to find entry $key in registry $registry." }
    }
}