/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.boards;

/**
 * any output, has access to database
 * @author Honza
 */
public interface IBoard 
{
    /**
    * show to player his progress
    */
    
    public void show();
    /**
    * show to programmer whole field
    */
    public void showAll();
    
    /**
    * show whole field after defeat
     * @param whereLost sends click that shows where was game lost
    */
    public void showLost(minesweeper.players.Click whereLost);
    
}
