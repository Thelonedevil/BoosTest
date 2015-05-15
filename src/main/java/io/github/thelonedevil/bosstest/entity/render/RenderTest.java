package io.github.thelonedevil.bosstest.entity.render;

import io.github.thelonedevil.bosstest.BossTestMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTest extends RenderBiped {

    public RenderTest(RenderManager renderManager) {
        super(renderManager,new ModelBiped(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity par3Entity) {
        return new ResourceLocation(BossTestMod.MODID , "textures/models/boss1.png");

    }
}
