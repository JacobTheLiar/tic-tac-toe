package pl.jacob_the_liar.tic_tac_toe.player_move;



import pl.jacob_the_liar.tic_tac_toe.core.TicTacToe;

import static pl.jacob_the_liar.tic_tac_toe.console.Input.getInt;


public class HumanPlayerMove implements PlayerMove{

    private TicTacToe game;
    
    
    @Override
    public int getMove(){
        return getChoice();
    }
    
    
    @Override
    public void setGame(TicTacToe game){
        this.game = game;
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
