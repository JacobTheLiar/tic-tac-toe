/*
 * Copyright (c) 2019.
 */

package pl.jacob_the_liar.tic_tac_toe.player_move;


import pl.jacob_the_liar.tic_tac_toe.core.TicTacToe;


public interface PlayerMove{
    
    int getMove();
    void setGame(TicTacToe game);
    
}
