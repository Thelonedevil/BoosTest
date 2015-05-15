package io.github.thelonedevil.bosstest.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

public class SecondBoss extends BossBase {

    public SecondBoss(World world) {
        super(world);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(400.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float amount) {
        if(damageSource.getDamageType().equals(DamageSource.magic.getDamageType())){
            return super.attackEntityFrom(damageSource, amount);
        }
        boolean indirectMagic = damageSource.getDamageType().equalsIgnoreCase(DamageSource.causeIndirectMagicDamage(damageSource.getEntity(),damageSource.getSourceOfDamage()).getDamageType());
        return damageSource.getEntity() instanceof EntityPlayer && !(damageSource.getEntity() instanceof FakePlayer) && indirectMagic && super.attackEntityFrom(damageSource, amount);
    }
}
