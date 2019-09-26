/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import java.util.*;

/**
 *
 * @author bramo
 */
public class Palindrome {

    /**
     *
     * The main method prompts the user for a strings. Each string is read
     *
     * and checked to see whether it is a palindrome. The program ends when
     *
     * the user enters an empty line (just the return key).
     *
     * @param args
     *
     * not used in this implementation
     *
     *
     */
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in); // Keyboard input       

        String line;                            // One input line

        do {

            System.out.print("Your expression (or return to end): ");

            line = stdin.nextLine();

            if (is_palindrome(line)) {
                System.out.println("That is a palindrome.");
            } else {
                System.out.println("That is not a palindrome.");
            }

        } while (line.length() != 0);

    }

    /**
     *
     * Determine whether a string is a palindrom. Note: All non-letters are
     *
     * ignored, and the case of the letters is also ignored.
     *
     * @param input
     *
     * the string to check
     *
     * @return
     *
     * true if and only if the input string is a palindrome.
     *
     *
     */
    public static boolean is_palindrome(String input) {

        Queue<Character> q = new LinkedList<>();

        Stack<Character> s = new Stack<>();

        Character letter;   // One character from the input string

        int mismatches = 0; // Number of spots that mismatched

        int i;              // Index for the input string

        for (i = 0; i < input.length(); i++) {

            letter = input.charAt(i);

            if (Character.isLetter(letter)) {

                q.add(letter);

                s.push(letter);

            }

        }

        while (!q.isEmpty()) {

            if (q.remove() != s.pop()) {
                mismatches++;
            }

        }

        // If there were no mismatches, then the string was a palindrome.
        return (mismatches == 0);

    }

}
