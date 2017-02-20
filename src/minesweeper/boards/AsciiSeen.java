/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.boards;

import minesweeper.database.IDatabase;

/**
 * normal output using ASCII
 * @author Honza
 */
public class AsciiSeen implements SeenBoard
{
    IDatabase papa;
    private final char flagCh;
    private final char spaceCh;
    private final char mineCh;
    private final char boomCh;
    private final char freeSeenCh;
    
    public AsciiSeen(IDatabase bToPlay) 
    {
        papa = bToPlay;
        flagCh = 'I';
        spaceCh = ' ';
        mineCh = '+';
        boomCh = '*';
        freeSeenCh = '0';
    }

    @Override
    public void show() 
    {
        
    }

    @Override
    public void showAll() 
    {
        
    }

    @Override
    public void showAll(int[] param) 
    {
        
    }
    
}
