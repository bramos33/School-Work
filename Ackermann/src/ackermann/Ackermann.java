/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ackermann;

/**
 *
 * @author Dustin
 */
public class Ackermann {

    public static void ackermann(double x, double y) {
        if (x == 0) {
            System.out.println(2 * y);

        } else if (x >= 1 && y == 0) {

            System.out.println(0);

        } else if (x >= 1 && y == 1) {

            System.out.println(2);

        } else if (x >= 1 && y >= 1) {

            ackermann(x - 1, (ackermann(x, y - 1)));

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ackermann(1, 1);
        // TODO code application logic here
    }

}
