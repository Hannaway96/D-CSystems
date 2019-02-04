/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical1;

public class Safe {
    
    public int doorNumber = 123;
    private Boolean locked = true;
    private int combination = 456;
    
    Safe(){}
    
    Safe(int door){
        doorNumber = door;
        setCombination(doorNumber);
    }
    
    public boolean isLocked(){
        return(locked);
    }
    
    public void unLock(int thisCombination){
        if(thisCombination == combination){
            unLock();
        }
    }
            
    private void unLock(){
        locked = false;
    }
    
    private void setCombination(int setting){
        combination = setting;
    }
}
