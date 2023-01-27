package net.illusion.core;

import net.illusion.core.data.Config;
import net.illusion.core.util.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class Illusion extends JavaPlugin {

    public void onEnable() {
        init();
    }

    public void onDisable() {
        super.onDisable();
    }

    public void init(){
        Config config = new Config("config");
        config.setPlugin(this);
        config.loadDefualtConfig();
        new Metrics(this,17538);
    }
}
