package io.github.thelonedevil.bosstest.proxy;

import io.github.thelonedevil.bosstest.entity.FirstBoss;
import io.github.thelonedevil.bosstest.entity.SecondBoss;
import io.github.thelonedevil.bosstest.entity.render.RenderTest;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(FirstBoss.class, new RenderTest(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(SecondBoss.class, new RenderTest(Minecraft.getMinecraft().getRenderManager()));
    }
}
