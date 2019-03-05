/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b00708431_assignment1;

public class TrainB extends Thread{
    
    //This is uused to represent a train on Track B    
    String trainName;
    TrainTrack track;
    
    public TrainB(String trainName, TrainTrack track){
        this.trainName = trainName;
        this.track = track;
    }
      
    public void run(){ //Start Train B
        track.MoveTrainB_ToTrack(trainName);
        track.MoveTrainB_ToCrossRoad(trainName);
        track.MoveTrainB_AlongCrossRoad(trainName);
        track.MoveTrainB_OffTrack(trainName);
    }
}
