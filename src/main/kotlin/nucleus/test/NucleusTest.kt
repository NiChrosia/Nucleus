package nucleus.test

import net.fabricmc.fabric.api.gametest.v1.FabricGameTest
import net.minecraft.test.GameTest
import net.minecraft.test.TestContext
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.test.group.TestGroup
import org.apache.logging.log4j.LogManager

open class NucleusTest {
    val log = LogManager.getLogger()

    @GameTest(structureName = FabricGameTest.EMPTY_STRUCTURE)
    @Suppress("unused")
    fun test(helper: TestContext) {
        TestGroup.launch()

        check(Registry.BLOCK, TestGroup.content.block.test)
        check(Registry.ITEM, TestGroup.content.item.test)

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