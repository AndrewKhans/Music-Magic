package andrewmogo;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyBinds {

    public static KeyBinding[] keyBindings;

    public static void register() {
        // declare an array of key bindings
        keyBindings = new KeyBinding[3];

        // instantiate the key bindings
        keyBindings[0] = new KeyBinding("key.note1.desc", Keyboard.KEY_Z, "key.musicmagic.category");
        keyBindings[1] = new KeyBinding("key.note2.desc", Keyboard.KEY_X, "key.musicmagic.category");
        keyBindings[2] = new KeyBinding("key.note3.desc", Keyboard.KEY_C, "key.musicmagic.category");

        // register all the key bindings
        for (int i = 0; i < keyBindings.length; ++i)
        {
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }
    }

}
