package com.scarabcoder.gameapi.event.gui;

import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.gui.InventoryGUI;

public class InventoryButtonClickEvent extends InventoryGUIEvent {
	
	private String buttonID;

	public InventoryButtonClickEvent(InventoryGUI gui, GamePlayer player, String buttonID) {
		super(gui, player);
		this.buttonID = buttonID;
	}
	
	public String getButtonID(){
		return this.buttonID;
	}

}
