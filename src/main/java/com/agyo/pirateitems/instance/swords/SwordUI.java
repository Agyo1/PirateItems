package com.agyo.pirateitems.instance.swords;

import com.agyo.pirateitems.PirateItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class SwordUI implements Listener {

    public SwordUI(PirateItems pirateItems, Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Swords Menu");

        for (SwordType type : SwordType.values()) {
            ItemStack is = new ItemStack(type.getMaterial());
            ItemMeta meta = is.getItemMeta();

            meta.setDisplayName(type.getName());
            List<String> lore = new ArrayList<>();
            lore.add(type.getRarity().getDisplay());
            meta.setLore(lore);

            is.setItemMeta(meta);
        }

        player.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory() != null && e.getCurrentItem() != null) {
            if (e.getView().getTitle().endsWith("Swords Menu")) {
                e.getWhoClicked().getInventory().addItem(e.getCurrentItem());
            }
        }
    }
}
