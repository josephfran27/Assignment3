package mylittlemozart.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class ElectricBassGuitarStrategy implements InstrumentStrategy{

	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 33, 0);
		track.add(new MidiEvent(message, 0));
	}

}
