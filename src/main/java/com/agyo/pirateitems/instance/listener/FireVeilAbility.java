package com.agyo.pirateitems.instance.listener;

import com.agyo.pirateitems.instance.swords.SwordType;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireVeilAbility implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand() != null || player.getInventory().getItemInOffHand() != null) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                try {
                    if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals(SwordType.CAPTAIN_SWORD.getName()) || player.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().equals(SwordType.JONES_BLADE.getName())) {
                        player.sendMessage(ChatColor.GREEN + "Used " + SwordType.CAPTAIN_SWORD.getAbilityType().getDisplay() + ChatColor.GREEN + " for " + SwordType.CAPTAIN_SWORD.getAbilityType().getMana() + ChatColor.GREEN + " mana.");
                        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 100, 1, 1, 1);
                    }
                } catch (NullPointerException ignored) {

                }
            }
        }
    }
}
