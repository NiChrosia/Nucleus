package nucleus.client.registrar.type.content

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import nucleus.common.registrar.base.identity.IdentifyingRegistrar

open class ScreenRegistrar(namespace: String) : IdentifyingRegistrar<ScreenEntry<*, *>>(namespace) {
    open fun <T, S> entryOf(
        type: ScreenHandlerType<T>,
        constructor: (T, PlayerInventory, Text) -> S
    ): ScreenEntry<T, S> where T : ScreenHandler, S : Screen, S : ScreenHandlerProvider<T> {
        return ScreenEntry(type, constructor)
    }

    override fun publish(key: Identifier, value: ScreenEntry<*, *>): ScreenEntry<*, *> {
        return super.publish(key, value).also(ScreenEntry<*, *>::publish)
    }
}