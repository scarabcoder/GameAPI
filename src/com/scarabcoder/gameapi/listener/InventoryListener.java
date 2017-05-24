package com.scarabcoder.gameapi.listener;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.scarabcoder.gameapi.event.gui.InventoryButtonClickEvent;
import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.gui.GUIManager;
import com.scarabcoder.gameapi.gui.InventoryGUI;
import com.scarabcoder.gameapi.manager.PlayerManager;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		if(GUIManager.isGUI(e.getClickedInventory())){
			InventoryGUI gui = GUIManager.getGUI(e.getClickedInventory());
			if(gui.isButton(e.getSlot())){
				GamePlayer p = PlayerManager.getGamePlayer((OfflinePlayer) e.getWhoClicked());
				InventoryButtonClickEvent ev = new InventoryButtonClickEvent(gui, p, gui.getButtonID(e.getSlot()), e.getCurrentItem());
				Bukkit.getPluginManager().callEvent(ev);
			}
		}
	}
	
}
