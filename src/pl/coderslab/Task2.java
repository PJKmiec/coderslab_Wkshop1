package pl.coderslab;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        // symulator lotto
        Scanner scanner = new Scanner(System.in);
        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));
        Integer[] arr6 = Arrays.copyOf(arr, 6);
        Integer[] userNum = new Integer[6];

        for (int i = 0; i < 6; i++) {
            System.out.println("Podaj liczbę:");

            while (!scanner.hasNextInt()) {
                System.out.println("To nie jest liczba! Podaj liczbę:");
                scanner.next();
            }

            int x = scanner.nextInt();

            while (x < 1) {
                System.out.println("Za mała liczba! Podaj poprawną liczbę:");
                x = scanner.nextInt();
            }

            while (x > 49) {
                System.out.println("Za duża liczba! Podaj poprawną liczbę:");
                x = scanner.nextInt();
            }

            while (Arrays.asList(userNum).contains(x)) {
                System.out.println("Podałeś już tę liczbę! Podaj nową liczbę:");
                x = scanner.nextInt();
            }
            userNum[i] = x;
        }

        Arrays.sort(userNum);
        System.out.println("Twoje szczęśliwe numery to: " + Arrays.toString(userNum) + ".");
        System.out.println("Wyniki losowania to: " + Arrays.toString(arr6) + ".");
        int luckyNumbers = 0;

        for (int j = 0; j < 6; j++) {
            if (arr6[j] == userNum[j]) {
                luckyNumbers++;
            }
        }
        System.out.println("Trafiłeś " + luckyNumbers + " numerów.");
    }
}
