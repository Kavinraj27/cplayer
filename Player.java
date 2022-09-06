package com.itc.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
    private int pid;
  

	@Column(name = "name")
    private String name;
	@Column(name = "team")
	 String team;
	@Column(name = "run")
	 Long run;
	public Player() {
		super();
	}
	public Player(int pid, String name, String team,Long run) {
		super();
		this.pid = pid;
		this.name = name;
		this.team = team;
		this.run = run;
	}
	public Player(int i, String string, int j, String string2) {
		// TODO Auto-generated constructor stub
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Long getRun() {
		return run;
	}
	public void setRun(Long run) {
		this.run = run;
	}
	@Override
	public String toString() {
		return "Player [pid=" + pid + ", name=" + name + ", team=" + team + ", run=" + run + "]";
	}
}
