/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carwashsimulate;

/**
 *
 * @author bramo
 */
public class Washer {
    private int secondsForWash;
    private int washTimeLeft;
    
    public Washer(int s){
        secondsForWash = s;
        washTimeLeft = 0;
    }
    
    public boolean isBusy(){
        return(washTimeLeft > 0);
    }
    
    public void reduceRemainingTime(){
        if(washTimeLeft > 0){
            washTimeLeft--;
        }
    }
    
    public void startWashing(){
        if(isBusy() == true){
            throw new IllegalStateException("Washer is in use");
        }
        washTimeLeft = secondsForWash;
    }
}
