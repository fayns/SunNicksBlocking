package org.fayns.sunnicksblocking.Listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.fayns.sunnicksblocking.SunNicksBlocking;

import java.util.List;

public class JoinListener implements Listener {
    private final SunNicksBlocking plugin;

    public JoinListener(SunNicksBlocking plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent event) {
        if (!plugin.getConfig().getBoolean("filter.enabled")) return;

        String playerName = event.getName().toLowerCase();
        List<String> badWords = plugin.getConfig().getStringList("filter.bad_words");

        for (String word : badWords) {
            if (playerName.contains(word.toLowerCase())) {
                String kickMsg = ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("messages.kick_reason"));

                event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, kickMsg);
                return;
            }
        }
    }
}
