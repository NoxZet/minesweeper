/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 * no matter what is it, you send here input
 * @author Honza
 */
public interface DatabaseInterface 
{
    /**
    * send info, where did player go
     * @param where [x,y] where 
    */
    public void clicked(int[] where);
}