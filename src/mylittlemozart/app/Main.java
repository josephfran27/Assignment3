package mylittlemozart.app;

import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import mylittlemozart.csvparser.MidiCsvParser;
import mylittlemozart.model.MidiEventData;
import mylittlemozart.factories.*;
import mylittlemozart.strategy.instrument.*;
import mylittlemozart.strategy.pitch.*;

public class Main {

	public static void main(String[] args) {
		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./files/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			MidiEventFactoryAbstract factoryAbstract = new StandardMidiEventFactoryAbstract();
			//MidiEventFactoryAbstract factoryAbstract = new LegatoMidiEventFactoryAbstract();
			//MidiEventFactoryAbstract factoryAbstract = new StaccatoMidiEventFactoryAbstract();
			
			MidiEventFactory factory = factoryAbstract.createFactory();
			
			//Choosing an instrument strategy
			InstrumentStrategy instrumentStrategy = new ElectricBassGuitarStrategy();
			instrumentStrategy.applyInstrument(track, 0);
			instrumentStrategy = new TrumpetStrategy();
			instrumentStrategy.applyInstrument(track, 1);
			
			//Choosing a pitch strategy
			PitchStrategy pitchStrategy = new HigherPitchStrategy();
			
			for (MidiEventData event : midiEvents) {
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				//call for higher pitch
				modifiedNote = pitchStrategy.modifyPitch(modifiedNote);
				
				if (event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				} else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}
			
			//Playing the sequence
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			while (sequencer.isRunning() | sequencer.isOpen()) {
				Thread.sleep(100);
			}
			Thread.sleep(500);
			sequencer.close();
			
			
		} catch (Exception e){
			e.printStackTrace();
			
		}
		

	}

}
