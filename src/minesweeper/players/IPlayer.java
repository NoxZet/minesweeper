/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.players;

/**
 * any player interface
 * @author Honza
 */
public interface IPlayer 
{
    /**
     * @return last time played position
     */
    public Click playTurn();
    public void happened();
}
