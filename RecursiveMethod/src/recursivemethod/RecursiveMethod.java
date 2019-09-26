/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursivemethod;

/**
 *
 * @author bramo
 */
public class RecursiveMethod {

    int call = 0;

    public static void recursive(int x, int y) {
        if (x == 0) {
            return;
        }
        System.out.println("This was written by call number " + y);
        recursive(x - 1, y + 1);
        System.out.println("This was also written by call number" + y);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        recursive(4, 1);
        // TODO code application logic here
    }

}
