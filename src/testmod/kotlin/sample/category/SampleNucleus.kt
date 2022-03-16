package sample.category

import net.fabricmc.api.ModInitializer
import nucleus.api.category.Category
import nucleus.api.category.Nucleus
import sample.registrar.BlockEntityTypeRegistrar
import sample.registrar.BlockRegistrar
import sample.registrar.ItemRegistrar

object SampleNucleus : Nucleus, ModInitializer {
    const val namespace = "sample"

    val blocks = BlockRegistrar(namespace)
    val blockEntityTypes = BlockEntityTypeRegistrar(namespace)
    val items = ItemRegistrar(namespace)

    override val categories = listOf<Category>()

    override fun onInitialize() {
        launch()
    }
}