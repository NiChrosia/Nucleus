package nucleus.client.builtin.division.content

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import nucleus.client.builtin.division.ClientModRoot
import nucleus.common.registrar.type.PublicationRegistrar

open class ScreenRegistrar<R : ClientModRoot<R>>(root: R) : PublicationRegistrar<Identifier, ScreenEntry<*, *>, R>(root) {
    override fun publish(key: Identifier, value: ScreenEntry<*, *>) {
        value.publish()
    }

    open fun <T, S> entryOf(
        type: ScreenHandlerType<T>,
        constructor: (T, PlayerInventory, Text) -> S
    ): ScreenEntry<T, S> where T : ScreenHandler, S : Screen, S : ScreenHandlerProvider<T> {
        return ScreenEntry(type, constructor)
    }
}