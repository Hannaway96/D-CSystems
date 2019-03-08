
package b00708431_assignment1;
import java.util.concurrent.atomic.*;

public class TrainTrack {
    
    private final String[] slots = {"[..]","[..]","[..]","[..]",
                                    "[..]","[..]","[..]","[..]",
                                    "[..]","[..]","[..]","[..]",
                                    "[..]","[..]","[..]","[..]",
                                    "[..]","[..]","[..]","[..]",
                                    "[..]","[..]"};
        
    //Array to hold Binary semaphores for each track section
    private final MageeSemaphore slotSem[] = new MageeSemaphore[22];
    
    //Reference to Train activities
    Activity trainActivity;

    //Maximum Trains allowed on track at any one time
    MageeSemaphore maxTrainA;               
    MageeSemaphore maxTrainB;                

    //A global count of how many trains are on the shared track at one time
    AtomicInteger aUsingCrossRoad;
    AtomicInteger bUsingCrossRoad;
    
    //Semaphores that allow mututal exclusion, Only one train moving at a time
    private final MageeSemaphore aMutexSem; 
    private final MageeSemaphore bMutexSem; 
    
    MageeSemaphore sharedCrossRoadLock;
       
    public TrainTrack(){     
        
        //Instantiate a new Activity class
        trainActivity = new Activity(slots);        
        
        //creating an Array of slotSemaphores and set them all to empty.
        for(int i=0; i<=21; i++){
            slotSem[i] = new MageeSemaphore(1);
        }
        
        aMutexSem = new MageeSemaphore(1);
        bMutexSem = new MageeSemaphore(1);
        
        //Allow maximum on 3 trains on a track at one time
        maxTrainA = new MageeSemaphore(3);
        maxTrainB = new MageeSemaphore(3); 
        
        //creating global couuts of trains using shared track
        aUsingCrossRoad = new AtomicInteger(0);
        bUsingCrossRoad = new AtomicInteger(0);

        //shared track is initially set to free
        sharedCrossRoadLock = new MageeSemaphore(1);
    }
    
    public void MoveTrainA_ToTrack(String trainName){
        
        CDS.idle((int)(Math.random() * 100));       //Delay to offset concurrency
        maxTrainA.P();                              //Acquire access to track
        trainActivity.addMessage("Train " + trainName + " is setting off");
        slotSem[0].P();                             //Wait for the first slot to be free
        slots[0] = "[" + trainName + "]";           //Move train to first slot
        trainActivity.addMovedTo(0);                //Record activity           
    }
    
    public void MoveTrainA_ToCrossRoad(String trainName) {
        
        CDS.idle((int) (Math.random() * 100));
        int currentPos = 0;
        do {                                                
            slotSem[currentPos + 1].P();                    //check next slot is free
            slots[currentPos + 1] = slots[currentPos];      //train moves to next slot
            slots[currentPos] = "[..]";                     //last slot is now empty
            trainActivity.addMovedTo(currentPos + 1);       //record train has moved to next slot
            slotSem[currentPos].V();                        //free up semaphore for previouus slot
            currentPos++;                                   //increment position
        } while (currentPos < 3);                           //*repeat for the next 3 track slots*       
    }   
    
    public void MoveTrainA_AlongCrossRoad(String trainName) {
                
        trainActivity.addMessage("Train " + trainName + " is approaching crossroads");
        aMutexSem.P();                                      // obtain mutually exclusive access to global variable aUsingCrossRoad
        if (aUsingCrossRoad.incrementAndGet() == 1){        // if first A train is approaching crossroad    
            sharedCrossRoadLock.P();                        // grab lock to crossroad
        }
        aMutexSem.V(); 
        
        int currentPos = 3;     
        do {                                                        
            slotSem[currentPos + 1].P();                // wait for the slot ahead to be free
            slots[currentPos + 1] = slots[currentPos];  // move train forward
            slots[currentPos] = "[..]";                 //clear the slot the train vacated
            trainActivity.addMovedTo(currentPos + 1);   //record the train activity
            slotSem[currentPos].V();                    //signal slot you are leaving 
            currentPos++;
        } while (currentPos  < 9);
                                                               
        aMutexSem.P();                                  // obtain mutually exclusive access to global variable aUsingCrossRoad
        if (aUsingCrossRoad.decrementAndGet() == 0){    // if last A train leaving shared track
            sharedCrossRoadLock.V();                    // release lock to shared track
        }
        aMutexSem.V();                                  // release mutually exclusive access to global variable aUsingCrossRoad       
    }
       
     public void MoveTrainA_OffTrack(String trainName) {
         
        CDS.idle((int) (Math.random() * 10));
        int currentPos = 9;
        do {
            slotSem[currentPos + 1].P();                //wait for the slot ahead to be free
            slots[currentPos + 1] = slots[currentPos];  //train moves to next slot
            slots[currentPos] = "[..]";                 //previous slot is now empty
            trainActivity.addMovedTo(currentPos + 1);   //record the activity
            slotSem[currentPos].V();                    //release previous slot semaphore 
            currentPos++;                               //increment current position
        } while (currentPos < 11);                      //repeat up to slot 11
              
        slots[11] = "[..]";                             //last slot is now empty 
        slotSem[11].V();                                //release previous slot semaphore
        trainActivity.addMessage("Train " + trainName + " reached it's destination");
        maxTrainA.V();                                  //allow another train to enter the track
    }
    
    public void MoveTrainB_ToTrack(String trainName){
        
        CDS.idle((int)(Math.random() * 100));
        maxTrainB.P();                               //Acquire Access to track
        trainActivity.addMessage("Train " + trainName + " is setting off");
        slotSem[12].P();                                //Wait for the first slot to be free
        slots[12] = "[" + trainName + "]";              //Move train to next slot
        trainActivity.addMovedTo(12);                   //Record activity           
    }
           
    public void MoveTrainB_ToCrossRoad(String trainName) {
        
        CDS.idle((int) (Math.random() * 100));
        int currentPos = 12;
        do {                                                        
            slotSem[currentPos + 1].P();                // wait for the slot ahead to be free
            slots[currentPos + 1] = slots[currentPos];  // move train forward
            slots[currentPos] = "[..]";                 //clear the slot the train vacated
            trainActivity.addMovedTo(currentPos + 1);   //record the train activity
            slotSem[currentPos].V();                    //signal slot you are leaving 
            currentPos++;
        } while (currentPos  < 15);
        CDS.idle((int) (Math.random() * 100));
    } 
    
    public void MoveTrainB_AlongCrossRoad(String trainName) {
        
        trainActivity.addMessage("Train " + trainName + " is approaching crossroads");
        CDS.idle((int) (Math.random() * 10));
        
        bMutexSem.P(); 
        if (bUsingCrossRoad.incrementAndGet() == 1){
            sharedCrossRoadLock.P();  
        }
        bMutexSem.V(); 
        
        CDS.idle((int) (Math.random() * 10));
        slotSem[7].P();
        slots[7] = slots[15];
        slots[15] = "[..]";
        slotSem[15].V(); 
        trainActivity.addMovedTo(7);  
        CDS.idle((int) (Math.random() * 10));
     
        slotSem[16].P();
        slots[16] = slots[7];
        slots[7] = "[..]";
        slotSem[7].V(); 
        trainActivity.addMovedTo(16); 
        
        slotSem[17].P();
        slots[17] = slots[16];
        slots[16] = "[..]";
        slotSem[16].V(); 
        trainActivity.addMovedTo(17); 
        CDS.idle((int) (Math.random() * 10));
        
        slotSem[4].P();
        slots[4] = slots[17];
        slots[17] = "[..]";
        slotSem[17].V(); 
        trainActivity.addMovedTo(4); 
        
        slotSem[18].P();
        slots[18] = slots[4];
        slots[4] = "[..]";
        slotSem[4].V(); 
        trainActivity.addMovedTo(18); 
        
        slotSem[19].P();
        slots[19] = slots[18];
        slots[18] = "[..]";
        slotSem[18].V(); 
        trainActivity.addMovedTo(19); 
        
        bMutexSem.P(); 
        if (bUsingCrossRoad.decrementAndGet() == 0){
            sharedCrossRoadLock.V(); 
        }
        bMutexSem.V(); 
    }
    
    public void MoveTrainB_OffTrack(String trainName) {
        
        CDS.idle((int) (Math.random() * 100));       
        int currentPos = 19;
        do {
            slotSem[currentPos + 1].P(); 
            slots[currentPos + 1] = slots[currentPos]; 
            slots[currentPos] = "[..]"; 
            trainActivity.addMovedTo(currentPos + 1); 
            slotSem[currentPos].V(); 
            currentPos++;
        } while (currentPos < 21);
       
        trainActivity.addMessage("Train " + trainName + " reached it's destination");
        slots[21] = "[..]";  
        slotSem[21].V();
        maxTrainB.V(); 
    }    
}
