package pl.coderslab;

import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        // Gra w zgadywanie liczb 1
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int x = 0, tries = 1;

        while (x != n) {
            System.out.println("Zgadnij liczbę:");

            while (!scanner.hasNextInt()) {
                System.out.println("To nie jest liczba! Zgadnij liczbę:");
                scanner.next();
            }

            x = scanner.nextInt();

            if (x < n) {
                System.out.println("Za mało!");
            } else if (x > n) {
                System.out.println("Za dużo!");
            }

            tries++;
        }

        System.out.println("Brawo, zgadłeś w " + tries + " podejściach!");
    }
}
