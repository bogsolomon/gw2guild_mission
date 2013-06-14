package ca.bsolomon.gw2.guild.mission;

import net.sf.json.JSONObject;

import org.joda.time.Chronology;
import org.joda.time.DateTime;

import ca.bsolomon.gw2.guild.mission.util.EventData;
import ca.bsolomon.gw2event.api.GW2EventsAPI;

public class DataRetrieveJob {

	private GW2EventsAPI api = new GW2EventsAPI();
	
	protected boolean queryEvent(Chronology gregorianJuian,
			String serverId, String eventUID, EventData dataStructure) {
		JSONObject result = api.queryServer(serverId, eventUID);
		boolean changed = false;
		
		if (result != null) {
			if (dataStructure.addEventStatus(serverId, eventUID, result.getString("state"), new DateTime(gregorianJuian), result.getString("map_id"))) {
				changed = true;
			}
		}
		return changed;
	}

	public GW2EventsAPI getApi() {
		return api;
	}
}
