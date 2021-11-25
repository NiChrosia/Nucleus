package nucleus.mixin;

import com.mojang.serialization.Lifecycle;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;
import nucleus.common.member.type.TransitionMappings;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DefaultedRegistry.class)
public abstract class RegistryMixin<T> extends SimpleRegistry<T> {
    public RegistryMixin(RegistryKey<? extends Registry<T>> registryKey, Lifecycle lifecycle) {
        super(registryKey, lifecycle);
    }

    @Shadow @Nullable public abstract T get(@Nullable Identifier id);

    @Inject(method = "get(Lnet/minecraft/util/Identifier;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
    public void get(Identifier id, CallbackInfoReturnable<T> info) {
        if (id != null && TransitionMappings.INSTANCE.containsKey(id)) {
            Identifier current = TransitionMappings.INSTANCE.get(id);
            T value = get(current);

            info.setReturnValue(value);
        }
    }
}
