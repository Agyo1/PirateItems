package com.agyo.pirateitems.commands.live.ui;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EUIListener implements Listener {
    @EventHandler
    public void InventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getCurrentItem() != null) {
            if (e.getView().getTitle().endsWith("Admin Menu")) {
                e.setCancelled(true);
                if (e.getRawSlot() == 10) {
                    new SwordUI((Player) e.getWhoClicked());
                } else if (e.getRawSlot() == 11) {
                    //armor
                } else if (e.getRawSlot() == 12) {
                    //utility
                } else if (e.getRawSlot() == 49) {
                    player.closeInventory();
                }
            } else if (e.getView().getTitle().endsWith("Admin Menu | Swords")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
                    e.getWhoClicked().closeInventory();
                } else if (!(e.getCurrentItem().getType().equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE))){
                    e.getWhoClicked().getInventory().addItem(e.getCurrentItem());
                }
            }
        }
    }
}
