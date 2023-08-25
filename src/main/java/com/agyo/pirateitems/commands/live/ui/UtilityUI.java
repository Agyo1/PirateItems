package com.agyo.pirateitems.commands.live.ui;

import com.agyo.pirateitems.instance.ability.AbilityType;
import com.agyo.pirateitems.instance.utility.UtilityType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class UtilityUI {

    public UtilityUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Admin Menu | Utility");

        for (UtilityType type : UtilityType.values()) {
            ItemStack is = new ItemStack(type.getMaterial());
            ItemMeta itemMeta = is.getItemMeta();

            itemMeta.setDisplayName(type.getRarity().getColor() + type.getName());
            itemMeta.setLocalizedName(type.getName());
            itemMeta.setUnbreakable(true);
            if (type.isEnchanted()) {
                itemMeta.addEnchant(Enchantment.LUCK, 1, true);
                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }
            List<String> lore = new ArrayList<>();

            if (type.getAbilityType() != AbilityType.NONE) {
                lore.add(" ");
                lore.add(type.getAbilityType().getDisplay() + type.getAbilityType().getInteractionType().getDisplay());
                lore.add(type.getAbilityType().getDescription());
                lore.add(ChatColor.DARK_GRAY + "Mana cost: " + ChatColor.DARK_AQUA  + type.getAbilityType().getMana());
            }

            lore.add("");
            lore.add(type.getRarity().getDisplay() + " " + "ITEM");

            itemMeta.setLore(lore);
            is.setItemMeta(itemMeta);
            inv.addItem(is);
        }


        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        ItemStack frame = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        ItemMeta frameMeta = frame.getItemMeta();
        frameMeta.setDisplayName(" ");
        frame.setItemMeta(frameMeta);


        ItemStack back = new ItemStack(Material.ARROW);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(ChatColor.GREEN + "Go Back");
        back.setItemMeta(backMeta);

        for (int i : new int[]{46, 47, 48, 50, 51, 52, 53}) {
            inv.setItem(i, frame);
        }

        inv.setItem(45, back);
        inv.setItem(49, close);

        player.openInventory(inv);
    }
}
