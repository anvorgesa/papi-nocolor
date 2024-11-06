package me.tini.nocolor;

import org.bukkit.plugin.java.JavaPlugin;

import me.clip.placeholderapi.PlaceholderAPI;

public class NocolorPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        PlaceholderAPI.registerExpansion(new NocolorExpansion(this));
    }
}
