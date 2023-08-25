package com.agyo.pirateitems.commands.live.ui;

import com.agyo.pirateitems.instance.armor.Armor;
import com.agyo.pirateitems.instance.armor.ArmorType;
import com.agyo.pirateitems.instance.utility.UtilityType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static java.lang.Integer.parseInt;

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
                    new ArmorUI((Player) e.getWhoClicked());
                } else if (e.getRawSlot() == 12) {
                    new UtilityUI((Player) e.getWhoClicked());
                } else if (e.getRawSlot() == 49) {
                    player.closeInventory();
                }
            } else if (e.getView().getTitle().endsWith("Admin Menu | Swords")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
                    e.getWhoClicked().closeInventory();
                } else if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                    new EUI(player);
                } else if (!(e.getCurrentItem().getType().equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE))){
                    e.getWhoClicked().getInventory().addItem(e.getCurrentItem());
                }
            } else if (e.getView().getTitle().endsWith("Admin Menu | Armor")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
                    e.getWhoClicked().closeInventory();
                } else if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                    new EUI(player);
                } else if (!(e.getCurrentItem().getType().equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE))){
                    for (ArmorType armorType : ArmorType.values()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(armorType.getName())) {
                            Armor armor = new Armor(player, armorType);
                            armor.enable();
                        }
                    }
                }
            } else if (e.getView().getTitle().endsWith("Admin Menu | Utility")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType().equals(Material.BARRIER)) {
                    e.getWhoClicked().closeInventory();
                } else if(e.getCurrentItem().getType().equals(Material.ARROW)) {
                    new EUI(player);
                } else if (!(e.getCurrentItem().getType().equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE))){
                    e.getWhoClicked().getInventory().addItem(e.getCurrentItem());
                }
            }
        }
    }
}
