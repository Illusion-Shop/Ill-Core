package net.illusion.core.util.item;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("all")
public class PDCData {
    private Plugin plugin;

    public PDCData(Plugin plugin) {

        Objects.requireNonNull(plugin, "JeffLib hasn't been initialized.");
        this.plugin = plugin;
    }

    public void setString(ItemStack item, String key, String value) {
        Objects.requireNonNull(item, "item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.STRING, value);
        item.setItemMeta(meta);
    }

    public void setInteger(ItemStack item, String key, Integer value) {
        Objects.requireNonNull(item, "item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.INTEGER, value);
        item.setItemMeta(meta);
    }


    public void setLong(ItemStack item, String key, Long value) {
        Objects.requireNonNull(item, "item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.LONG, value);
        item.setItemMeta(meta);
    }

    public void setFloat(ItemStack item, String key, Float value) {
        Objects.requireNonNull(item, "item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.FLOAT, value);
        item.setItemMeta(meta);
    }

    public void setShort(ItemStack item, String key, short value) {
        Objects.requireNonNull(item, "item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.SHORT, value);
        item.setItemMeta(meta);
    }

    public void setByte(ItemStack item, String key, Byte value) {
        Objects.requireNonNull(item, "item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.BYTE, value);
        item.setItemMeta(meta);
    }


    public void setByte(ItemStack item, String key, byte[] value) {
        Objects.requireNonNull(item, "item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.BYTE_ARRAY, value);
        item.setItemMeta(meta);
    }

    public void setDouble(ItemStack item, String key, double value) {
        Objects.requireNonNull(item, "item must not be null");
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.DOUBLE, value);

        item.setItemMeta(meta);
    }

    public @Nullable byte getByte(ItemStack item, String key) {
        Objects.requireNonNull(item, "item must not be null");
        if (!item.hasItemMeta()) return -1;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        return pdc.get(namespacedKey, PersistentDataType.BYTE);
    }

    public @Nullable byte getByte(Entity entity, String key) {
        Objects.requireNonNull(entity, "entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);

        return pdc.get(namespacedKey, PersistentDataType.BYTE);
    }

    public @Nullable Double getDouble(ItemStack item, String key) {
        Objects.requireNonNull(item, "item must not be null");
        if (!item.hasItemMeta()) return null;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        if (pdc.has(namespacedKey, PersistentDataType.STRING)) {
            return pdc.get(namespacedKey, PersistentDataType.DOUBLE);
        }
        return null;
    }

    public @Nullable Double getDouble(Entity entity, String key) {
        Objects.requireNonNull(entity, "entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        if (pdc.has(namespacedKey, PersistentDataType.STRING)) {
            return pdc.get(namespacedKey, PersistentDataType.DOUBLE);
        }
        return null;
    }

    public @Nullable Integer getInteger(ItemStack item, String key) {
        Objects.requireNonNull(item, "item must not be null");
        if (!item.hasItemMeta()) return null;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        if (pdc.has(namespacedKey, PersistentDataType.STRING)) {
            return pdc.get(namespacedKey, PersistentDataType.INTEGER);
        }
        return null;
    }

    public @Nullable Integer getInteger(Entity entity, String key) {
        Objects.requireNonNull(entity, "entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        if (pdc.has(namespacedKey, PersistentDataType.STRING)) {
            return pdc.get(namespacedKey, PersistentDataType.INTEGER);
        }
        return null;
    }

    public @Nullable String getString(ItemStack item, String key) {
        Objects.requireNonNull(item, "item must not be null");
        if (!item.hasItemMeta()) return null;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        if (pdc.has(namespacedKey, PersistentDataType.STRING)) {
            return pdc.get(namespacedKey, PersistentDataType.STRING);
        }
        return null;
    }

    public @Nullable String getString(Entity entity, String key) {
        Objects.requireNonNull(entity, "entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        if (pdc.has(namespacedKey, PersistentDataType.STRING)) {
            return pdc.get(namespacedKey, PersistentDataType.STRING);
        }
        return null;
    }


    public void addNBT(Entity entity, String key, String value) {
        Objects.requireNonNull(entity, "entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        pdc.set(namespacedKey, PersistentDataType.STRING, value);
    }

    public boolean hasNBT(ItemStack item, String key) {
        Objects.requireNonNull(item, "item must not be null");
        if (!item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        return pdc.has(new NamespacedKey(plugin, key), PersistentDataType.STRING);
    }

    public boolean hasNBT(Entity entity, String key) {
        Objects.requireNonNull(entity, "entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        return pdc.has(new NamespacedKey(plugin, key), PersistentDataType.STRING);
    }

    public void removeNBT(ItemStack item, String key) {
        Objects.requireNonNull(item, "item must not be null");
        if (!item.hasItemMeta()) return;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin, key));
        item.setItemMeta(meta);
    }

    public void removeNBT(Entity entity, String key) {
        Objects.requireNonNull(entity, "entity must not be null");
        PersistentDataContainer pdc = entity.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin, key));
    }


    public HashMap<String, String> getAllValues(ItemStack item) {
        Objects.requireNonNull(item, "item must not be null");
        HashMap<String, String> map = new HashMap<>();
        if (!item.hasItemMeta()) return map;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        for (NamespacedKey key : pdc.getKeys()) {
            map.put(key.toString(), pdc.get(key, PersistentDataType.STRING));
        }
        return map;
    }

    public List<String> getAllKeys(ItemStack item) {
        Objects.requireNonNull(item, "item must not be null");
        List<String> keys = new ArrayList<>();
        if (!item.hasItemMeta()) return null;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        for (NamespacedKey key : pdc.getKeys()) {
            keys.add(key.getKey());
        }
        return keys;
    }
}