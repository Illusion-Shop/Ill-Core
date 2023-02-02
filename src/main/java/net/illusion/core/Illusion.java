package net.illusion.core;

import net.illusion.core.util.plugin.Metrics;
import net.illusion.core.util.plugin.Expansion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;
import java.util.List;


public class Illusion extends Expansion {

    public static List<Expansion> plugins = new ArrayList<>();

    @Override
    public void onEnable() {
        super.onEnable();
        new Metrics(this, 17538);
        register();
    }
}
