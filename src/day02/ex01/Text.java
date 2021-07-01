package day02.ex01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Text {

   private List<String> words;

    public Text() {
        this.words = new ArrayList<>();
    }

    public void parseWords(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(" ");
                for (String s : splitLine) {
                    Dictionary.getInstance().addWord(s);
                    words.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWords() {
        return words;
    }
}
