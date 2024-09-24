package rs.onako2.mac;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.event.PacketListenerPriority;
import com.github.retrooper.packetevents.settings.PacketEventsSettings;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import rs.onako2.mac.command.MacCommand;
import rs.onako2.mac.listener.PacketListener;

public final class Main extends JavaPlugin {

    FileConfiguration config = getConfig();
    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        //On Bukkit, calling this here is essential, hence the name "load"
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        config.addDefault("prefix", "&8[&6MAC&8] ");
        this.getCommand("mac").setExecutor(new MacCommand(this));
        PacketEventsSettings settings = PacketEvents.getAPI().getSettings();

        PacketEvents.getAPI().getEventManager().registerListener(
                new PacketListener(), PacketListenerPriority.NORMAL);
        settings.debug(true);

        PacketEvents.getAPI().init();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        PacketEvents.getAPI().terminate();
    }
}
