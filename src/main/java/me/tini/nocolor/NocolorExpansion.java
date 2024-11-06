package me.tini.nocolor;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class NocolorExpansion extends PlaceholderExpansion {

    private NocolorPlugin plugin;

    public NocolorExpansion(NocolorPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getAuthor() {
        return "Tini";
    }

    @Override
    public String getIdentifier() {
        return "nocolor";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        return onRequest(p, params);
    }

    @Override
    public String onRequest(OfflinePlayer p, String placeholder) {
        placeholder = "%" + placeholder + "%";

        String res;
        if (p instanceof Player) {
            res = PlaceholderAPI.setPlaceholders((Player) p, placeholder);
        } else {
            res = PlaceholderAPI.setPlaceholders(p, placeholder);
        }
        if (res != null) {
            res = ChatColor.translateAlternateColorCodes('&', res);
            res = ChatColor.stripColor(res);
        }
        return res;
    }
}
