package com.theempiremc.EmpireCompass;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Compass implements Listener{
		
	public static Inventory diamond = Bukkit.createInventory(null, 54, ChatColor.GREEN + "" + ChatColor.BOLD + "Where do you want to go?");

	static {
		ArrayList<String> Spawn = new ArrayList<String>();
		ArrayList<String> ConnectShot = new ArrayList<String>();
		ArrayList<String> ConnectFac = new ArrayList<String>();
		ArrayList<String> ConnectSG = new ArrayList<String>();
		ArrayList<String> ConnectKit = new ArrayList<String>();
		ArrayList<String> ComingSoon = new ArrayList<String>();
		ArrayList<String> Diamond = new ArrayList<String>();
		
		Spawn.add("�AWhat a lovely beacon you have there!");
		ConnectShot.add("�3Pow! Right in the kisser...");
		ConnectFac.add("�6Non-PVP. Not even mobs can hurt yo balls.");
		ConnectSG.add("�3The skull-bashing Survival Games. KATNISS!");
		ConnectKit.add("�3Don't get too hot. YOU WILL BURN.");
		ComingSoon.add("�cComing soon!");
		Diamond.add("�9Click me to choose a gamemode!");
		
		ItemStack diamondthing = new ItemStack(Material.DIAMOND);
		ItemMeta diamondthing1 = diamondthing.getItemMeta();
		diamondthing1.setDisplayName("�6�lGame Chooser! �7(Right-click)");
		diamondthing1.setLore(Diamond);
		diamondthing.setItemMeta(diamondthing1);
		
		ItemStack spawn = new ItemStack(Material.SUGAR);
		ItemMeta spawn1 = spawn.getItemMeta();
		spawn1.setDisplayName("�eSpawn!");
		spawn1.setLore(Spawn);
		spawn.setItemMeta(spawn1);
		
		ItemStack oits = new ItemStack(Material.BOW);
		ItemMeta oits1 = oits.getItemMeta();
		oits1.setDisplayName("�dOne In The Shot (OITS)");
		oits1.setLore(ConnectShot);
		oits.setItemMeta(oits1);
		
		ItemStack fac = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta fac1 = fac.getItemMeta();
		fac1.setDisplayName("�eFactions");
		fac1.setLore(ConnectFac);
		fac.setItemMeta(fac1);
		
		ItemStack sg = new ItemStack(Material.IRON_SWORD);
		ItemMeta sg1 = sg.getItemMeta();
		sg1.setDisplayName("�eSurvival Games");
		sg1.setLore(ConnectSG);
		sg.setItemMeta(sg1);
		
		ItemStack pvp = new ItemStack(Material.FLINT_AND_STEEL);
		ItemMeta pvp1 = pvp.getItemMeta();
		pvp1.setDisplayName("�eKit PVP");
		pvp1.setLore(ConnectKit);
		pvp.setItemMeta(pvp1);
		
		ItemStack hide = new ItemStack(Material.WORKBENCH);
		ItemMeta hide1 = hide.getItemMeta();
		hide1.setDisplayName("�BBlockHunt");
		hide1.setLore(ComingSoon);
		hide.setItemMeta(hide1);

		diamond.setItem(13, spawn);
		diamond.setItem(21, oits);
		diamond.setItem(23, fac);
		diamond.setItem(29, sg);
		diamond.setItem(31, pvp);
		diamond.setItem(33, hide);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){ 
		Player p = e.getPlayer();
		Material m = p.getItemInHand().getType();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(m == Material.DIAMOND){
				p.openInventory(diamond);
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		Player player = (Player) event.getWhoClicked();        
			
        if(event.getCurrentItem().getType() == Material.SUGAR){
        	player.performCommand("spawn");
        	event.setCancelled(true);
	}
        if(event.getCurrentItem().getType() == Material.BOW){
        	player.performCommand("warp oits");
        	event.setCancelled(true);
	}
        if(event.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE){
        	player.performCommand("warp fac");
        	event.setCancelled(true);
	}
        if(event.getCurrentItem().getType() == Material.IRON_SWORD){
        	player.performCommand("warp sg");
        	event.setCancelled(true);
    }
        if(event.getCurrentItem().getType() == Material.FLINT_AND_STEEL){
        	player.performCommand("warp kitpvp");
        	event.setCancelled(true);
	}
        if(event.getCurrentItem().getType() == Material.WORKBENCH){
        	player.performCommand("warp hide");
        	event.setCancelled(true);
	}

}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player player = (Player) e.getPlayer();
		if(player.getInventory().contains(Material.DIAMOND)){
			return;			
		}else{
			player.performCommand("gimmehdagamechooser");
		}
	}
	
	
	
	public static void main(String[] args) {
		while (!sleeping) {
			code();
		}
	}
}
