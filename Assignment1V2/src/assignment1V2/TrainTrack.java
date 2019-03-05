
package assignment1V2;
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
    MageeSemaphore maxTrainASem;               
    MageeSemaphore maxTrainBSem;                

    AtomicInteger aUsingCrossRoad;
    AtomicInteger bUsingCrossRoad;
    
    private final MageeSemaphore aMutexSem; 
    private final MageeSemaphore bMutexSem; 
    
    MageeSemaphore sharedCrossRoadLock;
       
    public TrainTrack(){     
        trainActivity = new Activity(slots);        
        //creating an Array of slotSemaphores and set them all to empty.
        for(int i=0; i<=21; i++){
            slotSem[i] = new MageeSemaphore(1);
        }
        
        aMutexSem = new MageeSemaphore(1);
        bMutexSem = new MageeSemaphore(1);       
        maxTrainASem = new MageeSemaphore(3);
        maxTrainBSem = new MageeSemaphore(3); 
        aUsingCrossRoad = new AtomicInteger(0);
        bUsingCrossRoad = new AtomicInteger(0);        
        sharedCrossRoadLock = new MageeSemaphore(1);
    }
    
    public void MoveTrainA_ToTrack(String trainName){
        
        CDS.idle((int)(Math.random() * 100));
        maxTrainASem.P();                           //Acquire Access to track
        trainActivity.addMessage("Train " + trainName + " is setting off");
        slotSem[0].P();                             //Wait for the first slot to be free
        slots[0] = "[" + trainName + "]";           //Move train to next slot
        trainActivity.addMovedTo(0);                //Record activity           
    }
    
    public void MoveTrainA_ToCrossRoad(String trainName) {
        
        CDS.idle((int) (Math.random() * 100));
        int currentPos = 0;
        do {                                            // wait until the position ahead is empty and then move into it
            slotSem[currentPos + 1].P();                // wait for the slot ahead to be free
            slots[currentPos + 1] = slots[currentPos];  // move train forward one position
            slots[currentPos] = "[..]";                 // clear the slot the train vacated
            trainActivity.addMovedTo(currentPos + 1);   // record the train activity
            slotSem[currentPos].V();                    // signal slot you are leaving 
            currentPos++;
        } while (currentPos < 3);
        CDS.idle((int) (Math.random() * 100));
    }   
    
    public void MoveTrainA_AlongCrossRoad(String trainName) {
                                                        // wait for the necessary conditions to get access to shared junction
        aMutexSem.P();                                  // obtain mutually exclusive access to global variable aUsingsharedJunction
        if (aUsingCrossRoad.incrementAndGet() == 1){     // if first A train joining shared junction       
            sharedCrossRoadLock.P();                    // grab lock to shared junction
        }
        aMutexSem.V();                                  // release mutually exclusive access to global variable aUsingsharedJunction                                                          
        slotSem[4].P();
        slots[4] = slots[3];
        slots[3] = "[..]";
        slotSem[3].V();                                 //move from slot[6] to slot[7]
        trainActivity.addMovedTo(4);                    //record the train activity
        CDS.idle((int) (Math.random() * 10));
                                                        // move along shared track
        slotSem[5].P();
        slots[5] = slots[4];
        slots[4] = "[..]";
        slotSem[4].V();                                 //move from slot[7] to slot[8]
        trainActivity.addMovedTo(5);                    // record the train activity
        
        slotSem[6].P();
        slots[6] = slots[5];
        slots[5] = "[..]";
        slotSem[5].V();                                 //move from slot[8] to slot[9]
        trainActivity.addMovedTo(6);                    // record the train activity
        CDS.idle((int) (Math.random() * 10));
                                                        // move off shared track
        slotSem[7].P();
        slots[7] = slots[6];
        slots[6] = "[..]";
        slotSem[6].V();                                 //move from slot[9] to slot[0]
        trainActivity.addMovedTo(6);                    // record the train activity
        // move off shared track
        slotSem[8].P();
        slots[8] = slots[7];
        slots[7] = "[..]";
        slotSem[7].V();                                 //move from slot[9] to slot[0]
        trainActivity.addMovedTo(8);                    // record the train activity
        //move of shared space
        slotSem[9].P();
        slots[9] = slots[8];
        slots[8] = "[..]";
        slotSem[8].V();                                 //move from slot[9] to slot[0]
        trainActivity.addMovedTo(9);                    // record the train activity
                                                        // signal conditions when leaving shared track
        aMutexSem.P();                                  // obtain mutually exclusive access to global variable aUsingsharedJunction
        if (aUsingCrossRoad.decrementAndGet() == 0){    // if last A train leaving shared track
            sharedCrossRoadLock.V();                    // release lock to shared track
        }
        aMutexSem.V();                                  // release mutually exclusive access to global variable aUsingsharedJunction
        CDS.idle((int) (Math.random() * 10));
    }
       
     public void MoveTrainA_OffTrack(String trainName) {
        CDS.idle((int) (Math.random() * 10));
        // record the train activity
        int currentPos = 9;
        do {
            // wait until the position ahead is empty and then move into it
            slotSem[currentPos + 1].P(); // wait for the slot ahead to be free
            slots[currentPos + 1] = slots[currentPos]; // move train forward one position
            slots[currentPos] = "[..]"; // clear the slot the train vacated
            trainActivity.addMovedTo(currentPos + 1); // record the train activity
            slotSem[currentPos].V(); // signal slot you are leaving 
            currentPos++;
        } while (currentPos < 11);
              
        trainActivity.addMessage("Train " + trainName + " reached it's destination");
        slots[11] = "[..]"; // move train type A off slot zero  
        slotSem[11].V();// signal slot 0 to be free
        CDS.idle((int) (Math.random() * 10));
        maxTrainASem.V(); // signal space for another A train
    }
    
    public void MoveTrainB_ToTrack(String trainName){
        
        CDS.idle((int)(Math.random() * 100));
        maxTrainBSem.P();                               //Acquire Access to track
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
        CDS.idle((int) (Math.random() * 10));
        // wait for the necessary conditions to get access to shared track
        bMutexSem.P(); // obtain mutually exclusive access to global variable bUsingsharedJunction
        if (bUsingCrossRoad.incrementAndGet() == 1)// if first B train joining shared track
        {
            sharedCrossRoadLock.P();  // grab lock to shared track
        }
        bMutexSem.V(); // release mutually exclusive access to global variable bUsingsharedJunction  
        CDS.idle((int) (Math.random() * 10));
        // move on to shared track
        slotSem[7].P();
        slots[7] = slots[15];
        slots[15] = "[..]";
        slotSem[15].V(); //move from slot[10] to slot[9]
        trainActivity.addMovedTo(7);  //record the train activity
        CDS.idle((int) (Math.random() * 10));
        // move along shared track
        slotSem[16].P();
        slots[16] = slots[7];
        slots[7] = "[..]";
        slotSem[7].V(); //move from slot[9] to slot[8]
        trainActivity.addMovedTo(16); // record the train activity
        
        slotSem[17].P();
        slots[17] = slots[16];
        slots[16] = "[..]";
        slotSem[16].V(); //move from slot[8] to slot[7]
        trainActivity.addMovedTo(17); // record the train activity
        CDS.idle((int) (Math.random() * 10));
        // move off shared track
        slotSem[4].P();
        slots[4] = slots[17];
        slots[17] = "[..]";
        slotSem[17].V(); //move from slot[7] to slot[16]
        trainActivity.addMovedTo(4); // record the train activity
        // move off shared track
        slotSem[18].P();
        slots[18] = slots[4];
        slots[4] = "[..]";
        slotSem[4].V(); //move from slot[7] to slot[16]
        trainActivity.addMovedTo(18); // record the train activity
        // move off shared track
        slotSem[19].P();
        slots[19] = slots[18];
        slots[18] = "[..]";
        slotSem[18].V(); //move from slot[7] to slot[16]
        trainActivity.addMovedTo(19); // record the train activity
        // signal conditions when leaving shared track
        bMutexSem.P(); // obtain mutually exclusive access to global variable aUsingsharedJunction
        if (bUsingCrossRoad.decrementAndGet() == 0) // if last B train leaving shared track
        {
            sharedCrossRoadLock.V(); // release lock to shared track
        }
        bMutexSem.V(); // release mutually exclusive access to global variable aUsingsharedJunction
        CDS.idle((int) (Math.random() * 10));
    }
    
    public void MoveTrainB_OffTrack(String trainName) {
        CDS.idle((int) (Math.random() * 100));
        
        int currentPos = 19;
        do {
            // wait until the position ahead is empty and then move into it
            slotSem[currentPos + 1].P(); // wait for the slot ahead to be free
            slots[currentPos + 1] = slots[currentPos]; // move train forward one position
            slots[currentPos] = "[..]"; // clear the slot the train vacated
            trainActivity.addMovedTo(currentPos + 1); // record the train activity
            slotSem[currentPos].V(); // signal slot you are leaving 
            currentPos++;
        } while (currentPos < 21);
        // record the train activity
        trainActivity.addMessage("Train " + trainName + " reached it's destination");
        slots[21] = "[..]"; // move train type A off slot zero  
        slotSem[21].V();// signal slot 0 to be free
        CDS.idle((int) (Math.random() * 10));
        maxTrainBSem.V(); // signal space for another B train
    }    
}
