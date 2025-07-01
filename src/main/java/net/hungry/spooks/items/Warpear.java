package net.hungry.spooks.items;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Warpear extends Item {
    public Warpear(Settings settings) {
        super(settings);
    }

    public static FoodComponent warpearFood = new FoodComponent.Builder().snack().nutrition(3).saturationModifier(0.25F).build();

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof LivingEntity) {
            if (!world.isClient) {
                for (int i = 0; i < 16; i++) {
                    double X = user.getX() + (user.getRandom().nextDouble() - 0.5) * 2.0;
                    double Y = MathHelper.clamp(
                            user.getY() + (user.getRandom().nextInt(16) - 8), (double)world.getBottomY(), (double)(world.getBottomY() + ((ServerWorld)world).getLogicalHeight() - 1)
                    );
                    double Z = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 2.0;
                    if (user.hasVehicle()) {
                        user.stopRiding();
                    }

                    Vec3d formerLocation = user.getPos();
                    if (user.teleport(X, Y, Z, true)) {
                        world.emitGameEvent(GameEvent.TELEPORT, formerLocation, GameEvent.Emitter.of(user));
                        SoundCategory soundCategory;
                        SoundEvent soundEvent;
                        soundEvent = SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                        soundCategory = SoundCategory.PLAYERS;

                        world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, soundCategory);
                        user.onLanding();
                        break;
                    }
                }

                if (user instanceof PlayerEntity playerEntity) {
                    playerEntity.clearCurrentExplosion();
                    playerEntity.getItemCooldownManager().set(this, 20);
                }
            }
            user.tryEatFood(world, stack);
        }
        return (stack);
    }
}
