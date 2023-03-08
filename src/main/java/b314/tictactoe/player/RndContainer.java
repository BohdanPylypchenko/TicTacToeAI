package b314.tictactoe.player;

import java.util.Random;

/**
 * Class to contain common Random instance
 * (needed for easy and medium bot)
 */
final class RndContainer {
    // Single random instance to use in whole program
    private static final Random rnd = new Random();

    public static Random getRnd() {
        return rnd;
    }
}
