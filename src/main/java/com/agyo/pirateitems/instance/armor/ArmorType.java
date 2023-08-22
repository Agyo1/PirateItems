package com.agyo.pirateitems.instance.armor;

import com.agyo.pirateitems.instance.Rarity;
import com.agyo.pirateitems.instance.armor.type.Boots;
import com.agyo.pirateitems.instance.armor.type.ChestPlate;
import com.agyo.pirateitems.instance.armor.type.Leggings;
import com.agyo.pirateitems.instance.armor.type.PlayerHelmet;

public enum ArmorType {

    JONES_ARMOR(Rarity.UNIQUE, Rarity.UNIQUE.getColor() + "Jones' Armor", 400, PlayerHelmet.JONES_HELMET, ChestPlate.JONES_CHESTPLATE, Leggings.JONES_LEGGINGS, Boots.JONES_BOOTS);

    private String name;
    private int defense;
    private Rarity rarity;
    private PlayerHelmet playerHelmet;
    private ChestPlate chestPlate;
    private Leggings leggings;
    private Boots boots;

    ArmorType(Rarity rarity, String name, int defense, PlayerHelmet playerHelmet, ChestPlate chestPlate, Leggings leggings, Boots boots) {
        this.name = name;
        this.defense = defense;
        this.rarity = rarity;
        this.playerHelmet = playerHelmet;
        this.chestPlate = chestPlate;
        this.leggings = leggings;
        this.boots = boots;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public PlayerHelmet getPlayerHelmet() {
        return playerHelmet;
    }

    public ChestPlate getChestPlate() {
        return chestPlate;
    }

    public Boots getBoots() {
        return boots;
    }

    public Leggings getLeggings() {
        return leggings;
    }
}
