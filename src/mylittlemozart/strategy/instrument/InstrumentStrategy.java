package mylittlemozart.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

public interface InstrumentStrategy {
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException;
}
