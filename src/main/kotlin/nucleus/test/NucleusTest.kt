package nucleus.test

import net.fabricmc.fabric.api.gametest.v1.FabricGameTest
import net.minecraft.test.GameTest
import net.minecraft.test.TestContext
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.test.category.TestCategory
import org.apache.logging.log4j.LogManager

open class NucleusTest {
    val log = LogManager.getLogger()

    @GameTest(structureName = FabricGameTest.EMPTY_STRUCTURE)
    fun test(helper: TestContext) {
        TestCategory.launch()

        check(Registry.BLOCK, TestCategory.content.block.test)
        check(Registry.ITEM, TestCategory.content.item.test)

        helper.complete()
        log.info("Nucleus test completed successfully.")
    }

    fun <T> check(registry: Registry<T>, entry: T) {
        check(registry, registry.getId(entry) ?: throw IllegalArgumentException("Given entry is not present in registry."))
    }

    fun <T> check(registry: Registry<T>, key: Identifier) {
        assert(registry.get(key) != null) {"Failed to find entry $key in registry $registry." }
    }
}