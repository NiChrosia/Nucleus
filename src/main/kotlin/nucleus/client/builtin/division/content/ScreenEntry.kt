package nucleus.client.builtin.division.content

import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry
import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.Text

open class ScreenEntry<T, S>(
    val type: ScreenHandlerType<T>,
    val constructor: (T, PlayerInventory, Text) -> S
) where T : ScreenHandler, S : Screen, S : ScreenHandlerProvider<T> {
    open fun publish() {
        ScreenRegistry.register(type, constructor)
    }
}