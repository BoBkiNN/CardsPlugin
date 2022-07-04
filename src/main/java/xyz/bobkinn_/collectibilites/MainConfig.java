package xyz.bobkinn_.collectibilites;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;

public class MainConfig {
    Plugin plugin;
    MainConfig(Plugin plugin){
        this.plugin = plugin;
    }
    public Configuration getConfig(){
        return plugin.getConfig();
    }
}
