/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper.players;

import java.util.Scanner;
import minesweeper.boards.IBoard;

/**
 * player playing on ascii table with Scanner IO
 * @author Honza
 */
public class HumanAscii implements IPlayer 
{
    protected Scanner sc;
    private IBoard board;
    
    public HumanAscii ()
    {
        sc = new Scanner(System.in, "Windows-1250");
    }
    
    @Override
    public Click playTurn()
    {
        int mX = enterByScanner("Zadejte pozici X: ");
        int mY = enterByScanner("Zadejte pozici Y: ");
        return new Click(mX, mY, true);
    }

    private int enterByScanner(String message)
    {
        int result = -1;
        boolean succesful = false;
        String s = "";
        do
        {
            try
            {
                System.out.println(message);
                s = sc.nextLine();
                result = Integer.parseInt(s);
                succesful = true;
            }
            catch (NumberFormatException vyjimka)
            {
                System.out.println(s + " je neplatný vstup, zkus to znovu");
            }
        }
        while(!succesful);
        return result;
    }
    
    @Override
    public void happened()
    {
        board.show();
    }

    @Override
    public void setBoard(IBoard tableForPlayer)
    {
        board = tableForPlayer;
    }
    
}
