package mylittlemozart.factories;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * This method creates a new instance of LegatoMidiEventFactoryby by overriding the createFactory method.
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
