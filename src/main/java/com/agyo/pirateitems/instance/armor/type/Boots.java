package com.agyo.pirateitems.instance.armor.type;

import com.agyo.pirateitems.instance.Rarity;
import com.agyo.pirateitems.instance.armor.ArmorType;
import org.bukkit.Color;
import org.bukkit.Material;

public enum Boots {

    JONES_BOOTS(ArmorType.JONES_ARMOR, Rarity.UNIQUE.getColor() + "Jones' Boots", Material.LEATHER_BOOTS, Color.fromRGB(163, 112, 41));
    private ArmorType armorType;
    private String name;
    private Material material;
    private Color color;
    Boots(ArmorType armorType, String name, Material material, Color color) {
        this.armorType = armorType;
        this.name = name;
        this.material = material;
        this.color = color;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
