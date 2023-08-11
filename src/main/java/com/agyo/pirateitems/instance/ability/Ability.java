package com.agyo.pirateitems.instance.ability;

import com.agyo.pirateitems.PirateItems;
import com.agyo.pirateitems.instance.PirateItem;
import org.bukkit.entity.Player;

public abstract class Ability {

    protected PirateItem item;
    protected Player player;

    public Ability(PirateItem item, Player player) {
        this.item = item;
        this.player = player;
    }

    public abstract void useAbility();

}
