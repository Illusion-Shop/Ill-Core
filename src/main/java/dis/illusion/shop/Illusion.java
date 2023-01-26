package dis.illusion.shop;


import dis.illusion.shop.serializable.Vector;
import dis.illusion.shop.util.Metrics;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;


public class Illusion extends JavaPlugin {

    public void onEnable() {
        init();
    }

    public void onDisable() {
        super.onDisable();
    }

    public void init(){

        new Metrics(this,17538);


        ConfigurationSerialization.registerClass(Vector.class, "TestData");
    }
}
