package nucleus.common.registrar.type.content.world.recipe

import net.minecraft.recipe.RecipeType
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.VanillaRegistrar

open class RecipeRegistrar(namespace: String) : VanillaRegistrar<RecipeType<*>>(Registry.RECIPE_TYPE, namespace)