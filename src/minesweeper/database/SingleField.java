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
    boolean[] neighbors;
    
    /**
     * @param type true for mine, false for empty space
     * @param neighbours eight booleans for neighbors (begins at right, ends at right down)
     */
    SingleField(boolean type, boolean[] neighbors)
    {
        this.neighbors = neighbors;
    }

    /**
     * @return has valid field on right
     */
    public boolean hasField(int field)
    {
    	return neighbors[field];
    }

    /**
     * @return has valid field on right
     */
    public boolean hasFieldRight()
    {
    	return hasField(0);
    }
    
}
