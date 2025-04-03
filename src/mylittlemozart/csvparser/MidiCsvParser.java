package mylittlemozart.csvparser;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.*;

import mylittlemozart.model.MidiEventData;

public class MidiCsvParser {
	public static List<MidiEventData> parseCsv(String filename) throws IOException {
		List<MidiEventData> events = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				
				//read the CSV file according to the format: startEndTick(int), Note on off(string), channel(int), note(int), velocity , instrument(int)
				int startEndTick = Integer.parseInt(data[0].trim());
				String noteType = data[1].trim();
				int channel = Integer.parseInt(data[2].trim());
				int note = Integer.parseInt(data[3].trim());
				//get the right value for NOTE_ON or NOTE_OFF using the ShortMessage class
				int noteOnOff;
				if (noteType.contains("on")) {
					noteOnOff = ShortMessage.NOTE_ON;
				} else {
					noteOnOff = ShortMessage.NOTE_OFF;
				}
				int velocity = Integer.parseInt(data[4].trim());
				int instrument = Integer.parseInt(data[5].trim());
				
				//adds the events that were just read to the events list
				events.add(new MidiEventData(startEndTick, velocity, note, channel, instrument, noteOnOff));					
				
			}
		}
		return events;
	}

}
