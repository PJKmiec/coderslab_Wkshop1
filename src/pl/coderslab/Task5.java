package pl.coderslab;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Task5 {

    public static void main(String[] args) {

        // Wyszukiwarka najpopularniejszych słów
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        System.out.println("working...");

        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            String line = "";
            String output = "";

            for (Element elem : links) {
                line = elem.text().replaceAll("[\\.$|,|;|'|:|?|\"|!|\\[|\\]|”|[0-9]]", "");
                String[] word = line.split(" ");

                for (int i = 0; i < word.length; i++) {
                    if (word[i].length() > 3) {
                        output += word[i].toLowerCase() + " ";
                    }
                }
            }

            Path path1 = Paths.get("popular_words.txt");

            if (!Files.exists(path1)) {
                try {
                    Files.createFile(path1);
                } catch (IOException e) {
                    System.err.println("Nie można utworzyć pliku!");
                }
            }

            try {
                Files.write(path1, output.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] badWords = {"oraz", "ponieważ", "info", "infografika", "wygraj", "onet"};

            for (String replacement : badWords) {
                output = output.replace(replacement + " ", "");
            }

            Path path2 = Paths.get("filtered_popular_words.txt");

            if (!Files.exists(path2)) {
                try {
                    Files.createFile(path2);
                } catch (IOException e) {
                    System.err.println("Nie można utworzyć drugiego pliku!");
                }
            }

            try {
                Files.write(path2, output.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Finished generating an output " + output.length() + " characters long.");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
