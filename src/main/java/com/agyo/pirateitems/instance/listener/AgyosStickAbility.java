package com.agyo.pirateitems.instance.listener;

import com.agyo.pirateitems.instance.ability.AbilityType;
import com.agyo.pirateitems.instance.swords.SwordType;
import com.agyo.pirateitems.instance.utility.UtilityType;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class AgyosStickAbility implements Listener {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS).build();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand() != null || player.getInventory().getItemInOffHand() != null) {
            if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                try {
                    if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals(UtilityType.AGYOS_MAGICAL_STICK.getName()) || player.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().equals(UtilityType.AGYOS_MAGICAL_STICK.getName())) {
                        if (!cooldown.asMap().containsKey(player.getUniqueId())) {
                            Snowball snowball = player.launchProjectile(Snowball.class, player.getLocation().getDirection().multiply(1.25f));
                            snowball.setItem(new ItemStack(Material.GOLD_BLOCK));
                            snowball.addPassenger(e.getPlayer());
                            player.playNote(player.getLocation(), Instrument.XYLOPHONE, Note.natural(1, Note.Tone.C));
                            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 2000);
                        } else {
                            long distance = cooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
                            player.sendMessage(ChatColor.RED + "That ability is on cooldown for " + TimeUnit.MILLISECONDS.toSeconds(distance) + " seconds!");
                        }
                    }
                } catch (NullPointerException ignored) {

                }
            }
        }
    }
}
