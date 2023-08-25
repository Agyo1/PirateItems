package com.agyo.pirateitems.instance.listener;

import com.agyo.pirateitems.PirateItems;
import com.agyo.pirateitems.instance.swords.Sword;
import com.agyo.pirateitems.instance.swords.SwordType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

public class RaiseTheCrewAbility implements Listener {

    private PirateItems pirateItems;
    public RaiseTheCrewAbility(PirateItems pirateItems) {
        this.pirateItems = pirateItems;
    }

    private UUID uuid;

    private BukkitTask task;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand() != null || player.getInventory().getItemInOffHand() != null) {
            if (player.getInventory().getItemInMainHand().hasItemMeta()) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    try {
                        if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals(SwordType.JONES_BLADE.getName()) || player.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().equals(SwordType.JONES_BLADE.getName())) {
                            Entity zombie = player.getWorld().spawnEntity(player.getLocation().multiply(1), EntityType.ZOMBIE);
                            zombie.setCustomNameVisible(true);
                            zombie.setCustomName(ChatColor.GREEN + String.valueOf(zombie.getTicksLived()));
                            uuid = zombie.getUniqueId();
                            player.sendMessage(ChatColor.GREEN + "Used " + SwordType.JONES_BLADE.getAbilityType().getDisplay() + ChatColor.GREEN + " for " + SwordType.JONES_BLADE.getAbilityType().getMana() + ChatColor.GREEN + " mana.");
                            task = Bukkit.getScheduler().runTaskTimer(pirateItems, new Runnable() {
                                @Override
                                public void run() {
                                    if (zombie.getTicksLived() >= 200) {
                                        zombie.getLocation().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, zombie.getLocation(), 10);
                                        zombie.remove();
                                        task.cancel();
                                        for (Player player : Bukkit.getWorld("pirate_world").getPlayers()) {
                                            player.sendMessage(ChatColor.RED + "Task canceled");
                                        }
                                    }
                                    zombie.setCustomName(ChatColor.GREEN + String.valueOf(zombie.getTicksLived()));
                                }
                            }, 0, 5);
                        }
                    } catch (NullPointerException ignored) {

                    }
                }
            }
        }
    }
    @EventHandler
    public void entityDeath(EntityDeathEvent e) {
        if (e.getEntity().getUniqueId().equals(uuid)) {
            task.cancel();
            for (Player player : Bukkit.getWorld("pirate_world").getPlayers()) {
                player.sendMessage(ChatColor.RED + "Task canceled");
            }
        }
    }
}
