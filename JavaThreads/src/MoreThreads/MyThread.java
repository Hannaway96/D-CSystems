/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoreThreads;

public class MyThread extends Thread{
    
    private int private_time;
    
    MyThread(int delay_time){
        private_time = delay_time;
    }
   
    public void run(){  
        //Prints out a right angled triangle
        for(int count=1, row =1; row<20; row++, count++){
             if(row == 10){
                    CDS.idle(private_time);
                } // added a delay so the triangle stopped 
                  //and then the main thread kept processing
                  
            for(int i=0; i<count; i++){              
                System.out.print('*');
            }
            System.out.print('\n');
        }
    }
}
