package day02.ex01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {

    private final static String resultFile = "dictionary.txt";
    private static Dictionary instance = null;
    private List<String> dictionary;
    private int size = 0;

    private Dictionary() {
        this.dictionary = new ArrayList<>();
    }

    public static Dictionary getInstance() {
        if (instance == null) {
            instance = new Dictionary();
        }
        return instance;
    }

    public int getSize() {
        return size;
    }

    public void addWord(String s) {
        if (!dictionary.contains(s)) {
            dictionary.add(s);
            size++;
        }
    }

    public boolean isEmpty() {
        return dictionary.isEmpty();
    }

    public void printDictionary() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile))) {
            Collections.sort(dictionary);
            for (String word : dictionary) {
                writer.write(word + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean contains(String s){
        return dictionary.contains(s);
    }

    public int getWordIndex(String s){
        return dictionary.indexOf(s);
    }
}
