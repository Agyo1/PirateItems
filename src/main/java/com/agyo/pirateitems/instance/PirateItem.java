package com.agyo.pirateitems.instance;

import com.agyo.pirateitems.PirateItems;
import org.bukkit.entity.Player;

public abstract class PirateItem {

    protected Player player;

    public PirateItem(Player player) {
        this.player = player;
    }

    public abstract void enable();
    public abstract void disable();


}
