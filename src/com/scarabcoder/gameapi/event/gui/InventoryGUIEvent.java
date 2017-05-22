package com.scarabcoder.gameapi.event.gui;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.gui.InventoryGUI;

public class InventoryGUIEvent extends Event {

	private static HandlerList handlers = new HandlerList();
	private InventoryGUI gui;
	private GamePlayer player;
	
	public InventoryGUIEvent(InventoryGUI gui, GamePlayer player){
		this.gui = gui;
		this.player = player;
	}
	
	public InventoryGUI getInventoryGUI(){
		return this.gui;
	}
	
	public GamePlayer getPlayer(){
		return this.player;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList(){
		return handlers;
	}

}
