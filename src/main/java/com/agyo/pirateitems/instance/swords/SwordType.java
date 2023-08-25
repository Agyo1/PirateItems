package com.agyo.pirateitems.instance.swords;

import com.agyo.pirateitems.instance.Rarity;
import com.agyo.pirateitems.instance.ability.AbilityType;
import org.bukkit.Material;

public enum SwordType {

    ROOKIE_SWORD(Rarity.COMMON, Rarity.COMMON.getColor() + "Rookie Sword", 5, Material.WOODEN_SWORD, "SWORD", AbilityType.NONE),
    JONES_BLADE(Rarity.UNIQUE, Rarity.UNIQUE.getColor() + "Jones' Blade", 300, Material.IRON_SWORD, "BLADE", AbilityType.RAISE_THE_CREW),
    CAPTAIN_SWORD(Rarity.LEGENDARY, Rarity.LEGENDARY.getColor() + "Captain's Sword", 100, Material.GOLDEN_SWORD, "SWORD", AbilityType.NONE),
    BLACKBEARDS_CUTLASS(Rarity.MYTHIC, Rarity.MYTHIC.getColor() + "Blackbeard's Cutlass", 125, Material.NETHERITE_SWORD, "CUTLASS", AbilityType.TELEPORT);


    private Rarity rarity;
    private String name, type;
    private int damage;
    private Material material;
    private AbilityType abilityType;
    SwordType(Rarity rarity, String name, int damage, Material material, String type, AbilityType abilityType) {
        this.rarity = rarity;
        this.name = name;
        this.damage = damage;
        this.material = material;
        this.type = type;
        this.abilityType = abilityType;
    }
    public Rarity getRarity() { return rarity; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getDamage() { return damage; }
    public Material getMaterial() { return material; }
    public AbilityType getAbilityType() { return abilityType; }
}
