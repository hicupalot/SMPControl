package EventChecker;

import com.hicupalot.smpcontrol.Config;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ElytraDisable implements Listener, CommandExecutor {
    public void Elytra (BlockBreakEvent e) {
        if (Config.plugin.getConfig().getBoolean("Elytra")) {
            if (e.getPlayer().getInventory().getChestplate().equals(new ItemStack(Material.ELYTRA))) {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 255));
                e.getPlayer().getInventory().getChestplate().setType(Material.AIR);
                e.getPlayer().sendMessage(ChatColor.RED + "Elytras are currently disabled! You were let down safely");
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
                            sender.sendMessage(ChatColor.RED+"Please do /elytra on OR /elytra off");
                            return false;
                        }
                        if (args[1].equals("on")){
                            if (Config.plugin.getConfig().getBoolean("Elytra",true)) {
                                sender.sendMessage(ChatColor.RED+"Elytra are already enabled!");
                                return false;
                            }
                            if (args[1].equals("on")){
                                Config.plugin.getConfig().set("Elytra",true);
                                sender.sendMessage(ChatColor.GOLD+"Elytra have been enabled!");
                                Config.plugin.saveDefaultConfig();
                                Config.plugin.reloadConfig();
                                return false;
                            }
                            if (args[1].equals("off")){
                                if (Config.plugin.getConfig().getBoolean("Elytra",false)){
                                    sender.sendMessage(ChatColor.RED+"Elytra are already disabled");
                                    return false;
                                }
                                if (args[1].equals("off")){
                                    Config.plugin.getConfig().set("Elytra",false);
                                    sender.sendMessage(ChatColor.GOLD+"Elytra are disabled now");
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

