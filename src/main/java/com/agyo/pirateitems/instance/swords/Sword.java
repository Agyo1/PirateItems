package com.agyo.pirateitems.instance.swords;

import com.agyo.pirateitems.PirateItems;
import com.agyo.pirateitems.instance.PirateItem;
import com.agyo.pirateitems.instance.ability.AbilityType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sword extends PirateItem {

    private SwordType swordType;
    public Sword(Player player, SwordType swordType) {
        super(player);
        this.swordType = swordType;
    }

    @Override
    public void enable() {
        ItemStack is = new ItemStack(swordType.getMaterial());
        ItemMeta itemMeta = is.getItemMeta();

        itemMeta.setDisplayName(swordType.getRarity().getColor() + swordType.getName());
        itemMeta.setLocalizedName(swordType.getName());
        itemMeta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + swordType.getDamage());
        if (swordType.getAbilityType() != AbilityType.NONE) {
            lore.add(" ");
            lore.add(swordType.getAbilityType().getDisplay() + swordType.getAbilityType().getInteractionType().getDisplay());
            lore.add(swordType.getAbilityType().getDescription());
            lore.add(ChatColor.DARK_GRAY + "Mana cost: " + ChatColor.DARK_AQUA  + swordType.getAbilityType().getMana());
        }

        lore.add("");
        lore.add(swordType.getRarity().getDisplay());

        itemMeta.setLore(lore);
        is.setItemMeta(itemMeta);
        player.getInventory().addItem(is);
    }

    @Override
    public void disable() {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item.getItemMeta().getLocalizedName().equals(swordType.getName())) {
                player.getInventory().removeItem(item);
            }
        }
    }

}