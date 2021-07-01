package day02.ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vector {
    private List<Integer> occurrenceFrequency;

    public Vector(int size) {
        this.occurrenceFrequency = new ArrayList<>(Collections.nCopies(size, 0));
    }

    public void countFrequency(List<String> words){
        for (String word: words) {
            if (Dictionary.getInstance().contains(word)) {
                int index = Dictionary.getInstance().getWordIndex(word);
                int curFreq = occurrenceFrequency.get(index) + 1;
                occurrenceFrequency.set(index, curFreq);
            }
        }
    }

    public List<Integer> getOccurrenceFrequency() {
        return occurrenceFrequency;
    }
}
