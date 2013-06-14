package ca.bsolomon.gw2.guild.mission.util;

public class Location {

	private final String name;
	private final String map;
	private final String waypoint;
	private final String help;
	private final String state;
	
	public Location(String name, String map, String waypoint, String help, String state) {
		this.name = name;
		this.map = map;
		this.waypoint = waypoint;
		this.help = help;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public String getMap() {
		return map;
	}

	public String getWaypoint() {
		return waypoint;
	}

	public String getHelp() {
		return help;
	}

	public String getState() {
		return state;
	}
}
