package mylittlemozart.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class TrumpetStrategy implements InstrumentStrategy{

	/**
	 * This method creates a short message  and program change command that gives information
	 * on which channel and instrument to use.
	 * @param tick: The track where the instrument change should take place
	 * @param channel: The channel to apply the instrument to
	 * @throws InvalidMidiDataException: Error if the instrument change message can't be created/sent correctly
	 */
	@Override
	public void applyInstrument(Track track, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
		track.add(new MidiEvent(message, 0));
		
	}

}
