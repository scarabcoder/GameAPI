package com.scarabcoder.gameapi.util;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardUtil {
	
	public static Scoreboard createScoreboard(String title, String...strings){
		return createScoreboard(title, Arrays.asList(strings));
	}
	
	public static Scoreboard createScoreboard(String title, List<String> strings){
		Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = s.registerNewObjective(title, "dummy");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(title);
		for(int x = strings.size() - 1; x != -1; x--){
			obj.getScore(strings.get(x)).setScore(strings.size() - x);
		}
		return s;
	}
	
}
