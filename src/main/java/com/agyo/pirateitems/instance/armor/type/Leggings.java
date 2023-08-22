package com.agyo.pirateitems.instance.armor.type;

import com.agyo.pirateitems.instance.Rarity;
import com.agyo.pirateitems.instance.armor.ArmorType;
import org.bukkit.Color;
import org.bukkit.Material;

public enum Leggings {

    JONES_LEGGINGS(ArmorType.JONES_ARMOR, Rarity.UNIQUE.getColor() + "Jones' Leggings", Material.LEATHER_LEGGINGS, Color.fromRGB(25, 132, 202));
    private ArmorType armorType;
    private String name;
    private Material material;
    private Color color;
    Leggings(ArmorType armorType, String name, Material material, Color color) {
        this.armorType = armorType;
        this.name = name;
        this.material = material;
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
