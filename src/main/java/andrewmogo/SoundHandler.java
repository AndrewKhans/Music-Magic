package andrewmogo;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SoundHandler {

    private static ResourceLocation location = new ResourceLocation("musicmagic", "guitarSound");
    private static SoundEvent event = new SoundEvent(location);

    // Player must be type EntityPlayerMP
    public static void playMandolinStrum(EntityPlayer player, float volume, float pitch) {

        System.out.println("Player's world: " + player.getEntityWorld());

        WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(player.dimension);

        System.out.println("Worldserver?:" + worldServer);

        worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, event, SoundCategory.PLAYERS, volume, pitch);

//        player.getEntityWorld().playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, event, SoundCategory.PLAYERS, volume, pitch);

    }

}
