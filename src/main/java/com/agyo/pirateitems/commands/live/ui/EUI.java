package com.agyo.pirateitems.commands.live.ui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class EUI {

    public EUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Admin Menu");

        ItemStack swords = new ItemStack(Material.IRON_SWORD);
        ItemMeta swordsMeta = swords.getItemMeta();
        swordsMeta.setDisplayName(ChatColor.GOLD + "Swords");
        swords.setItemMeta(swordsMeta);

        ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta armorMeta = (LeatherArmorMeta) armor.getItemMeta();
        armorMeta.setDisplayName(ChatColor.GOLD + "Armor");
        armorMeta.setColor(Color.fromRGB(192, 63, 69));
        armor.setItemMeta(armorMeta);

        ItemStack utility = new ItemStack(Material.STICK);
        ItemMeta utilityMeta = utility.getItemMeta();
        utilityMeta.setDisplayName(ChatColor.GOLD + "Utility Items");
        utilityMeta.addEnchant(Enchantment.LUCK, 1, true);
        utilityMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        utility.setItemMeta(utilityMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        ItemStack frame = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
        ItemMeta frameMeta = frame.getItemMeta();
        frameMeta.setDisplayName(" ");
        frame.setItemMeta(frameMeta);

        for (int i : new int[]{45, 46, 47, 48, 50, 51, 52, 53}) {
            inv.setItem(i, frame);
        }

        inv.setItem(10, swords);
        inv.setItem(11, armor);
        inv.setItem(12, utility);
        inv.setItem(49, close);
        player.openInventory(inv);
    }

}
