package mylittlemozart.factories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;


public class LegatoMidiEventFactory implements MidiEventFactory {

	/**
	 * This method makes a NOTE_ON MIDI event at the given tick. It uses a ShortMessage to represent that
	 * the note is on with the specified members.
	 * @param tick: The time the note should start.
	 * @param note: The note number.
	 * @param velocity: The volume of the note.
	 * @param channel: The MIDI channel
	 * @return: a MidiEvent
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
		return new MidiEvent(message, tick);
	}

	/**
	 * This method makes a NOTE_OFF MIDI event at a later tick. It adds 80 ticks to conform to
	 * the legato style.
	 * @param tick: The time the note should start.
	 * @param note: The note number to stop.
	 * @param channel: The MIDI channel
	 * @return: a MidiEvent returned with (tick + 80)
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		ShortMessage message = new ShortMessage();
		message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
		return new MidiEvent(message, tick + 80);
	}

}
