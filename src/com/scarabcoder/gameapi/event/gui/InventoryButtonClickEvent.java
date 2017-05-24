package com.scarabcoder.gameapi.event.gui;

import org.bukkit.inventory.ItemStack;

import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.gui.InventoryGUI;

public class InventoryButtonClickEvent extends InventoryGUIEvent {
	
	private String buttonID;
	private ItemStack stack;
	
	
	public InventoryButtonClickEvent(InventoryGUI gui, GamePlayer player, String buttonID, ItemStack stack) {
		super(gui, player);
		this.buttonID = buttonID;
		this.stack = stack;
	}
	
	public ItemStack getItemStack(){
		return this.stack;
	}
	
	public String getButtonID(){
		return this.buttonID;
	}

}
