/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carwashsimulate;
import java.util.*;

/**
 *
 * @author bramo
 */
public class carWashSimulate {
    
    public static void carWashSimulate(int washTime, double arrivalProb, int totalTime){
        Queue<Integer> arrivalTimes = new LinkedList<>();
        int next;
        BooleanSource arrival = new BooleanSource(arrivalProb);
        Washer machine = new Washer(washTime);
        Averager waitTimes = new Averager();
        int currentSecond;
        
        System.out.println("Seconds to wash one: "+ washTime);
        System.out.println("Probability of customer arrival during a second: "+ arrivalProb);
        System.out.println("Total simulation seconds: "+ totalTime);
        
        if(washTime < 0 || arrivalProb < 0 || arrivalProb > 1 || totalTime < 0){
            throw new IllegalArgumentException("Values are out of range");
        }
        
        for(currentSecond = 0; currentSecond < totalTime; currentSecond++){
            if(arrival.query()){
                arrivalTimes.add(currentSecond);
            }
            
            if((!machine.isBusy()) && (!arrivalTimes.isEmpty())){
                next = arrivalTimes.remove();
                waitTimes.addNumber(currentSecond - next);
                machine.startWashing();
            }
            machine.reduceRemainingTime();
        }
        System.out.println("Customers served: " +waitTimes.howManyNumbers());
        
        if(waitTimes.howManyNumbers() > 0){
            System.out.println("Average wait: " + waitTimes.average() + " sec");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        carWashSimulate(60, .01, 43200);
        // TODO code application logic here
    }
    
}
