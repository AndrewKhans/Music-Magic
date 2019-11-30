package andrewmogo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SoundHandler {

//    private static ResourceLocation location = new ResourceLocation("musicmagic", "mandolinStrum");
//    private static SoundEvent mandolinStrum = new SoundEvent(location);
////    location = new ResourceLocation("musicmagic", "guitarSound");
//    private static SoundEvent mandolinPluck = new SoundEvent(location);

    private static SoundEvent mandolinStrum = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinStrum")
    );
    private static SoundEvent mandolinPluck = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinPluck")
    );

    public static void playMandolinStrum(EntityPlayer player, float volume, float pitch) {
        WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(player.dimension);
        worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, mandolinStrum, SoundCategory.PLAYERS, volume, pitch);
    }
    public static void playMandolinPluck(EntityPlayer player, float volume, float pitch) {
        WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(player.dimension);
        worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, mandolinPluck, SoundCategory.PLAYERS, volume, pitch);
    }
}
