package com.agyo.pirateitems.commands.live.ui;

import com.agyo.pirateitems.instance.armor.type.PlayerHelmet;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class ArmorUI {

    public ArmorUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Admin Menu | Armor");


        for (PlayerHelmet type : PlayerHelmet.values()) {
            ItemStack is = new ItemStack(type.getMaterial());
            if (is.getType().equals(Material.PLAYER_HEAD)) {
                SkullMeta skullMeta = (SkullMeta) is.getItemMeta();
                GameProfile profile = new GameProfile(UUID.randomUUID(), null);
                profile.getProperties().put("textures", new Property("textures", type.getTexture()));
                Field field;
                try {
                    field = skullMeta.getClass().getDeclaredField("profile");
                    field.setAccessible(true);
                    field.set(skullMeta, profile);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                    return;
                }
                skullMeta.setDisplayName(type.getArmorType().getName());
                skullMeta.setLore(Arrays.asList(ChatColor.GOLD + "Click for set"));
                is.setItemMeta(skullMeta);
            } else {
                ItemMeta meta = is.getItemMeta();
                meta.setDisplayName(type.getArmorType().getName());
                meta.setLore(Arrays.asList(ChatColor.GOLD + "Click for set"));
                is.setItemMeta(meta);
            }
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
