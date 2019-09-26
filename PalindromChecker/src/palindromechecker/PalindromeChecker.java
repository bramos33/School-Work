/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromechecker;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author bramo
 */
public class PalindromeChecker {

    public static boolean isWordPalindrome(String input) {

        Queue<String> q = new LinkedList<>();
        Stack<String> s = new Stack<>();

        String word = "";

        Character letter;   // One character from the input string

        int mismatches = 0; // Number of spots that mismatched

        int i;              // Index for the input string

        for (i = 0; i < input.length(); i++) {

            letter = input.charAt(i);
            if (Character.isLetter(letter) || letter == '\'') {
                word += letter;
            } else if (word.length() == 0) {
                word = "";
            } else {
                q.add(word);
                s.push(word);
                word = "";
            }
        }

        while (!q.isEmpty()) {

            if (q.remove().compareToIgnoreCase(s.pop()) != 0) {
                mismatches++;
            }

        }

        // If there were no mismatches, then the string was a palindrome.
        return (mismatches == 0);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in); // Keyboard input       

        String line;                            // One input line

        do {

            System.out.print("Your expression (or return to end): ");

            line = stdin.nextLine();

            if (isWordPalindrome(line)) {
                System.out.println("That is a word palindrome.");
            } else {
                System.out.println("That is not a word palindrome.");
            }

        } while (line.length() != 0);
//        TODO code application logic here
    }

}
