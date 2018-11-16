package pl.coderslab;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        // Gra w zgadywanie liczb 2 (przez komputer)
        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją odgadnę!");
        int min = 0;
        int max = 1000;
        String answer = "";
        Scanner scanner = new Scanner(System.in);
        int tries = 0;

        while (!answer.equals("t")) {
            int n = ((max - min) / 2) + min;
            System.out.println("Czy Twoja liczba to " + n + "? [m/w/t]");
            answer = scanner.next();

            while (!answer.equals("m") && !answer.equals("w") && !answer.equals("t")) {
                System.out.println("To nie prawidłowa odpowiedź. Podaj [m/w/t]:");
                answer = scanner.next();
            }

            if (answer.equals("m")) {
                max = n;
            } else if (answer.equals("w")) {
                min = n;
            }

            tries++;
        }

        System.out.println("Odgadłem w " + tries + " próbach!");
    }
}
