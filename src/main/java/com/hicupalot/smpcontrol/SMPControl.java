package com.hicupalot.smpcontrol;

import EventChecker.ElytraDisable;
import EventChecker.EndControl;
import EventChecker.NetherControl;
import commands.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class SMPControl extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        //----------------------------------------------------------------------------//
        // Commands
        getCommand("reload").setExecutor(new ReloadCommand());
        getCommand("end").setExecutor(new EndControl());
        getCommand("elytra").setExecutor(new ElytraDisable());
        getCommand("nether").setExecutor(new NetherControl());
        //----------------------------------------------------------------------------//
        //Events
        getServer().getPluginManager().registerEvents(new ElytraDisable(), this);
        getServer().getPluginManager().registerEvents(new EndControl(), this);
        getServer().getPluginManager().registerEvents(new NetherControl(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        this.saveDefaultConfig();
        // Plugin shutdown logic
    }
}
