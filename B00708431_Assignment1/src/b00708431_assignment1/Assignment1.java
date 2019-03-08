/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b00708431_assignment1;

public class Assignment1 {
    
    //maximum number of each train allowed on their respective track
    static final int num_Of_A_Trains = 20;
    static final int num_Of_B_Trains = 20;
    
    //Train Track class 
    static TrainTrack trainTrack;    

    public static void main(String[] args) {
        //Create Track
        trainTrack = new TrainTrack();   
        System.out.println("Started.");
        
        //Creating Trains array
        TrainA[] aTrains = new TrainA[num_Of_A_Trains];
        TrainB[] bTrains = new TrainB[num_Of_B_Trains];
                 
        //Loop and create each Train A object and add them into their array
        for(int i=0; i<num_Of_A_Trains; i++){
            aTrains[i] = new TrainA("A"+i, trainTrack);
        }
                
        //Loop and create each Train B object and add them into their array
        for(int i=0; i<num_Of_B_Trains; i++){
            bTrains[i]= new TrainB("B"+i, trainTrack);
        }
        
        //Run all of the Train A objects
        for(int i =0; i<num_Of_A_Trains; i++){
            aTrains[i].start();
            bTrains[i].start();       
        }     
        System.out.println("Trains Started");
          
        //Adding all of the train activities to the output string
        for(int i=0; i<num_Of_A_Trains; i++){
            try{
                aTrains[i].join();
            }catch(InterruptedException ex){}
        }
        
        for(int i=0; i<num_Of_B_Trains; i++){
            try{
                bTrains[i].join();
            }catch(InterruptedException ex){}
        }        
        
        //Print all of the train's activities
        trainTrack.trainActivity.printActivities();        
        System.out.println("All Trains have navigated the track Successfully");
    } 
}
