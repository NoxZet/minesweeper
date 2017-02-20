/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.database;

/**
 * one piece of field
 * @author Honza
 */
class OnePlace 
{
    boolean[] neighbours;
    
    /**
     * dssd
     * @param type true for mine, false for empty space
     * @param neighbours eight booleans for neighbours (begins at right, ends at right down)
     */
    OnePlace(boolean type, boolean[] neighbours)
    {
        this.neighbours = neighbours;
        
        
    }
    
    
    
}
