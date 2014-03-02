package com.theempiremc.EmpireCompass;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable(){
		System.out.println("GG. Compass enabled.");
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Compass(), this);
	}
	
	public void onDisable(){
		System.out.println("GG. Compass disabled.");
	}
	
	public ItemStack setNameAndLore(Material material, int amount, String name, String... lore)
    {
        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        ArrayList<String> lorez = new ArrayList<String>();
        for(String mylores : lore)
        {
            lorez.add(ChatColor.translateAlternateColorCodes('&', mylores));
        }
        meta.setLore(lorez);
        item.setItemMeta(meta);
        return item;
    }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("gamechooserplz")){
			Player player = (Player) sender;
			if(!(sender instanceof Player)){
				sender.sendMessage("NO");
			}else{
				player.getInventory().addItem(setNameAndLore(Material.DIAMOND, 1, "&6Game Chooser! &7(Right-click)", "&dClick to choose!"));
			return true;
	}
}
		return true;
}
}