package com.scarabcoder.gameapi.gui;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.inventory.Inventory;

public class GUIManager {
	
	private static HashMap<UUID, InventoryGUI> guis = new HashMap<UUID, InventoryGUI>();
	
	protected static void registerGUI(InventoryGUI gui){
		guis.put(gui.getID(), gui);
	}
	
	public static InventoryGUI getGUI(String id){
		return guis.get(UUID.fromString(id));
	}
	
	public static InventoryGUI getGUI(UUID id){
		return guis.get(id);
	}
	
	public static InventoryGUI getGUI(Inventory inv){
		for(UUID guiID : guis.keySet()){
			InventoryGUI gui = guis.get(guiID);
			if(gui.getInventory().equals(inv)){
				return gui;
			}
		}
		return null;
	}
	
	public static boolean isGUI(Inventory inv){
		return getGUI(inv) != null;
	}
	
}
