package sample.registrar

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.util.registry.Registry
import nucleus.impl.registrar.DeferredRegistrar

open class ItemRegistrar(namespace: String) : DeferredRegistrar<Item>(Registry.ITEM, namespace) {
    val item = register("item", Item(FabricItemSettings()))
}