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
        Database.DatabaseInterface bToPlay = new Database.NormalGame();
        Boards.SeenBoard bToSee = new Boards.AsciiSeen(bToPlay);
        Players.Player player = new Players.HumanH();
        
        
        
        
        return false;
    }
    
}
