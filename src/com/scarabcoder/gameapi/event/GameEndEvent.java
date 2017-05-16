package com.scarabcoder.gameapi.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scarabcoder.gameapi.game.Game;

public class GameEndEvent extends Event  {

	private static final HandlerList handlers = new HandlerList();
	private Game game;
	
	public GameEndEvent(Game game){
		this.game = game;
	}
	
	/**
	 * Get the game this event refers to.
	 * @return Game
	 */
	public Game getGame(){
		return game;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}


}
