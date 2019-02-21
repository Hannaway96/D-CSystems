/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoreThreads;


public class ThreadDemo {

    public static void main(String[] args) {
        
        int randTime = (int)(Math.random());
        MyThread mt = new MyThread(1000);
        mt.start();
        
        for(int i=0; i<50; i++){
            System.out.println("i= " + i + ", i*i = " +i*i);
        }
    }   
}
