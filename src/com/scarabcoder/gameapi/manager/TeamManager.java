package com.scarabcoder.gameapi.manager;

import java.util.ArrayList;
import java.util.List;

import com.scarabcoder.gameapi.game.Team;

public class TeamManager {
	
	private List<Team> teams = new ArrayList<Team>();

	public TeamManager(){
		
	}
	
	public void registerTeam(Team team){
		this.teams.add(team);
	}
	
}
