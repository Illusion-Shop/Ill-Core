package net.illusion.core.util.plugin;

import net.illusion.core.Illusion;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Expansion extends JavaPlugin {


    private String author;

    private String version;


    public void setAuthor() {
        this.author = "SkyExcel";
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void register() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + getName() + " 플러그인 적용 완료 하였습니다.");
        Illusion.plugins.add(this);
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }
}
