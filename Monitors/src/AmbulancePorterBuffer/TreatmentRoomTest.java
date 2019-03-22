/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AmbulancePorterBuffer;

import BoundedBufferWithMonitors.*;

public class TreatmentRoomTest {

    public static void main(String[] args) {
        
        WaitingRoom bb = new WaitingRoom();
        AmbulancePorter ap = new AmbulancePorter(bb);
        WardPorter wp = new WardPorter(bb);
        
        ap.start();
        wp.start();     
    }    
}
