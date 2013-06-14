package ca.bsolomon.gw2.guild.mission.util;

import java.util.List;

public class Mission {

	private String type;
	
	private List<Location> locations;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
}
