package eu.cubix.mc.hub.tools;


import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;

public class ItemsBuilder {

    private final ItemStack itemStack;
    private static final Base64 base64 = new Base64();

    public ItemsBuilder(ItemStack itemStack){
        this.itemStack = itemStack;

    }

    public ItemsBuilder(Material material){
        this(material, 1);
    }

    public ItemsBuilder(Material material, int amount){
        this.itemStack = new ItemStack(material, amount);
    }

    public ItemsBuilder(Material material, int amount, byte durability){
        this.itemStack = new ItemStack(material, amount, (short)durability);
    }

    public ItemsBuilder setName(String name){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder setLore(String... lore){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setLore(Arrays.asList(lore));
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder setLore(List<String> lore){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setLore(lore);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder addLore(String line){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        List<String> lore = new ArrayList<>(itemMeta.getLore());
        lore.add(line);
        itemMeta.setLore(lore);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder addLore(String line, int position){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        List<String> lore = new ArrayList<>(itemMeta.getLore());
        lore.set(position, line);
        itemMeta.setLore(lore);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder removeLore(String line){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        List<String> lore = new ArrayList<>(itemMeta.getLore());

        if (!lore.contains(line)) return this;

        lore.remove(line);
        itemMeta.setLore(lore);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder removeLore(int index){

        ItemMeta itemMeta = this.itemStack.getItemMeta();
        ArrayList<String> lore = new ArrayList<>(itemMeta.getLore());

        if ((index < 0) || (index > lore.size())) return this;

        lore.remove(index);
        itemMeta.setLore(lore);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder setDurability(short durability){
        this.itemStack.setDurability(durability);
        return this;
    }

    public ItemsBuilder addEnchant(Enchantment enchantment, int level){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addEnchant(enchantment, level, true);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder addUnsafeEnchantment(Enchantment enchantment, int level){
        this.itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemsBuilder removeEnchantment(Enchantment enchantment){
        this.itemStack.removeEnchantment(enchantment);
        return this;
    }

    public ItemsBuilder setSkullOwner(String ownerName){
        SkullMeta itemMeta = (SkullMeta)this.itemStack.getItemMeta();
        itemMeta.setOwner(ownerName);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public static ItemStack setSkullID(String skullID) {
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        if (propertyMap == null) {
            throw new IllegalStateException("Profile doesn't contain a property map");
        }
        byte[] encodedData = base64.encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "https://textures.minecraft.net/texture/"+skullID).getBytes());
        propertyMap.put("textures", new Property("textures", new String(encodedData)));
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        ItemMeta headMeta = head.getItemMeta();
        Class<?> headMetaClass = headMeta.getClass();
        try {
            Reflection.getField(headMetaClass, true, "profile").set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public ItemsBuilder addEnchantments(Map<Enchantment, Integer> enchantments){
        this.itemStack.addEnchantments(enchantments);
        return this;
    }

    public ItemsBuilder setDyeColor(DyeColor dyeColor){
        this.itemStack.setDurability(dyeColor.getDyeData());
        return this;
    }

    public ItemsBuilder setWoolColor(DyeColor color){
        if(!this.itemStack.getType().equals(Material.WOOL)) return this;
        this.itemStack.setDurability(color.getWoolData());
        return this;
    }

    public ItemsBuilder setFlags(ItemFlag... flags){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.addItemFlags(flags);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder removeFlags(ItemFlag... flags){
        ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.removeItemFlags(flags);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder setLeatherArmorColor(Color color){
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) this.itemStack.getItemMeta();
        itemMeta.setColor(color);
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemsBuilder clone(){
        return new ItemsBuilder(this.itemStack);
    }

    public ItemStack toItemStack(){
        return this.itemStack;
    }

}
