package mylittlemozart.strategy.pitch;

/**
 * This interface sets a contract for how the different PitchStrategy classes are to be implemented.
 */
public interface PitchStrategy {
	int modifyPitch(int note);

}
