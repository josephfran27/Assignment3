package mylittlemozart.strategy.pitch;

public class LowerPitchStrategry implements PitchStrategy{

	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}

}
