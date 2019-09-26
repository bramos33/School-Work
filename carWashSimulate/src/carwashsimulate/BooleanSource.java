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
public class BooleanSource {
    private double probability;
    
    public BooleanSource(double p){
        if((p < 0) || (p > 1)){
            throw new IllegalArgumentException("Illegal p" + p);
        }
        probability = p;
    }
    
    public boolean query(){
        return (Math.random() < probability);
    }
}
