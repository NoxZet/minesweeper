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
    
    boolean play()
    {
        IDatabase database = new DatabaseStandard();
        IBoard board = new BoardAscii(database);
        IPlayer player = new HumanAscii();
        
        return false;
    }
    
}
