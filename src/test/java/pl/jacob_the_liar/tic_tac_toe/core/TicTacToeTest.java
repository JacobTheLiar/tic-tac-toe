package pl.jacob_the_liar.tic_tac_toe.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeTest {

    private TicTacToe game;

    @Before
    public void setUp() {
        game = new TicTacToe();
        game.startNewGame();
    }


    @Test
    public void shouldBeCircleOn0CrossOn8() {
        game.setMove(0);
        game.setMove(8);

        assertEquals("kółko powinno być na pozycji 0", Player.CIRCLE, game.getFieldStatus(0));
        assertEquals("krzyżyk powinien być na pozycji 8", Player.CROSS, game.getFieldStatus(8));
        for (int i=1; i<8; i++)
            assertEquals("pole "+i+" powinno być puste", Player.NONE, game.getFieldStatus(i));
        assertFalse("nie powinien być koniec gry", game.isEndGame());


    }

    @Test
    public void shouldBeDraw() {
        game.setMove(0);
        game.setMove(1);
        game.setMove(2);
        game.setMove(4);
        game.setMove(3);
        game.setMove(5);
        game.setMove(7);
        game.setMove(6);
        game.setMove(8);

        assertTrue("powinien być koniec gry", game.isEndGame());
        assertEquals("powinien być remis", 1, game.getDraws());
    }

    @Test
    public void shouldWinCross() {
        game.setMove(0);
        game.setMove(1);
        game.setMove(2);
        game.setMove(4);
        game.setMove(8);
        game.setMove(7);

        assertTrue("powinien być koniec gry", game.isEndGame());
        assertEquals("powinien wygrać krzyżyk", 1, game.getCrossWins());
    }

    @Test
    public void shouldWinCircle() {
        game.setMove(0);
        game.setMove(1);
        game.setMove(4);
        game.setMove(6);
        game.setMove(8);

        assertTrue("powinien być koniec gry", game.isEndGame());
        assertEquals("powininno wygrać kółko", 1, game.getCircleWins());
    }


    @Test
    public void shouldFieldUnChangedAfterMove() {
        game.setMove(5);
        game.setMove(5);

        assertFalse("nie powinien być koniec gry", game.isEndGame());
        assertEquals("na pozycji 5 powinno być kółko", Player.CIRCLE, game.getFieldStatus(5));

    }
}