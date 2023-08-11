package com.agyo.pirateitems.commands.live;

import com.agyo.pirateitems.commands.live.ui.EUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ECommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            new EUI((Player) sender);
        }

        return false;
    }
}
