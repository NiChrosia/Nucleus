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
            Registry.BLOCK.assertFound(content.block.test)
            Registry.ITEM.assertFound(content.item.test)

            helper.complete()
            log.info("Test completed successfully.")
        }
    }

    fun <T> Registry<T>.assertFound(entry: T) {
        val registryEntry = entries.find { it.value == entry }
        val entryId = registryEntry?.key?.value

        assertFound(entryId ?: throw IllegalArgumentException("Given entry is not present in registry."))
    }

    fun <T> Registry<T>.assertFound(key: Identifier) {
        assert(ids.contains(key)) { "Failed to find entry $key in registry $this." }
    }
}