package com.agyo.pirateitems.instance.ability;

import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerInteractEvent;

public enum InteractionType {

    NONE(ChatColor.YELLOW.toString() + ChatColor.BOLD + ""),
    RIGHT_CLICK(ChatColor.YELLOW.toString() + ChatColor.BOLD + " RIGHT CLICK"),
    LEFT_CLICK(ChatColor.YELLOW.toString() + ChatColor.BOLD + " LEFT CLICK"),
    SNEAK_RIGHT_CLICK(ChatColor.YELLOW.toString() + ChatColor.BOLD + " SNEAK RIGHT CLICK"),
    SNEAK_LEFT_CLICK(ChatColor.YELLOW.toString() + ChatColor.BOLD + " SNEAK LEFT CLICK"),
    SNEAK(ChatColor.YELLOW.toString() + ChatColor.BOLD + " SNEAK");

    private String display;

    InteractionType(String display) {
        this.display = display;
    }

    public String getDisplay() { return display; }
}
