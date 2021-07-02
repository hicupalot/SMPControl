package EventChecker;

import com.hicupalot.smpcontrol.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.PortalCreateEvent;

public class NetherControl implements CommandExecutor, Listener {
    @EventHandler
    public void NetherPortal(PortalCreateEvent e) {
        if (Config.plugin.getConfig().getBoolean("Nether", false)) {
            e.setCancelled(true);

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
                    sender.sendMessage(ChatColor.RED+"Please do /nether on OR /nether off");
                    return false;
                }
                if (args[1].equals("on")){
                    if (Config.plugin.getConfig().getBoolean("Nether",true)) {
                        sender.sendMessage(ChatColor.RED+"The Nether is already enabled!");
                        return false;
                    }
                    if (args[1].equals("on")){
                        Config.plugin.getConfig().set("Nether",true);
                        sender.sendMessage(ChatColor.GOLD+"The Nether has been enabled!");
                        Config.plugin.saveDefaultConfig();
                        Config.plugin.reloadConfig();
                        return false;
                    }
                    if (args[1].equals("off")){
                        if (Config.plugin.getConfig().getBoolean("Nether",false)){
                            sender.sendMessage(ChatColor.RED+"The Nether is Already Disabled");
                            return false;
                        }
                        if (args[1].equals("off")){
                            Config.plugin.getConfig().set("Nether",false);
                            sender.sendMessage(ChatColor.GOLD+"The Nether is Disabled Now");
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

