/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.main;

import minesweeper.boards.BoardAscii;
import minesweeper.boards.IBoard;
import minesweeper.database.DatabaseStandard;
import minesweeper.database.IDatabase;
import minesweeper.players.HumanAscii;
import minesweeper.players.IPlayer;

/**
 *
 * @author Honza
 */
public class MainLogic 
{
    IDatabase database;
    IBoard board;
    IPlayer player;
    
    MainLogic()
    {
        database = new DatabaseStandard();
        board = new BoardAscii(database);
        player = new HumanAscii();
    }
    
    
    boolean play()
    {
        
        boolean doMore = true;
        while(doMore)
        {
            doMore = oneTurn();
        }
        return database.isWon();
    }
    
    private boolean oneTurn()
    {
        minesweeper.players.Click clicked = player.playTurn();
        boolean survived = database.addMove(clicked);
        player.happened();
        return survived;
    }
    
}
