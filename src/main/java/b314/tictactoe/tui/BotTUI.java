package b314.tictactoe.tui;

/*
 * TUI for bots
 */
public final class BotTUI {
    // bot move message
    private static final String BOT_MSG = "Making move level \"%s\"\n";

    public static void printEasyBotMakeMoveMessage() {
        System.out.printf(BOT_MSG, "easy");
    }

    public static void printMediumBotMakeMoveMessage() {
        System.out.printf(BOT_MSG, "medium");
    }

    public static void printHardBotMakeMoveMessage() {
        System.out.printf(BOT_MSG, "hard");
    }
}
