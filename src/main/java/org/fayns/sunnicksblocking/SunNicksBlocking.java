package org.fayns.sunnicksblocking;

import org.bukkit.plugin.java.JavaPlugin;
import org.fayns.sunnicksblocking.Listener.JoinListener;

public final class SunNicksBlocking extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getLogger().info("SunNicksBlocking enable!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SunNicksBlocking disable!");
    }
}
