package com.agyo.pirateitems.instance.ability;

import com.agyo.pirateitems.instance.listener.RaiseTheCrewAbility;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.EventListener;

public enum AbilityType {

    NONE(" ", " ", 0, InteractionType.NONE),
    RAISE_THE_CREW(ChatColor.GOLD + "Ability: Raise the Crew", ChatColor.DARK_GRAY + "Summons Davy Jones' crew to attack the nearest entity.", 500, InteractionType.RIGHT_CLICK),
    FIRE_VEIL(ChatColor.GOLD + "Ability: Fire Veil", ChatColor.DARK_GRAY + "Creates a fire veil around the player", 200, InteractionType.RIGHT_CLICK),
    AGYOS_STICK(ChatColor.GOLD + "Ability: Agyo's Flight", ChatColor.DARK_GRAY + "Launches the player into the air with a magical gold block.", 50, InteractionType.RIGHT_CLICK),
    TELEPORT(ChatColor.GOLD + "Ability: Poseidon's Gift", ChatColor.DARK_GRAY + "Teleport's the player forward 8 blocks.", 25, InteractionType.RIGHT_CLICK);


    private String display, description;
    private int mana;
    private InteractionType interactionType;
    AbilityType(String display, String description, int mana, InteractionType interactionType) {
        this.display = display;
        this.description = description;
        this.mana = mana;
        this.interactionType = interactionType;
    }
    public String getDisplay() { return display; }
    public String getDescription() { return description; }

    public int getMana() { return mana; }

    public InteractionType getInteractionType() { return interactionType; }
}
