package b314.tictactoe;

import b314.tictactoe.genv.Game;
import b314.tictactoe.tui.GameTUI;
import b314.tictactoe.tui.GridTUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for MediumBotPlayer class
 */
public class MediumBotPlayerTest {
    @Test
    void rowWinMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[0].makeMove(0, 1);
        game.getPlayers()[0].makeMove(0, 2);
        game.getPlayers()[1].makeMove(2, 0);
        game.getPlayers()[1].makeMove(2, 1);

        // Making win move
        game.getPlayers()[1].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[1].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[1].getGrid().getCell(2, 2).getOccupantPlayer(),
                     game.getPlayers()[1]);
    }

    @Test
    void columnWinMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[0].makeMove(0, 0);
        game.getPlayers()[0].makeMove(1, 0);
        game.getPlayers()[0].makeMove(1, 2);
        game.getPlayers()[0].makeMove(2, 2);
        game.getPlayers()[1].makeMove(0, 1);
        game.getPlayers()[1].makeMove(1, 1);

        // Making win move
        game.getPlayers()[1].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[1].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[1].getGrid().getCell(2, 1).getOccupantPlayer(),
                game.getPlayers()[1]);
    }

    @Test
    void mainDiagonalWinMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[0].makeMove(0, 1);
        game.getPlayers()[0].makeMove(0, 2);
        game.getPlayers()[0].makeMove(1, 2);
        game.getPlayers()[1].makeMove(0, 0);
        game.getPlayers()[1].makeMove(2, 2);

        // Making win move
        game.getPlayers()[1].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[1].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[1].getGrid().getCell(1, 1).getOccupantPlayer(),
                game.getPlayers()[1]);
    }

    @Test
    void additionalDiagonalWinMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[0].makeMove(1, 0);
        game.getPlayers()[0].makeMove(2, 1);
        game.getPlayers()[1].makeMove(2, 0);
        game.getPlayers()[1].makeMove(1, 1);

        // Making win move
        game.getPlayers()[1].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[1].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[1].getGrid().getCell(0, 2).getOccupantPlayer(),
                game.getPlayers()[1]);
    }

    @Test
    void rowDenyMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[1].makeMove(0, 1);
        game.getPlayers()[1].makeMove(0, 2);
        game.getPlayers()[0].makeMove(2, 0);
        game.getPlayers()[0].makeMove(2, 1);

        // Making win move
        game.getPlayers()[0].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[0].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[0].getGrid().getCell(2, 2).getOccupantPlayer(),
                game.getPlayers()[0]);
    }

    @Test
    void columnDenyMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[1].makeMove(0, 0);
        game.getPlayers()[1].makeMove(1, 0);
        game.getPlayers()[1].makeMove(1, 2);
        game.getPlayers()[1].makeMove(2, 2);
        game.getPlayers()[0].makeMove(0, 1);
        game.getPlayers()[0].makeMove(1, 1);

        // Making win move
        game.getPlayers()[0].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[0].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[0].getGrid().getCell(2, 1).getOccupantPlayer(),
                game.getPlayers()[0]);
    }

    @Test
    void mainDiagonalDenyMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[1].makeMove(0, 1);
        game.getPlayers()[1].makeMove(0, 2);
        game.getPlayers()[1].makeMove(1, 2);
        game.getPlayers()[0].makeMove(0, 0);
        game.getPlayers()[0].makeMove(2, 2);

        // Making win move
        game.getPlayers()[0].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[0].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[0].getGrid().getCell(1, 1).getOccupantPlayer(),
                game.getPlayers()[0]);
    }

    @Test
    void additionalDiagonalDenyMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[1].makeMove(1, 0);
        game.getPlayers()[1].makeMove(2, 1);
        game.getPlayers()[0].makeMove(2, 0);
        game.getPlayers()[0].makeMove(1, 1);

        // Making win move
        game.getPlayers()[0].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[0].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[0].getGrid().getCell(0, 2).getOccupantPlayer(),
                game.getPlayers()[0]);
    }

    @Test
    void interestingAdditionalDiagonalDenyMoveTest() {
        // Creating game
        Game game = Game.create2User3x3(GameTUI.PlayerType.MEDIUM, GameTUI.PlayerType.MEDIUM);

        // Making moves as intended
        game.getPlayers()[1].makeMove(0, 0);
        game.getPlayers()[1].makeMove(1, 1);
        game.getPlayers()[1].makeMove(2, 0);
        game.getPlayers()[0].makeMove(0, 1);
        game.getPlayers()[0].makeMove(1, 0);
        game.getPlayers()[0].makeMove(2, 2);

        // Making win move
        game.getPlayers()[0].makeMove();

        // Printing
        GridTUI.printGrid(game.getPlayers()[0].getGrid());

        // Asserting
        assertEquals(game.getPlayers()[0].getGrid().getCell(0, 2).getOccupantPlayer(),
                     game.getPlayers()[0]);
    }
}
