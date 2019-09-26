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
public class Averager {
    private int count;
    private double sum;
    
    public void Averager(){
        count = 0;
        sum = 0;
    }
    
    public void addNumber(double value){
        if(howManyNumbers() == Integer.MAX_VALUE){
            throw new IllegalStateException("Too many numbers.");
        }
        sum += value;
        count++;
    }
    
    public double average(){
        if(howManyNumbers() == 0){
            return Double.NaN;
        }
        else{
            return sum / count;
        }
    }
    
    public int howManyNumbers(){
        return count;
    }
}
