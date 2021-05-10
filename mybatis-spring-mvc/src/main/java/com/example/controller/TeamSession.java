package com.example.controller;

import java.io.Serializable;

import com.example.model.Team;


@SuppressWarnings("serial")
public class TeamSession implements Serializable {

	private Team team;

	public TeamSession(Team team) {
		this.team = team;
	}

	public Team getTeam() {
		return team;
	}

}
