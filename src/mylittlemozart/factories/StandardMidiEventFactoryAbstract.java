package mylittlemozart.factories;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * This method creates a new instance of StandardMidiEventFactory by overriding the createFactory method.
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}
