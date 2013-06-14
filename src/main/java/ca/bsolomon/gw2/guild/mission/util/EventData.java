package ca.bsolomon.gw2.guild.mission.util;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJChronology;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

public interface EventData {
	
	public static PeriodFormatter HHMMSSFormater = new PeriodFormatterBuilder().
			printZeroAlways().minimumPrintedDigits(2).
			appendHours().appendSeparator(":").
			appendMinutes().appendSeparator(":").
			appendSeconds().toFormatter();
	
	public static PeriodFormatter MMSSFormater = new PeriodFormatterBuilder().
			printZeroAlways().minimumPrintedDigits(2).
			appendMinutes().appendSeparator(":").
			appendSeconds().toFormatter();
	
	DateTimeZone zone = DateTimeZone.forID("America/New_York");
	Chronology gregorianJuian = GJChronology.getInstance(zone);

	public abstract boolean addEventStatus(String serverId, String eventId, String status,
			DateTime time, String mapId);

	public abstract String getEventStatus(String eventId);

	public abstract DateTime getEventTime(String eventId);
}