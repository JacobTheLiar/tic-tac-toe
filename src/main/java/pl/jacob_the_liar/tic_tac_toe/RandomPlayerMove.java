package pl.jacob_the_liar.tic_tac_toe;


import pl.jacob_the_liar.tic_tac_toe.core.TicTacToe;
import pl.jacob_the_liar.tic_tac_toe.player_move.PlayerMove;

import java.util.Random;


public class RandomPlayerMove implements PlayerMove{
    
    private TicTacToe game;
    
    
    @Override
    public int getMove(){
        int result;
        Random rnd = new Random();
        do {
            result = rnd.nextInt(9);
        } while (!game.isAvailableMove(result));
        
        return result;
    }
    
    
    @Override
    public void setGame(TicTacToe game){
        this.game = game;
    }
}
