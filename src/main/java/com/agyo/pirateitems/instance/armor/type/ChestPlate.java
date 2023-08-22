package com.agyo.pirateitems.instance.armor.type;

import com.agyo.pirateitems.instance.Rarity;
import com.agyo.pirateitems.instance.armor.ArmorType;
import org.bukkit.Color;
import org.bukkit.Material;

public enum ChestPlate {

    JONES_CHESTPLATE(ArmorType.JONES_ARMOR, Rarity.UNIQUE.getColor() + "Jones' Tunic", Material.LEATHER_CHESTPLATE, Color.fromRGB(0, 153, 204));

    private ArmorType armorType;
    private String name;
    private Material material;
    private Color color;

    ChestPlate(ArmorType armorType, String name, Material material, Color color) {
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
