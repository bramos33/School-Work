/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryprint;

/**
 *
 * @author Dustin
 */
public class BinaryPrint {
    
    public static void binaryPrint(int n){
        if(n == 0 || n == 1){
            System.out.print(n);
            return;
        }
        binaryPrint(n/2);
        System.out.print(n%2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        binaryPrint(4);
        System.out.println("");
        // TODO code application logic here
    }
    
}
