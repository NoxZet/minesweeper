/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.database;

/**
 * no matter what is it, you send here input
 * @author Honza
 */
public interface IDatabase 
{
    /**
     * This method sends data to database, where move is written 
     * and returns boolean if you lost game by this click
     * 
     * @param clicked sends last clicked object
     * @return false if game is lost
     */
    public boolean addMove(minesweeper.players.Click clicked);
    public boolean isWon();
    
}
