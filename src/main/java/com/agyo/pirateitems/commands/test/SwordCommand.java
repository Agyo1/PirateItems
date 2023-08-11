package com.agyo.pirateitems.commands.test;

import com.agyo.pirateitems.instance.swords.Sword;
import com.agyo.pirateitems.instance.swords.SwordType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SwordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            for (SwordType type : SwordType.values()) {
                Sword sword = new Sword(player, type);
                sword.enable();
            }
        }
        return false;
    }
}
