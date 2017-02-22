/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.database;

import java.util.Random;

/**
 * class of all generating fields
 * @author Honza
 */
class GenerateField 
{
    private final int mX;
    private final int mY;
    private final int quant;
    private final boolean[][] generatedB;
            
    /**
     * totally random generate field (width, height, mines)
     * @param width defines width of field (x)
     * @param height defines height of field (y)
     * @param howMany defines number of mines
     */
    
    GenerateField(int width, int height, int howMany)
    {
        mX = width;
        mY = height;
        quant = howMany;
        generatedB = generate();
    }
    
    private boolean[][] generate()
    {
        Random random = new Random();
        boolean[] helpField = new boolean[mX * mY];
        for (int i = 0; i < quant; i++)
        {
            int randNumb = random.nextInt(mX*mY - i);
            int under = 0;
            for (int j = 0; j <= randNumb + under; j++)
            {
                if (helpField[j])
                {
                    under++;
                }
            }
            helpField[under+randNumb] = true;
        }
        boolean[][] finalField = new boolean[mY][mX];
        for (int y = 0; y < mY; y++)
        {
            for (int x = 0; x < mX; x++)
            {
                finalField[y][x] = helpField[y*mX+x];
            }
        }
        return finalField;
    }
    
    /**
     * Returns unchanged random table, doesnt matter, where you clicked
     * @return random table[y][x]; 
    */
    
    boolean[][] getRandomTable()
    {
        return generatedB;
    }
    
    /**
     * This method returns field with free space on place where you clicked
     * Has some mistake, if you are clever like Svoboda, you can find where is very probably one mine
     * maybe, iam gonna fix it later by using Random
     * @param clicked is two space field {x, y}, pointing where must be free space
     * @return random table[y][x]
     */
    
    boolean[][] getSpecifiedRandomTable(int[] clicked)
    {
        if (!generatedB[clicked[1]][clicked[0]])
        {
            return generatedB;
        }
        int pX = 0;
        int pY = 0;
        boolean doMore = true;
        
        for (int y = 0; y < generatedB.length; y++)
        {
            for (int x = 0; x < generatedB[y].length; x++)
            {
                if (!generatedB[y][x])
                {
                    doMore = false;
                    pX = x;
                    pY = y;
                    break;
                }
            }
            if (!doMore)
            {
                break;
            }
        }
        
        pX = clicked[0] - pX;
        pY = clicked[1] - pY;
        
        
        return moveArray(generatedB, pX, pY);
    }
    
    /**
     * this method return field, with largest possible array on place, you clicked
     * @param clicked {x, y} click position
     * @return random field of flags and blank spaces
     */
    
    public boolean[][] getRandomTableWithSpace(int[] clicked)
    {
        int itsY = generatedB.length;
        int itsX = generatedB[0].length; 
        
        boolean[][] possi = new boolean[itsY][itsX];
        for (int y = 0; y < itsY; y++)
        {
            for (int x = 0; x < itsX; x++)
            {
                if (generatedB[y][x])
                {
                    possi[y][x] = true;
                    if (x-1 >= 0)
                    {
                        possi[y][x-1] = true;
                        if (y-1 >= 0)
                        {
                            possi[y-1][x-1] = true;
                        }
                        if (y+1 < itsY)
                        {
                            possi[y+1][x-1] = true;
                        }
                    }
                    if (x+1 < itsX)
                    {
                        possi[y][x+1] = true;
                        if (y-1 >= 0)
                        {
                            possi[y-1][x+1] = true;
                        }
                        if (y+1 < itsY)
                        {
                            possi[y+1][x+1] = true;
                        }
                    }
                    if (y-1 >= 0)
                    {
                        possi[y-1][x] = true;
                    }
                    if (y+1 < itsY)
                    {
                        possi[y+1][x] = true;
                    }
                }
            }
        }
        
        for (int y = 0; y < itsY; y++)
        {
            for (int x = 0; x < itsX; x++)
            {
                
                
                
            }
        }
        
        
        return null;
    }
    
    
        
    
    private boolean[][] moveArray (boolean[][] arrayToMove, int xMove, int yMove)
    {
        int limitY = arrayToMove.length;        
        int limitX = arrayToMove[0].length;
        boolean[][] movedArray = new boolean[limitY][limitX];
        
        for (int y = 0; y < limitY; y++)
        {
            for (int x = 0; x < limitX; x++)
            {
                movedArray[(y+yMove+limitY)%limitY][(x+xMove+limitX)%limitX] = arrayToMove[y][x];
            }
        }
        return movedArray;
    }
    
    
    
    
}
