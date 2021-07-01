package day02.ex01;

import java.util.List;

public class Program {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("NB! 2 files should be passed as command-line arguments");
            System.exit(0);
        }
        Text text1 = new Text();
        Text text2 = new Text();

        text1.parseWords(args[0]);
        text2.parseWords(args[1]);
        if (!Dictionary.getInstance().isEmpty()) {
            Vector vector1 = new Vector(Dictionary.getInstance().getSize());
            Vector vector2 = new Vector(Dictionary.getInstance().getSize());

            vector1.countFrequency(text1.getWords());
            vector2.countFrequency(text2.getWords());

            calculateSimilarity(vector1.getOccurrenceFrequency(), vector2.getOccurrenceFrequency());

            Dictionary.getInstance().printDictionary();
        }
    }

    private static void calculateSimilarity(List<Integer> freq1, List<Integer> freq2) {
        double numerator = 0.0;
        double denominator;
        double a = 0.0;
        double b = 0.0;
        double result;

        for (int i = 0; i < freq1.size(); i++) {
            numerator += freq1.get(i) * freq2.get(i);
        }

        for (Integer integer : freq1) {
            a += integer * integer;
        }

        for (Integer integer : freq2) {
            b += integer * integer;
        }

        denominator = Math.sqrt(a) * Math.sqrt(b);

        result = numerator / denominator;
        if (denominator != 0)
            System.out.printf("Similarity = %.2f\n", result);
        else
            System.out.println("Similarity = 0");
    }
}
