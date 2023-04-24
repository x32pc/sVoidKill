package com.x32pc.github;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    FileConfiguration config = getConfig();

    int number;

    public static Main plugin;

    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new Events(), (Plugin)this);
        getCommand("svoidkill").setExecutor(new Commands());
        getConfig().set("void_death.Y_level", Integer.valueOf(this.number));
        saveDefaultConfig();
    }
}
