package com.agyo.pirateitems.instance.listener;

import com.agyo.pirateitems.instance.swords.SwordType;
import com.agyo.pirateitems.instance.utility.UtilityType;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class TeleportAbility implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand() != null || player.getInventory().getItemInOffHand() != null) {
            if (player.getInventory().getItemInMainHand().hasItemMeta()) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    try {
                        if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals(SwordType.BLACKBEARDS_CUTLASS.getName())) {
                            Vector direction = player.getLocation().getDirection().normalize();
                            Location teleportLocation = player.getLocation().clone().add(direction.multiply(8.0f));
                            player.teleport(teleportLocation);
                            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 0.5f, 1);
                        }
                    } catch (NullPointerException ignored) {

                    }
                }
            }
        }
    }
}

