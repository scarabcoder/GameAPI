package com.scarabcoder.gameapi.gui;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.scarabcoder.gameapi.game.GamePlayer;

public class InventoryGUI {
	
	private int rowAmount = 0;
	private Inventory inventory;
	private UUID id;
	private HashMap<Integer, String> btns = new HashMap<Integer, String>();
	
	public InventoryGUI(String title){
		this.id = UUID.randomUUID();
		GUIManager.registerGUI(this);
		if(this.rowAmount == 0) this.rowAmount = 6;
		this.inventory = Bukkit.createInventory(null, rowAmount * 9, title);
		
	}
	
	public void open(GamePlayer player){
		if(player.isOnline()){
			player.getOnlinePlayer().openInventory(this.inventory);
		}
	}
	
	public void setButton(String id, int slot, ItemStack button){
		this.inventory.setItem(slot, button);
		this.btns.put(slot, id);
	}
	
	public InventoryGUI(int rowAmount, String title){
		this(title);
		this.rowAmount = rowAmount;
	}
	
	public UUID getID(){
		return this.id;
	}
	
	public Inventory getInventory(){
		return this.inventory;
	}
	
	public String getButtonID(int slot){
		return btns.get(slot);
	}
	
	public boolean isButton(int slot){
		return getButtonID(slot) != null;
	}
	
}
