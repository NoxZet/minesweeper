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
    boolean type;
    boolean revealed;
    boolean hasFlag;
    
    /**
     * @param type true for mine, false for empty space
     * @param neighbours eight booleans for neighbors (begins at right, ends at right down)
     */
    SingleField(boolean type, boolean[] neighbors)
    {
        this.neighbors = neighbors;
        this.type = type;
        this.revealed = false;
        this.hasFlag = false;
    }

    /**
     * @return has valid field on right
     */
    public boolean hasField(int field)
    {
    	return neighbors[field];
    }

    public boolean hasFieldRight()
    {
    	return hasField(0);
    }
    
    public boolean hasFieldUp()
    {
    	return hasField(2);
    }
    
    public boolean hasFieldLeft()
    {
    	return hasField(4);
    }
    
    public boolean hasFieldDown()
    {
    	return hasField(6);
    }
    
}
