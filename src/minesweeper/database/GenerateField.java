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
    
    /**
     * method generate total random field based on objects atributes
     * @return field with random mines 
     */
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
     * @param clicked is the first click
     * @return random table[y][x]
     */
    
    boolean[][] getSpecifiedRandomTable(minesweeper.players.Click clicked)
    {
        if (!generatedB[clicked.getY()][clicked.getX()])
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
        pX = clicked.getX() - pX;
        pY = clicked.getY() - pY;
        return moveArray(generatedB, pX, pY);
    }
    
    /**
     * this method return field, with largest possible array on place, you clicked
     * @param clicked {x, y} click position
     * @return random field of flags and blank spaces
     */
    public boolean[][] getRandomTableWithSpace(minesweeper.players.Click clicked)
    {
        boolean[][] possi = new boolean[mY][mX]; //0 are 0, others are 1
        for (int y = 0; y < mY; y++)
        {
            for (int x = 0; x < mX; x++)
            {
                if (generatedB[y][x])
                {
                    possi[y][x] = true; //0 0
                    possi[y][(x+1)%mX] = true; //1 0
                    possi[(y-1+mY)%mY][(x+1)%mX] = true; // 1 -1
                    possi[(y-1+mY)%mY][x] = true; //0 -1
                    possi[(y-1+mY)%mY][(x-1+mX)%mX] = true; //-1 -1
                    possi[y][(x-1+mX)%mX] = true; //-1 0
                    possi[(y+1)%mY][(x-1+mX)%mX] = true; //-1 1
                    possi[(y+1)%mY][x] = true; //0 1
                    possi[(y+1)%mY][(x+1)%mX] = true; //1 1
                }
            }
        }
        //done, everything excepr field with value 0 is 1 now
        int[][] flatPattern = new int[mY][mX]; //types of zero flat
        int type = 1;
        for (int y = 0; y < mY; y++)
        {
            for (int x = 0; x < mX; x++)
            {
                if (possi[y][x])
                {
                    continue;
                }
                flatPattern[y][x] = type;
                
                if (flatPattern[y][(x+1)%mX] != 0)
                {mergeIt(flatPattern[y][(x+1)%mX], flatPattern, x, y);}
                else if(flatPattern[(y-1+mY)%mY][(x+1)%mX] != 0)
                {mergeIt(flatPattern[(y-1+mY)%mY][(x+1)%mX], flatPattern, x, y);}
                else if(flatPattern[(y-1+mY)%mY][x] != 0)
                {mergeIt(flatPattern[(y-1+mY)%mY][x], flatPattern, x, y);}
                else if(flatPattern[(y-1+mY)%mY][(x-1+mX)%mX] != 0)
                {mergeIt(flatPattern[(y-1+mY)%mY][(x-1+mX)%mX], flatPattern, x, y);}
                else if(flatPattern[y][(x-1+mX)%mX] != 0)
                {mergeIt(flatPattern[y][(x-1+mX)%mX], flatPattern, x, y);}
                else if(flatPattern[(y+1)%mY][(x-1+mX)%mX] != 0)
                {mergeIt(flatPattern[(y+1)%mY][(x-1+mX)%mX], flatPattern, x, y);}
                else if(flatPattern[(y+1)%mY][x] != 0)
                {mergeIt(flatPattern[(y+1)%mY][x], flatPattern, x, y);}
                else if(flatPattern[(y+1)%mY][(x+1)%mX] != 0)
                {mergeIt(flatPattern[(y+1)%mY][(x+1)%mX], flatPattern, x, y);}
                type++;
            }
        }
        
        //found largest field
        
        
        return null;
    }
    
    /**
     * moves specified array by X and Y
     * 
     * @param arrayToMove boolean[y][x] array, you want to move
     * @param xMove move x
     * @param yMove move y
     * @return moved array
     */
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

    private void mergeIt(int known, int[][] flatPattern, int x, int y) 
    {
        flatPattern[y][x] = known;
        
        if (flatPattern[y][(x+1)%mX] != 0 && flatPattern[y][(x+1)%mX] != known)
        {mergeIt(known, flatPattern, (x+1)%mX, y);}
        
        if(flatPattern[(y-1+mY)%mY][(x+1)%mX] != 0 && flatPattern[(y-1+mY)%mY][(x+1)%mX] != known)
        {mergeIt(known, flatPattern, (x+1)%mX, (y-1+mY));}
        
        if(flatPattern[(y-1+mY)%mY][x] != 0 && flatPattern[(y-1+mY)%mY][x] != known)
        {mergeIt(known, flatPattern, x, (y-1+mY));}
        
        if(flatPattern[(y-1+mY)%mY][(x-1+mX)%mX] != 0 && flatPattern[(y-1+mY)%mY][(x-1+mX)%mX] != known)
        {mergeIt(known, flatPattern, (x-1+mX)%mX, (y-1+mY));}
        
        if(flatPattern[y][(x-1+mX)%mX] != 0 && flatPattern[y][(x-1+mX)%mX] != known)
        {mergeIt(known, flatPattern, (x-1+mX)%mX, y);}
        
        if(flatPattern[(y+1)%mY][(x-1+mX)%mX] != 0 && flatPattern[(y+1)%mY][(x-1+mX)%mX] != known)
        {mergeIt(known, flatPattern, (x-1+mX)%mX, (y+1)%mY);}
        
        if(flatPattern[(y+1)%mY][x] != 0 && flatPattern[(y+1)%mY][x] != known)
        {mergeIt(known, flatPattern, x, (y+1)%mY);}
        
        if(flatPattern[(y+1)%mY][(x+1)%mX] != 0 && flatPattern[(y+1)%mY][(x+1)%mX] != known)
        {mergeIt(known, flatPattern, (x+1)%mX, (y+1)%mY);}
    }

    /**
     * for developers
     * @param pole what to write
     */
    private void vypisPole (int[][] pole)
    {
        for (int y = 0; y < mY; y++)
        {
            for (int x = 0; x < mX; x++)
            {
                System.out.print(pole[y][x] + " ");
            }
            System.out.println();
        }
    }
    /**
     * for developers
     * @param pole what to write 
     */
    private void vypisPole (boolean[][] pole)
    {
        for (int y = 0; y < mY; y++)
        {
            for (int x = 0; x < mX; x++)
            {
                if (pole[y][x])
                {
                    System.out.print("1");
                }
                else
                {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
    
    
}
