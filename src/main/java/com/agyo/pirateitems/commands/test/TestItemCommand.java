package com.agyo.pirateitems.commands.test;

import com.agyo.pirateitems.instance.ability.AbilityType;
import com.agyo.pirateitems.instance.swords.SwordType;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TestItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            for (SwordType type : SwordType.values()) {
                ItemStack item = new ItemStack(type.getMaterial());
                ItemMeta meta = item.getItemMeta();

                meta.setDisplayName(type.getName());
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + type.getDamage());

                if (type.getAbilityType() != AbilityType.NONE) {
                    lore.add(type.getAbilityType().getDisplay() + type.getAbilityType().getInteractionType().getDisplay());
                    lore.add(type.getAbilityType().getDescription());
                    lore.add(ChatColor.DARK_GRAY + "Mana cost: " + ChatColor.DARK_AQUA  + String.valueOf(type.getAbilityType().getMana()));
                }
                lore.add("");
                lore.add(type.getRarity().getDisplay() + " " + type.getType());

                meta.setUnbreakable(true);
                meta.setLocalizedName(type.getName());
                meta.setLore(lore);
                item.setItemMeta(meta);
                Player player = (Player) sender;
                player.playNote(player.getLocation(), Instrument.CHIME, Note.natural(1, Note.Tone.A));
                player.getInventory().addItem(item);


            }

        }

        return false;
    }
}
