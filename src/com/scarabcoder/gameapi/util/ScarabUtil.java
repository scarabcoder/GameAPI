package com.scarabcoder.gameapi.util;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.scarabcoder.gameapi.enums.DefaultFontInfo;
import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.manager.PlayerManager;

import net.md_5.bungee.api.ChatColor;

public class ScarabUtil {
	
	public static boolean isPlayerDamager(EntityDamageByEntityEvent e){
		return getDamager(e) != null;
	}
	
	public static GamePlayer getDamager(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			return PlayerManager.getGamePlayer(((Player) e.getDamager()));
		}else if(e.getDamager() instanceof Projectile){
			Projectile a = (Projectile) e.getDamager();
			if(a.getShooter() != null){
				if(a.getShooter() instanceof Player){
					return PlayerManager.getGamePlayer((Player)a.getShooter());
				}
			}
		}
		return null;
	}
	
	private final static int CENTER_PX = 154;
	
	//Source: SirSpoodles on Spigot
	public static String getCenteredMessage(String message){
	        if(message == null || message.equals("")) return "";
	                message = ChatColor.translateAlternateColorCodes('&', message);
	               
	                int messagePxSize = 0;
	                boolean previousCode = false;
	                boolean isBold = false;
	               
	                for(char c : message.toCharArray()){
	                        if(c == '§'){
	                                previousCode = true;
	                                continue;
	                        }else if(previousCode == true){
	                                previousCode = false;
	                                if(c == 'l' || c == 'L'){
	                                        isBold = true;
	                                        continue;
	                                }else isBold = false;
	                        }else{
	                                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
	                                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
	                                messagePxSize++;
	                        }
	                }
	               
	                int halvedMessageSize = messagePxSize / 2;
	                int toCompensate = CENTER_PX - halvedMessageSize;
	                int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
	                int compensated = 0;
	                StringBuilder sb = new StringBuilder();
	                while(compensated < toCompensate){
	                        sb.append(" ");
	                        compensated += spaceLength;
	                }
	                return sb.toString() + message;
	        }
	
}
