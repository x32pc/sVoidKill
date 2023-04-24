package com.x32pc.github;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import javax.annotation.Nullable;
import java.util.List;

public class Commands implements TabExecutor {



    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sVoidKill"))
            if (args.length == 0) {
                for (String message : Main.plugin.getConfig().getStringList("info_message"))
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("svoidkill.reload")) {
                    Main.plugin.reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "Config has been reloaded.");
                } else {
                    sender.sendMessage(ChatColor.RED + "Invalid permission.");
                    return true;
                }
            }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        return null;
    }
}
