package pl.jacob_the_liar.tic_tac_toe.console;


import pl.jacob_the_liar.tic_tac_toe.core.Player;
import pl.jacob_the_liar.tic_tac_toe.core.TicTacToe;
import pl.jacob_the_liar.tic_tac_toe.player_move.PlayerMove;

import static pl.jacob_the_liar.tic_tac_toe.console.BoardPrinter.printBoard;
import static pl.jacob_the_liar.tic_tac_toe.console.Input.getInt;


public class ConsoleGame {

    private TicTacToe game;
    
    private PlayerMove circlePlayer;
    private PlayerMove crossPlayer;
    
    
    public ConsoleGame(PlayerMove circlePlayer, PlayerMove crossPlayer){
        this.circlePlayer = circlePlayer;
        this.crossPlayer = crossPlayer;
    }
    
    
    public void start() {
        game = new TicTacToe();
        circlePlayer.setGame(game);
        crossPlayer.setGame(game);
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
            if (game.getCurrentPlayer()== Player.CIRCLE) {
                choice = circlePlayer.getMove();
            } else {
                choice = crossPlayer.getMove();
            }
        } while(!correctChoice(choice) || !game.isAvailableMove(choice));
        return choice;
    }


    private boolean correctChoice(int choice) {
        return 0<=choice && choice<9;
    }
}
