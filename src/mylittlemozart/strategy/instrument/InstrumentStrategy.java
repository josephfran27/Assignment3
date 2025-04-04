package mylittlemozart.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

/**
 * This interface sets a contract for how the different InstrumentStrategy classes are to be implemented.
 */
public interface InstrumentStrategy {
	void applyInstrument(Track track, int channel) throws InvalidMidiDataException;
}
