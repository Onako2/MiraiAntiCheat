package rs.onako2.mac.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import rs.onako2.mac.Main;

public class MacCommand implements CommandExecutor {


    private final Plugin plugin;

    public MacCommand(Main main) {
        this.plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§aMirai Anti Cheat §7v1.0");
        return true;
    }
}
