/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.players;

import java.util.Scanner;

/**
 * player playing on ascii table with Scanner IO
 * @author Honza
 */
public class HumanAscii implements IPlayer 
{
    protected Scanner sc;
    
    public HumanAscii ()
    {
        sc = new Scanner(System.in, "Windows-1250");
    }
    
    
    
    @Override
    public Click playTurn() 
    {
        
        return null;
    }

    @Override
    public void happened()
    {
        
    }
    
}
