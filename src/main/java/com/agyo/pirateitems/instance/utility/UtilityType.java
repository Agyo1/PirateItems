package com.agyo.pirateitems.instance.utility;

import com.agyo.pirateitems.instance.Rarity;
import com.agyo.pirateitems.instance.ability.AbilityType;
import org.bukkit.Material;

public enum UtilityType {

    AGYOS_MAGICAL_STICK(Rarity.MYTHIC, Rarity.MYTHIC.getColor() + "Agyo's Magical Stick", Material.STICK, true, AbilityType.AGYOS_STICK);
    private Rarity rarity;
    private String name;
    private Material material;
    private boolean enchanted;
    private AbilityType abilityType;
    UtilityType(Rarity rarity, String name, Material material, boolean enchanted, AbilityType abilityType) {
        this.rarity = rarity;
        this.name = name;
        this.material = material;
        this.enchanted = enchanted;
        this.abilityType = abilityType;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public AbilityType getAbilityType() {
        return abilityType;
    }

    public boolean isEnchanted() {
        return enchanted;
    }

}
