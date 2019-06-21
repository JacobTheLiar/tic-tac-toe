package pl.jacob_the_liar.tic_tac_toe.console;


import pl.jacob_the_liar.tic_tac_toe.core.TicTacToe;

import static pl.jacob_the_liar.tic_tac_toe.console.BoardPrinter.printBoard;
import static pl.jacob_the_liar.tic_tac_toe.console.Input.getInt;


public class ConsoleGame {

    private TicTacToe game;


    public void start() {
        game = new TicTacToe();
        do {
            gameLoop();
        } while(!endGame());
    }


    private void gameLoop() {
        game.startNewGame();
        do {
            printBoard(game);
            int choice = getChoice();
            game.setMove(choice);
        } while (!game.isEndGame());
        printBoard(game);
    }




    private boolean endGame() {
        int choice;
        do {
            choice = getInt();
        } while(!(0<=choice && choice<=1));
        return choice == 0;
    }


    private int getChoice(){
        int choice;
        do {
            choice = getInt();
        } while(!correctChoice(choice) || !game.isAvailableMove(choice));
        return choice;
    }


    private boolean correctChoice(int choice) {
        return 0<=choice && choice<9;
    }
}
