
package assignment1;

public class TrainTrack {
    
    private final String[] slots = {"[..]","[..]","[..]","[..]",
                                    "[..]","[..]","[..]","[..]",
                                    "[..]","[..]","[..]","[..]",
                                    "[..]","[..]","[..]","[..]",
                                    "[..]","[..]","[..]","[..]",
                                    "[..]","[..]"};
    
    
    //Array to hold Binary semaphores for each track section
    private final MageeSemaphore slotSem[] = new MageeSemaphore[22];
    //private final MageeSemaphore crossRoad1;
    //private final MageeSemaphore crossRoad2;
    
    //Reference to Train activities
    Activity trainActivity;
    
    
    public TrainTrack(){
        trainActivity = new Activity(slots);        
        //creating an Array of slotSemaphores and set them all to empty.
        for(int i=0; i<=21; i++){
            slotSem[i] = new MageeSemaphore(1);
        }  
        
        //crossRoad1 = new MageeSemaphore(0);
        //crossRoad2 = new MageeSemaphore(0);
    }
    
    public void moveTrainA(String trainName){
        CDS.idle((int)(Math.random()) * 10);  
        
        //Make a record of train's activity
        trainActivity.addMessage("Train " + trainName + " is setting off");
        slotSem[0].P();             //Wait for the first slot to be free
        slots[0] = "[" + trainName + "]"; //Move train to next slot
        trainActivity.addMovedTo(0); //Record activity
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 1");
        slotSem[1].P();         // wait for slot to be free
        slots[1] = slots[0];    //move to next slot
        slots[0] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(1);    //Record change
        slotSem[0].V();     //Give up the first slot
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 2");
        slotSem[2].P();         // wait for slot to be free
        slots[2] = slots[1];    //move to next slot
        slots[1] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(2);    //Record change
        slotSem[1].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 3");
        slotSem[3].P();         // wait for slot to be free
        slots[3] = slots[2];    //move to next slot
        slots[2] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(3);    //Record change
        slotSem[2].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " is approaching crossroad");
        //crossRoad1.P();         
        slotSem[4].P();         // wait for slot 4 and 5 to be free as trains cannot stop on crossroads
        slots[4] = slots[3];    //move to next slot
        slots[3] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(4);    //Record change
        slotSem[3].V();         //Give up the previous slot  
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 5");
        slotSem[5].P();
        slots[5] = slots[4];    //move to next slot
        slots[4] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(5);    //Record change
        slotSem[4].V();         //Give up the previous slot
        //crossRoad1.V();
                             
        trainActivity.addMessage("Train " + trainName + " is moving to slot 6");
        slotSem[6].P();         // wait for slot to be free
        slots[6] = slots[5];    //move to next slot
        slots[5] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(6);    //Record change
        slotSem[5].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " is approaching crossroad");
        //crossRoad2.P();
        slotSem[7].P();        
        slots[7] = slots[6];    //move to next slot
        slots[6] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(7);    //Record change
        slotSem[6].V();         //Give up the previous slot         
                  
        trainActivity.addMessage("Train " + trainName + " is moving to slot 8");
        slotSem[8].P();
        slots[8] = slots[7];    //move to next slot
        slots[7] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(8);    //Record change
        slotSem[7].V();     //Give up the previous slot
        //crossRoad2.V();
               
        trainActivity.addMessage("Train " + trainName + " is moving to slot 9");
        slotSem[9].P();         // wait for slot to be free
        slots[9] = slots[8];    //move to next slot
        slots[8] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(9);    //Record change
        slotSem[8].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 10");
        slotSem[10].P();         // wait for slot to be free
        slots[10] = slots[9];    //move to next slot
        slots[9] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(10);    //Record change
        slotSem[9].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 11");
        slotSem[11].P();         // wait for slot to be free
        slots[11] = slots[10];    //move to next slot
        slots[10] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(11);    //Record change
        slotSem[10].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " reached it's destination");
        slots[11] = "[..]";
        slotSem[11].V();           
    }
    
    public void moveTrainB(String trainName){
        
        CDS.idle((int)(Math.random()) * 100);            
        //Make a record of train's activity
        trainActivity.addMessage("Train " + trainName + " is setting off");
        slotSem[12].P();             //Wait for the first slot to be free
        slots[12] = "[" + trainName + "]"; //Move train to next slot
        trainActivity.addMovedTo(12); //Record activity
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 13");
        slotSem[13].P();         // wait for slot to be free
        slots[13] = slots[12];    //move to next slot
        slots[12] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(13);    //Record change
        slotSem[12].V();     //Give up the first slot
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 14");
        slotSem[14].P();         // wait for slot to be free
        slots[14] = slots[13];    //move to next slot
        slots[13] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(14);    //Record change
        slotSem[13].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 15");
        slotSem[15].P();         // wait for slot to be free
        slots[15] = slots[14];    //move to next slot
        slots[14] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(15);    //Record change
        slotSem[14].V();     //Give up the previous slot
        
        //crossRoad2.P();
        trainActivity.addMessage("Train " + trainName + " is approaching crossroad");
        slotSem[7].P();
        slots[7] = slots[15];    //move to next slot
        slots[15] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(7);    //Record change
        slotSem[15].V();         //Give up the previous slot  
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 16");
        slotSem[16].P();
        slots[16] = slots[7];    //move to next slot
        slots[7] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(16);    //Record change
        slotSem[7].V();         //Give up the previous slot
        //crossRoad2.V();
                                             
        trainActivity.addMessage("Train " + trainName + " is moving to slot 17");
        slotSem[17].P();         // wait for slot to be free
        slots[17] = slots[16];    //move to next slot
        slots[16] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(17);    //Record change
        slotSem[16].V();         //Give up the previous slot
            
        trainActivity.addMessage("Train " + trainName + " is approaching crossroad");
        //crossRoad1.P();
        slotSem[4].P(); // wait for slot 7 and 8 to be free as Trains cannot stop on the cross road                
        slots[4] = slots[17];    //move to next slot
        slots[17] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(4);    //Record change
        slotSem[17].V();
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 18");
        slotSem[18].P();
        slots[18] = slots[4];    //move to next slot
        slots[4] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(18);    //Record change
        slotSem[4].V();         //Give up the previous slot
        //crossRoad1.P();
                    
        trainActivity.addMessage("Train " + trainName + " is moving to slot 19");
        slotSem[19].P();         // wait for slot to be free
        slots[19] = slots[18];    //move to next slot
        slots[18] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(19);    //Record change
        slotSem[18].V();          //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 20");
        slotSem[20].P();         // wait for slot to be free
        slots[20] = slots[19];    //move to next slot
        slots[19] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(20);    //Record change
        slotSem[19].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " is moving to slot 21");
        slotSem[21].P();         // wait for slot to be free
        slots[21] = slots[20];    //move to next slot
        slots[20] = "[..]";      //Erase last slot
        trainActivity.addMovedTo(21);    //Record change
        slotSem[20].V();     //Give up the previous slot
        
        trainActivity.addMessage("Train " + trainName + " reached it's destination");
        slots[21] = "[..]";
        slotSem[21].V();  
    }     
}
