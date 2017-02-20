/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.main;

/**
 *
 * @author Honza
 */
public class MainLogic 
{
    
    boolean play()
    {
        minesweeper.database.DatabaseInterface bToPlay = new minesweeper.database.NormalGame();
        minesweeper.boards.SeenBoard bToSee = new minesweeper.boards.AsciiSeen(bToPlay);
        minesweeper.players.Player player = new minesweeper.players.HumanH();
        
        
        
        
        return false;
    }
    
}
