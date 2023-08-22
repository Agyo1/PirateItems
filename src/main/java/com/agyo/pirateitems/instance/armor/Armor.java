package com.agyo.pirateitems.instance.armor;

import com.agyo.pirateitems.instance.PirateItem;
import com.agyo.pirateitems.instance.armor.type.Boots;
import com.agyo.pirateitems.instance.armor.type.ChestPlate;
import com.agyo.pirateitems.instance.armor.type.Leggings;
import com.agyo.pirateitems.instance.armor.type.PlayerHelmet;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class Armor extends PirateItem {

    public ArmorType armorType;
    public Armor(Player player, ArmorType armorType) {
        super(player);
        this.armorType = armorType;
    }

    @Override
    public void enable() {
        // helmet

//        ItemStack helmet = new ItemStack(armorType.getHelmet().valueOf(armorType.getHelmet().toString()).getMaterial());
//
//        if (helmet.getType().equals(Material.PLAYER_HEAD)) {
//            SkullMeta helmetSkullMeta = (SkullMeta) helmet.getItemMeta();
//
//            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
//            profile.getProperties().put("textures", new Property("textures", armorType.getHelmet().getTexture()));
//            Field field;
//            try {
//                field = helmetSkullMeta.getClass().getDeclaredField("profile");
//                field.setAccessible(true);
//                field.set(helmetSkullMeta, profile);
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                e.printStackTrace();
//                return;
//            }
//
//            helmetSkullMeta.setDisplayName(armorType.getRarity().getColor() + armorType.getHelmet().getName());
//            helmetSkullMeta.setLocalizedName(armorType.getName());
//            helmetSkullMeta.setLore(Arrays.asList(ChatColor.GRAY + "Defense: " + ChatColor.RED + armorType.getDefense(), " ", armorType.getRarity().getDisplay() + " HELMET"));
//            helmet.setItemMeta(helmetSkullMeta);
//        } else {
//            ItemMeta helmetMeta = helmet.getItemMeta();
//            helmetMeta.setDisplayName(armorType.getRarity().getColor() + armorType.getHelmet().getName());
//            helmetMeta.setLore(Arrays.asList(ChatColor.GRAY + "Defense: " + ChatColor.RED + armorType.getDefense(), " ", armorType.getRarity().getDisplay() + " HELMET"));
//            helmetMeta.setLocalizedName(armorType.getName());
//            helmet.setItemMeta(helmetMeta);
//        }

        PlayerHelmet helmetType = PlayerHelmet.JONES_HELMET;
        ItemStack helmet = new ItemStack(helmetType.getMaterial());
        SkullMeta helmetMeta = (SkullMeta) helmet.getItemMeta();

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", helmetType.getTexture()));
        Field field;
        try {
            field = helmetMeta.getClass().getDeclaredField("profile");
            field.setAccessible(true);
            field.set(helmetMeta, profile);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }
        helmetMeta.setDisplayName(helmetType.getName());
        helmetMeta.setLore(Arrays.asList(ChatColor.GRAY + "Defense: " + ChatColor.RED + String.valueOf(ArmorType.JONES_ARMOR.getDefense()), "", ArmorType.JONES_ARMOR.getRarity().getDisplay() + " HELMET"));
        helmetMeta.setUnbreakable(true);
        helmet.setItemMeta(helmetMeta);

        player.getInventory().addItem(helmet);

        ChestPlate chestPlateType = ChestPlate.JONES_CHESTPLATE;
        ItemStack chestPlate = new ItemStack(chestPlateType.getMaterial());

        LeatherArmorMeta chestPlateMeta = (LeatherArmorMeta) chestPlate.getItemMeta();
        chestPlateMeta.setDisplayName(chestPlateType.getName());
        chestPlateMeta.setColor(chestPlateType.getColor());
        chestPlateMeta.setLore(Arrays.asList(ChatColor.GRAY + "Defense: " + ChatColor.RED + String.valueOf(ArmorType.JONES_ARMOR.getDefense()), "", ArmorType.JONES_ARMOR.getRarity().getDisplay() + " CHESTPLATE"));
        chestPlateMeta.setUnbreakable(true);
        chestPlate.setItemMeta(chestPlateMeta);
        player.getInventory().addItem(chestPlate);

        Leggings leggingsType = Leggings.JONES_LEGGINGS;
        ItemStack leggings = new ItemStack(leggingsType.getMaterial());
        LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        leggingsMeta.setDisplayName(leggingsType.getName());
        leggingsMeta.setColor(leggingsType.getColor());
        leggingsMeta.setLore(Arrays.asList(ChatColor.GRAY + "Defense: " + ChatColor.RED + String.valueOf(ArmorType.JONES_ARMOR.getDefense()), "", ArmorType.JONES_ARMOR.getRarity().getDisplay() + " LEGGINGS"));
        leggingsMeta.setUnbreakable(true);
        leggings.setItemMeta(leggingsMeta);
        player.getInventory().addItem(leggings);

        Boots bootsType = Boots.JONES_BOOTS;
        ItemStack boots = new ItemStack(bootsType.getMaterial());
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setDisplayName(bootsType.getName());
        bootsMeta.setColor(bootsType.getColor());
        bootsMeta.setLore(Arrays.asList(ChatColor.GRAY + "Defense: " + ChatColor.RED + String.valueOf(ArmorType.JONES_ARMOR.getDefense()), "", ArmorType.JONES_ARMOR.getRarity().getDisplay() + " BOOTS"));
        bootsMeta.setUnbreakable(true);
        boots.setItemMeta(bootsMeta);
        player.getInventory().addItem(boots);

        try {
            player.sendMessage(armorType.getChestPlate().toString());
            player.sendMessage(armorType.getLeggings().toString());
            player.sendMessage(armorType.getBoots().toString());
            player.sendMessage(armorType.getPlayerHelmet().toString());
        } catch (NullPointerException e) {
            player.sendMessage(ChatColor.RED + e.getMessage());
        }
    }

    @Override
    public void disable() {
        player.sendMessage(ChatColor.RED + "Armor removed");
    }

}