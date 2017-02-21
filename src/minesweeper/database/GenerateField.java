/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.database;

import java.util.Random;

/**
 * generating fields
 * @author Honza
 */
public class GenerateField 
{
    private int mX;
    private int mY;
    private int quant;
    private boolean[][] generatedB;
            
    GenerateField(int width, int height, int howMany)
    {
        mX = width;
        mY = height;
        quant = howMany;
        generatedB = generate();
    }
    
    boolean[][] generate()
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
    
    
    
    
    
}
