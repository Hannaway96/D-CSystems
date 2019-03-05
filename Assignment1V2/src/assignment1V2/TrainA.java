/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1V2;

public class TrainA extends Thread{
    
    //This is uused to represent a train on Track A    
    String trainName;
    TrainTrack track;
 
    public TrainA(String trainName, TrainTrack track){
        this.trainName = trainName;
        this.track = track;     
    }
       
    public void run(){ //Start Train A    
        track.MoveTrainA_ToTrack(trainName);
        track.MoveTrainA_ToCrossRoad(trainName);
        track.MoveTrainA_AlongCrossRoad(trainName);
        track.MoveTrainA_OffTrack(trainName);
    }
}
