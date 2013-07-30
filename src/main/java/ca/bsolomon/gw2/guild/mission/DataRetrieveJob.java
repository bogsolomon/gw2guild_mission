package ca.bsolomon.gw2.guild.mission;

import org.joda.time.Chronology;
import org.joda.time.DateTime;

import ca.bsolomon.gw2.guild.mission.util.EventData;
import ca.bsolomon.gw2event.api.GW2EventsAPI;
import ca.bsolomon.gw2event.api.dao.Event;

public class DataRetrieveJob {

	private GW2EventsAPI api = new GW2EventsAPI();
	
	protected boolean queryEvent(Chronology gregorianJuian,
			String serverId, String eventUID, EventData dataStructure) {
		Event result = api.queryServer(serverId, eventUID);
		boolean changed = false;
		
		if (result != null) {
			if (dataStructure.addEventStatus(serverId, eventUID, result.getState(), new DateTime(gregorianJuian), result.getMapId())) {
				changed = true;
			}
		}
		return changed;
	}

	public GW2EventsAPI getApi() {
		return api;
	}
}
