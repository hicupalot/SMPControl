package com.hicupalot.smpcontrol;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.PortalCreateEvent;

public class EndControl implements Listener, CommandExecutor {
    @EventHandler
    public void EndPortal(PlayerInteractEvent e) {
        if (!Config.plugin.getConfig().getBoolean("End",false)) {
            if (!e.getClickedBlock().getType().equals(Material.AIR)) {
                if (e.getClickedBlock().getType().equals((Material.END_PORTAL))) {
                    if (e.getMaterial().equals(Material.ENDER_EYE)) {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
            public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
                if (sender instanceof Player || sender instanceof ConsoleCommandSender) {
                    if (sender.hasPermission("SMPControl.EventControl")){
                        if (args.length<1) {
                            sender.sendMessage(ChatColor.RED + "Please turn this on or off");
                            return false;
                        }
                        if (args.length>2){
                            sender.sendMessage(ChatColor.RED+"Please do /end on OR /end off");
                            return false;
                        }
                        if (args[1].equals("on")){
                            if (Config.plugin.getConfig().getBoolean("End",true)) {
                                sender.sendMessage(ChatColor.RED+"The end is already enabled!");
                                return false;
                            }
                        if (args[1].equals("on")){
                            Config.plugin.getConfig().set("End",true);
                            sender.sendMessage(ChatColor.GOLD+"The End has been enabled!");
                            Config.plugin.saveDefaultConfig();
                            Config.plugin.reloadConfig();
                            return false;
                        }
                        if (args[1].equals("off")){
                        if (Config.plugin.getConfig().getBoolean("End",false)){
                                sender.sendMessage(ChatColor.RED+"The End is Already Disabled");
                                return false;
                            }
                        if (args[1].equals("off")){
                            Config.plugin.getConfig().set("End",false);
                            sender.sendMessage(ChatColor.GOLD+"The End is Disabled Now");
                            Config.plugin.saveDefaultConfig();
                            Config.plugin.reloadConfig();
                        }
                        }


                        }
                    }
        }
    return false;
    }
}