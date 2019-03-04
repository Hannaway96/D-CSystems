
package assignment1;

public class Assignment1 {
    
    static final int num_Of_A_Trains = 5;
    static final int num_Of_B_Trains = 5;      
    static TrainTrack trainTrack;    
   
    public static void main(String[] args) {       
        //Create Track
        trainTrack = new TrainTrack();   
        System.out.println("Started.");
        
        //Creating Trains array
        TrainA[] aTrains = new TrainA[num_Of_A_Trains];
        TrainB[] bTrains = new TrainB[num_Of_B_Trains];
        
        MageeSemaphore cross4Mutex = new MageeSemaphore(1);     //Semaphore for mutual exclusion to crossroad4(slot4)
        MageeSemaphore cross7Mutex = new MageeSemaphore(1);     //Semaphore for mutual exclusion to crossroad7(slot7)
                 
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
        trainTrack.trainActivity.printActivities();        
        System.out.println("All Trains have navigated the track Successfully");
    }    
}
