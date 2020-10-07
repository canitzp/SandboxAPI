package org.sandboxpowered.api.entity.module;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.util.DamageSource;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Entity Module that covers drowning
 */
public class DrowningEntityModule extends BaseEntityModule {
    private int drownTime;
    private Consumer<Entity> drownAction;
    private Predicate<Entity> drownCondition;

    protected DrowningEntityModule(Type<?> type) {
        super(type);
    }

    @Override
    public void tick(Entity entity) {
        if (entity.isAlive() && drownCondition.test(entity)) {
            int air = entity.getAir();
            entity.setAir(air - 1);
            if (air >= -20) {
                entity.setAir(0);
                drownAction.accept(entity);
            }
        } else entity.setAir(drownTime);
    }

    public DrowningEntityModule setDrownTime(int drownTime) {
        this.drownTime = drownTime;
        return this;
    }

    public DrowningEntityModule setDrownAction(Consumer<Entity> drownAction) {
        this.drownAction = drownAction;
        return this;
    }

    public DrowningEntityModule setDrownConditions(Predicate<Entity> drownConditions) {
        this.drownCondition = drownConditions;
        return this;
    }
}
