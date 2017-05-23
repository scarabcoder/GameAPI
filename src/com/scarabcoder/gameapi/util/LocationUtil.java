package com.scarabcoder.gameapi.util;

import org.bukkit.Location;

public class LocationUtil {
	
	public static boolean isInArea(Location l, Location l1, Location l2){
		
		double x1 = Math.min(l1.getX(), l2.getX());
		double y1 = Math.min(l1.getY(), l2.getY());
		double z1 = Math.min(l1.getZ(), l2.getZ());
		
		double x2 = Math.max(l1.getX(), l2.getX());
		double y2 = Math.max(l1.getY(), l2.getY());
		double z2 = Math.max(l1.getZ(), l2.getZ());
		
		if(l.getX() >= x1 && l.getX() <= x2 &&
				l.getY() >= y1 && l.getY() <= y2 &&
				l.getZ() >= z1 && l.getZ() <= z2){
			return true;
		}
		
		
		
		return false;
	}
	
}
