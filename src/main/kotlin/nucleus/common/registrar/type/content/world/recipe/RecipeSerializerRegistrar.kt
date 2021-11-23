package nucleus.common.registrar.type.content.world.recipe

import net.minecraft.recipe.RecipeSerializer
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.VanillaRegistrar

open class RecipeSerializerRegistrar(namespace: String) : VanillaRegistrar<RecipeSerializer<*>>(Registry.RECIPE_SERIALIZER, namespace)