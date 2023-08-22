package com.agyo.pirateitems.instance.armor.type;

import com.agyo.pirateitems.instance.Rarity;
import com.agyo.pirateitems.instance.armor.ArmorType;
import org.bukkit.Material;

public enum PlayerHelmet {

    JONES_HELMET(ArmorType.JONES_ARMOR, Rarity.UNIQUE.getColor() + "Jones' Helmet", Material.PLAYER_HEAD, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQ5N2JjYzY1NWQ1YjA0NjE1ZjkxYThlN2MyY2ZjYjJiNDYyYmM0MjlhN2QwNzJhY2RlNGQ2ZjhiZDRmNTMifX19");
    private ArmorType armorType;
    private String name, texture;
    private Material material;

    PlayerHelmet(ArmorType armorType, String name, Material material, String texture) {
        this.armorType = armorType;
        this.name = name;
        this.material = material;
        this.texture = texture;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public String getTexture() {
        return texture;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

}
