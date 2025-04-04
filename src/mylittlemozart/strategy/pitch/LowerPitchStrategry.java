package mylittlemozart.strategy.pitch;

public class LowerPitchStrategry implements PitchStrategy{

	/**
	 * This method decreases the pitch and duration of the notes by 2 semitones.
	 * @param note: The note that is to be decreased.
	 * @return The note that is returned at a lower pitch.
	 */
	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}

}
