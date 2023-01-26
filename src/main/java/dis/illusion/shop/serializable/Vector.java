package dis.illusion.shop.serializable;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

import java.util.LinkedHashMap;
import java.util.Map;

@SerializableAs("Vector")
public class Vector implements Cloneable, ConfigurationSerializable {

    private double x;

    private double y;

    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Map<String, Object> serialize() {
        LinkedHashMap result = new LinkedHashMap();
        result.put("x", Double.valueOf(getX()));
        result.put("y", Double.valueOf(getY()));
        result.put("z", Double.valueOf(getZ()));
        return result;
    }

    public static org.bukkit.util.Vector deserialize(Map<String, Object> args) {
        double x = 0.0D;
        double y = 0.0D;
        double z = 0.0D;
        if (args.containsKey("x")) {
            x = ((Double) args.get("x")).doubleValue();
        }

        if (args.containsKey("y")) {
            y = ((Double) args.get("y")).doubleValue();
        }

        if (args.containsKey("z")) {
            z = ((Double) args.get("z")).doubleValue();
        }

        return new org.bukkit.util.Vector(x, y, z);
    }
}