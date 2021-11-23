package nucleus.client.registrar.builtin.content

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.Text

/** A data structure containing a screen handler type and a screen constructor. The purpose of this abstraction is to
 * allow dynamic publishing of screens, as wildcards do not match the constrains in [ScreenRegistry.register]. */
open class ScreenEntry<T : ScreenHandler, S>(val type: ScreenHandlerType<T>, val constructor: (T, PlayerInventory, Text) -> S) where S : Screen, S : ScreenHandlerProvider<T> {
    open fun publish() {
        ScreenRegistry.register(type, constructor)
    }
}