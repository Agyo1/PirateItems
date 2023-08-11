package com.agyo.pirateitems;

import com.agyo.pirateitems.commands.live.ECommand;
import com.agyo.pirateitems.commands.live.ui.EUIListener;
import com.agyo.pirateitems.commands.test.SwordCommand;
import com.agyo.pirateitems.commands.test.TestItemCommand;
import com.agyo.pirateitems.instance.listener.FireVeilAbility;
import com.agyo.pirateitems.instance.listener.RaiseTheCrewAbility;
import com.agyo.pirateitems.instance.swords.SwordUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class PirateItems extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("testitem").setExecutor(new TestItemCommand());
        getCommand("sword").setExecutor(new SwordCommand());
        getCommand("e").setExecutor(new ECommand());

        Bukkit.getPluginManager().registerEvents(new RaiseTheCrewAbility(this), this);
        Bukkit.getPluginManager().registerEvents(new EUIListener(), this);
        Bukkit.getPluginManager().registerEvents(new FireVeilAbility(), this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[PirateItems] Pirate Items enabled!");
    }

}
