package com.scarabcoder.gameapi.event;

import com.scarabcoder.gameapi.game.Area;
import com.scarabcoder.gameapi.game.GamePlayer;

public class PlayerLeaveAreaEvent extends AreaEvent {
	
	public PlayerLeaveAreaEvent(GamePlayer player, Area area) {
		super(player, area);
	}

}
