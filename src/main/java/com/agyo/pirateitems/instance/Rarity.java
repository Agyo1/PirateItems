package com.agyo.pirateitems.instance;

import org.bukkit.ChatColor;

public enum Rarity {

    COMMON(ChatColor.WHITE, ChatColor.WHITE.toString() + ChatColor.BOLD + "COMMON"),
    UNCOMMON(ChatColor.GREEN, ChatColor.GREEN.toString() + ChatColor.BOLD + "UNCOMMON"),
    RARE(ChatColor.BLUE, ChatColor.BLUE.toString() + ChatColor.BOLD +"RARE"),
    EPIC(ChatColor.DARK_PURPLE, ChatColor.DARK_PURPLE.toString() + ChatColor.BOLD + "EPIC"),
    LEGENDARY(ChatColor.GOLD, ChatColor.GOLD.toString() + ChatColor.BOLD + "LEGENDARY"),
    MYTHIC(ChatColor.LIGHT_PURPLE, ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD + "MYTHIC"),
    UNIQUE(ChatColor.AQUA, ChatColor.AQUA.toString() + ChatColor.BOLD + "UNIQUE");

    private ChatColor color;
    private String display;
    Rarity(ChatColor color, String display) {
        this.color = color;
        this.display = display;
    }

    public ChatColor getColor() { return color; }
    public String getDisplay() {return display;}

}
