package andrewmogo;

import andrewmogo.item_mandolin.Mandolin;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeyInputHandler
{
    // check to make sure we have ingame FOCUS!!! No strumming while typing in chat
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {

        EntityPlayer player = Minecraft.getMinecraft().player;
        // Check if we have ingame focus (no mandolin use while in chat)
        Item heldItem = player.getHeldItemMainhand().getItem();
        if (heldItem instanceof Mandolin) {

            if (KeyBinds.keyBindings[3].isPressed())
                ((Mandolin) heldItem).strumMode = !((Mandolin) heldItem).strumMode;

            if (((Mandolin)heldItem).strumMode) {
                if (KeyBinds.keyBindings[0].isPressed())    // If note 1 is pressed
                {
                    SoundHandler.playMandolinStrum(player, 0.5F, 2.0F);
                    System.out.println("Strum 1");
                }
                if (KeyBinds.keyBindings[1].isPressed())    // If note 2 is pressed
                {
                    SoundHandler.playMandolinStrum(player, 0.5F, 1.0F);
                    System.out.println("Strum 2");
                }
                if (KeyBinds.keyBindings[2].isPressed())    // If note 3 is pressed
                {
                    SoundHandler.playMandolinStrum(player, 0.5F, 0.5F);
                    System.out.println("Strum 3");
                }
            } else {
                if (KeyBinds.keyBindings[0].isPressed())    // If note 1 is pressed
                {
                    SoundHandler.playMandolinPluck(player, 0.5F, 2.0F);
                    System.out.println("Pluck 1");
                }
                if (KeyBinds.keyBindings[1].isPressed())    // If note 2 is pressed
                {
                    SoundHandler.playMandolinPluck(player,0.5F, 1.0F);
                    System.out.println("Pluck 2");
                }
                if (KeyBinds.keyBindings[2].isPressed())    // If note 3 is pressed
                {
                    SoundHandler.playMandolinPluck(player,0.5F, 0.5F);
                    System.out.println("Pluck 3");
                }
            }
        }
    }
}