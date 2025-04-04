package mylittlemozart.strategy.pitch;

public class HigherPitchStrategy implements PitchStrategy{

	/**
	 * This method increases the duration and pitch of the notes by 2 semitones.
	 * @param note: The note that is to be raised.
	 * @return The note that is returned at a higher pitch.
	 */
	@Override
	public int modifyPitch(int note) {
		return note + 2;
	}

}
