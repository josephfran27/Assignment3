package mylittlemozart.factories;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract{

	/**
	 * This method creates a new instance of StaccatoMidiEventFactory by overriding the createFactory method.
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}

}
