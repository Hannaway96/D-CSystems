/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical1;

public class SpyGame {
    public static void main (String args[]){
        
        System.out.println("SpyGame application...");
        
        Safe theSafe = new Safe();
        System.out.println("Which safe is this?" + theSafe.doorNumber);
        System.out.println("Is the safe locked?" + theSafe.isLocked());
        
        // Try to unlock the safe with a guessed combination of 999
        theSafe.unLock(999);
        System.out.println("Is 999 the combination?" + theSafe.isLocked());
        
        // This wont' work:  theSafe.unLock();
        //Gives compiler error: "Method void unLock() in classSafe is not accessible from class SpyGame." 

        // How about stealing the combination?
        // Reference to this won't work:  theSafe.combination;
        //Gives compiler error: "Variable combination in class Safe not accessible from class SpyGame."  

        // How about resetting the safe's lock to a known combination?
        // This won't work:  theSafe.setCombination(999);
        // Gives compiler error: "Method void setCombination(int) in classSafe is not accessible from class SpyGame." 

        /* How about defacing the door's number? */
        System.out.println("Changing the door number...");
        theSafe.doorNumber = 555;
        System.out.println("Now the door number is:" + theSafe.doorNumber);
        theSafe.unLock(theSafe.doorNumber);
        System.out.println("Is the safe locked?" + theSafe.isLocked());
        
        System.out.println("However, you can crack your own safe...");
        Safe mySafe = new Safe(999);
        System.out.println("Is my safe locked?" + mySafe.isLocked());
        System.out.println("My safe has door number" + mySafe.doorNumber);
        System.out.println("Unlocking safe with combination as doorNumber...");
        mySafe.unLock(mySafe.doorNumber);
        System.out.println("Is my safe locked now?" + mySafe.isLocked());
        
        
    }
}
