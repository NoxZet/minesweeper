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
class SingleField 
{
    boolean[] neighbours;
    
    /**
     * @param type true for mine, false for empty space
     * @param neighbours eight booleans for neighbors (begins at right, ends at right down)
     */
    SingleField(boolean type, boolean[] neighbours)
    {
        this.neighbours = neighbours;
    }
    
    /**
     * 
     */
    
}
