package com.x32pc.github;

import org.bukkit.ChatColor;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.server.TabCompleteEvent;

public class Events implements Listener {
    public static Events EventsFile;


    @EventHandler
    public void OnDeath(PlayerDeathEvent z) {
        if (Main.plugin.getConfig().getBoolean("custom_message.enabled") &&
                z.getDeathMessage().contains(" died"))
            z.setDeathMessage(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("custom_message.player_death_message").replace("%player%", z.getEntity().getPlayer().getName())));
    }

    @EventHandler
    public void onVoidEnter(PlayerMoveEvent e) {
        if (Main.plugin.getConfig().getBoolean("void_death.enabled") &&
                e.getTo().getY() <= Main.plugin.getConfig().getInt("void_death.Y_level")) {
            e.getPlayer().setHealth(0.0D);
            e.getPlayer().spigot().respawn();
        }
    }


}
