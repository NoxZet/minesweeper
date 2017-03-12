/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.database;

/**
 * just a normal game
 * @author Honza
 */
public class DatabaseStandard implements IDatabase
{
    
    private boolean firstClick = true;
    private int height, width, mines;
    private SingleField[][] database;
    private boolean lost = false;
    
    public DatabaseStandard()
    {
        
    }
    
    public void setNumbers(int height, int width, int mines)
    {
        this.height = height;
        this.width = width;
        this.mines = mines;
    }
    
    private boolean[][] generate(int[] where)
    {
        GenerateField field = new GenerateField(width, height, mines);
        return field.getSpecifiedRandomTable(where);
    }
    
    private SingleField[][] generateAndFetch(int[] where)
    {
        boolean[][] field = generate(where);
        SingleField[][] database = new SingleField[height][width];
        boolean hasRight, hasTop, hasLeft, hasBottom;
        for (int y = 0, x; y < height; y++)
        {
            for (x = 0; x < width; x++)
            {
                hasRight = x != (width-1);
                hasTop = y != 0;
                hasLeft = x != 0;
                hasBottom = y != (height-1);
                database[y][x] = new SingleField(field[y][x], new boolean[]{
                        hasRight, (hasRight && hasTop), hasTop, (hasTop && hasLeft), hasLeft, (hasLeft && hasBottom), hasBottom, (hasBottom && hasRight)
                });
            }
        }
        return database;
    }
    
    @Override
    public boolean addMove(minesweeper.players.Click where) 
    {
        /*if (!lost)
        {
            if (firstClick)
            {
                database = generateAndFetch(where);
                firstClick = false;
            }
            if (!database[where[0]][where[1]].hasFlag)
            {
                if (database[where[0]][where[1]].type)
                    lost = true;
            }
        }*/
        return false;
    }

    @Override
    public boolean isWon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
