package andrewmogo.Sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class SoundRegistrator {
    public static final SoundEvent guitarSound;

    static {
        guitarSound = addSoundsToRegistry("guitar"); // soundId is the name it's given in the sounds.json
    }

    private static SoundEvent addSoundsToRegistry(String soundId) {
        ResourceLocation musicMagicSoundsLocation = new ResourceLocation("musicmagic", soundId);
        SoundEvent soundEvent = new SoundEvent(musicMagicSoundsLocation);
        soundEvent.setRegistryName(musicMagicSoundsLocation);
        return soundEvent;
    }
}