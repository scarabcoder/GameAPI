package com.scarabcoder.gameapi.event;

import com.scarabcoder.gameapi.game.Area;
import com.scarabcoder.gameapi.game.GamePlayer;

public class PlayerEnterAreaEvent extends AreaEvent {

	public PlayerEnterAreaEvent(GamePlayer player, Area area) {
		super(player, area);
	}
	
	
	
	
}
