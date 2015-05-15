package io.github.thelonedevil.bosstest.entity;

import io.github.thelonedevil.bosstest.util.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

public class FirstBoss extends BossBase {

    public FirstBoss(World world) {
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
    protected void dropFewItems(boolean p_70628_1_, int looting) {
        super.dropFewItems(p_70628_1_, looting);
        this.dropItem(Items.diamond, 64 * looting);
        ItemStack stack = new ItemStack(Items.diamond_sword);
        EnchantmentHelper.addEnchantment(stack, Enchantment.baneOfArthropods, (short) 32767);
        this.entityDropItem(stack, 0F);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float amount) {
        return damageSource.getEntity() instanceof EntityPlayer && !(damageSource.getEntity() instanceof FakePlayer) && super.attackEntityFrom(damageSource, amount);
    }


}
