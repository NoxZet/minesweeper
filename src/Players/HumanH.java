/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Players;

import java.util.Scanner;

/**
 * player playing on ascii table with Scanner IO
 * @author Honza
 */
public class HumanH implements Player 
{
    protected Scanner sc;
    
    public HumanH ()
    {
        sc = new Scanner(System.in, "Windows-1250");
    }
    
    
    
    @Override
    public int[] playTurn() 
    {
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] pole = new int[2];
        pole[0] = x;
        pole[1] = y;
        return pole;
    }

    @Override
    public void happened()
    {
        
    }
    
}
