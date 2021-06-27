package com.hicupalot.smpcontrol;

import org.bukkit.plugin.java.JavaPlugin;

public final class SMPControl extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("reload").setExecutor(new ReloadCommand());
        getCommand("end").setExecutor(new EndControl());
        getCommand("elytra").setExecutor(new ElytraDisable());
        getServer().getPluginManager().registerEvents(new ElytraDisable(), this);
        getServer().getPluginManager().registerEvents(new EndControl(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
        // Plugin shutdown logic
    }
}
