package EventChecker;

import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SignHider implements Listener {
    private HashMap<Location, String> Line1 = new HashMap<Location, String>();
    private HashMap<Location, String> Line2 = new HashMap<Location, String>();
    private HashMap<Location, String> Line3 = new HashMap<Location, String>();
    private HashMap<Location, String> Line4 = new HashMap<Location, String>();
    List<Material> Signs = Arrays.asList(Material.OAK_SIGN, Material.ACACIA_SIGN, Material.BIRCH_SIGN, Material.SPRUCE_SIGN, Material.CRIMSON_SIGN,
            Material.ACACIA_WALL_SIGN, Material.WARPED_WALL_SIGN, Material.WARPED_SIGN, Material.SPRUCE_WALL_SIGN, Material.JUNGLE_WALL_SIGN, Material.JUNGLE_SIGN,
            Material.DARK_OAK_WALL_SIGN, Material.DARK_OAK_SIGN, Material.BIRCH_WALL_SIGN);
    @EventHandler
    public void Sign(PlayerEvent e) {
        if (!e.getPlayer().hasPermission("sign.view")){
            if (Signs.contains(e.getPlayer().getTargetBlockExact(100,FluidCollisionMode.NEVER).getType())){
            }
        }
    }
}