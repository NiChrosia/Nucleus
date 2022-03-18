package nucleus.client.impl.registrar.template

import net.minecraft.client.gui.screen.Screen
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.client.gui.screen.ingame.ScreenHandlerProvider
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.text.Text
import nucleus.common.impl.registrar.DeferredRegistrar

open class ScreenRegistrar : DeferredRegistrar<ScreenHandlerType<*>, HandledScreens.Provider<*, *>>({ HandledScreens.PROVIDERS }) {
    // provide a library function for an otherwise private constructor
    fun <S, H> providerOf(factory: (H, PlayerInventory, Text) -> S): HandledScreens.Provider<H, S> where S : Screen, S : ScreenHandlerProvider<H>, H : ScreenHandler {
        return HandledScreens.Provider(factory)
    }
}