package dis.illusion.shop.util;

import org.bukkit.Bukkit;

public class VersionCheck {

    public static void test() {

        switch (Bukkit.getBukkitVersion().replace("-R0.1-SNAPSHOT", "")){

            case "":

                break;
            case "1.14.4":

                break;
            case "1.12.2":
                System.out.println("1.12.2 버젼 작동.");
                break;
        }
    }
}
