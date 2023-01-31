package net.illusion.core;

import net.illusion.core.util.plugin.Metrics;
import net.illusion.core.util.plugin.Register;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;


import java.util.ArrayList;
import java.util.List;


public class Illusion extends Register {

    public static List<String> plugins = new ArrayList<>();

    public Illusion() {
        super("Core");
        plugins.add(getName());
    }

    public void onEnable() {
        init();
    }


    public void init() {
        new Metrics(this, 17538);

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "=======================================================");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "                  일루전 코어 작동 완료                ");

         plugins.forEach(name -> {
            Bukkit.getConsoleSender().sendMessage(name);
        });
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "=======================================================");
    }
}
