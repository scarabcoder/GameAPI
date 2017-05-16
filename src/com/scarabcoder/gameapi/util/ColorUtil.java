package com.scarabcoder.gameapi.util;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

public class ColorUtil {
	
	public static ChatColor dyeColorToChatColor(DyeColor color){
		switch(color){
		case BLACK:
			return ChatColor.BLACK;
		case BLUE:
			return ChatColor.BLUE;
		case BROWN:
			return ChatColor.GOLD;
		case CYAN:
			return ChatColor.AQUA;
		case GRAY:
			return ChatColor.GRAY;
		case GREEN:
			return ChatColor.DARK_GREEN;
		case LIGHT_BLUE:
			return ChatColor.AQUA;
		case LIME:
			return ChatColor.GREEN;
		case MAGENTA:
			return ChatColor.DARK_PURPLE;
		case ORANGE:
			return ChatColor.GOLD;
		case PINK:
			return ChatColor.LIGHT_PURPLE;
		case PURPLE:
			return ChatColor.DARK_PURPLE;
		case RED:
			return ChatColor.RED;
		case SILVER:
			return ChatColor.GRAY;
		case WHITE:
			return ChatColor.WHITE;
		case YELLOW:
			return ChatColor.YELLOW;
		default:
			return ChatColor.WHITE;
		
		}
	}
	
}
