package mylittlemozart.factories;

/**
 * This interface sets a contract for the classes that return the different MidiEvent factories.
 */
public interface MidiEventFactoryAbstract {
	MidiEventFactory createFactory();
}
