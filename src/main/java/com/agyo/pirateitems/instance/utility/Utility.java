package com.agyo.pirateitems.instance.utility;

import com.agyo.pirateitems.instance.PirateItem;
import com.agyo.pirateitems.instance.ability.AbilityType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utility extends PirateItem {
    private UtilityType utilityType;
    public Utility(Player player, UtilityType utilityType) {
        super(player);
        this.utilityType = utilityType;
    }

    @Override
    public void enable() {


        ItemStack is = new ItemStack(utilityType.getMaterial());
        ItemMeta itemMeta = is.getItemMeta();

        itemMeta.setDisplayName(utilityType.getRarity().getColor() + utilityType.getName());
        itemMeta.setLocalizedName(utilityType.getName());
        itemMeta.setUnbreakable(true);
        List<String> lore = new ArrayList<>();

        if (utilityType.getAbilityType() != AbilityType.NONE) {
            lore.add(" ");
            lore.add(utilityType.getAbilityType().getDisplay() + utilityType.getAbilityType().getInteractionType().getDisplay());
            lore.add(utilityType.getAbilityType().getDescription());
            lore.add(ChatColor.DARK_GRAY + "Mana cost: " + ChatColor.DARK_AQUA + utilityType.getAbilityType().getMana());
        }

        lore.add("");
        lore.add(utilityType.getRarity().getDisplay());

        itemMeta.setLore(lore);
        is.setItemMeta(itemMeta);
        player.getInventory().addItem(is);

    }

    @Override
    public void disable() {
        for (ItemStack item : player.getInventory().getContents()) {
            if (item.getItemMeta().getLocalizedName().equals(utilityType.getName())) {
                player.getInventory().removeItem(item);
            }
        }
    }
}
