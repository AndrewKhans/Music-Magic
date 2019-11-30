package andrewmogo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import static com.sun.tools.doclint.Entity.amp;
import static com.sun.tools.doclint.Entity.quot;

public class KeyInputHandler
{
    // check to make sure we have ingame FOCUS!!! No strumming while typing in chat
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        // ISSUE: We need to pass in entityPlayerMP
        EntityPlayer player = Minecraft.getMinecraft().player;

        if (KeyBinds.keyBindings[0].isPressed())    // If note 1 is pressed
        {
            SoundHandler.playMandolinStrum(player, 0.5F, 2.0F);
            System.out.println("String 1");
        }
        if (KeyBinds.keyBindings[1].isPressed())    // If note 2 is pressed
        {
            SoundHandler.playMandolinStrum(player,0.5F, 1.0F);
            System.out.println("String 2");
        }
        if (KeyBinds.keyBindings[2].isPressed())    // If note 3 is pressed
        {
            SoundHandler.playMandolinStrum(player,0.5F, 0.5F);
            System.out.println("String 3");
        }
    }
}