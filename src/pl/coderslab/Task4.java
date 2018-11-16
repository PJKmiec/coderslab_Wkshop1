package pl.coderslab;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class Task4 {

    // symulator rzutu kostką
    public static void main(String[] args) {
        System.out.println(rollDice("2D100-50"));
    }

    public static String rollDice(String str) {
        String parts[] = str.split("D");
        int rolls = 1;

        if (str.charAt(0) != 'D') {
            rolls = parseInt(parts[0]);
        }

        int starter = parts[1].length();
        int modifier = 0;

        if (parts[1].indexOf('+') > -1) {
            starter = parts[1].indexOf('+');
            modifier = parseInt(parts[1].substring(starter));
        } else if (parts[1].indexOf('-') > -1) {
            starter = parts[1].indexOf('-');
            modifier = parseInt(parts[1].substring(starter));
        }

        Random rand = new Random();
        int walls = parseInt(parts[1].substring(0, starter));
        walls = rand.nextInt(walls) + 1;
        int result = rolls * walls + modifier;

        return "Wynik rzutu kością " + str + " to " + result;
    }
}
