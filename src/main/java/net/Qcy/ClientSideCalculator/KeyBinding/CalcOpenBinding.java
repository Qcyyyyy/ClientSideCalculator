package net.Qcy.ClientSideCalculator.KeyBinding;

import net.Qcy.ClientSideCalculator.ClientSideCalculator;
import net.Qcy.ClientSideCalculator.GUI.CalcGUI;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

// Forge bus
@EventBusSubscriber(modid = ClientSideCalculator.MODID, value = Dist.CLIENT)
public class CalcOpenBinding {

    // Handle client tick events
    @SubscribeEvent
    public void onClientTick(ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            while (ClientSideCalculator.CALCKEYMAPPING.get().consumeClick()) {
                Minecraft.getInstance().setScreen(new CalcGUI());
            }
        }
    }
}
