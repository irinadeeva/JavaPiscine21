package day00.ex04;

import java.util.Scanner;

public class Program {

    static void printResult(char[] frequentCharacter, int[] characterFrequency, int width) {
        final int height = 12;

        char[][] histogram = new char[height][width];

        for (int i = 0; i < width; i++) {
            histogram[11][i] = frequentCharacter[i];
        }

        int delimeter = 1;
        if (characterFrequency[0] > 10)
            delimeter = characterFrequency[0] / 10;
        for (int i = 0; i < width; i++) {
            int k = characterFrequency[i] / delimeter;
            if (k > 10)
                k = 10;
            int j = 10;
            while (k > 0) {
                histogram[j][i] = '#';
                j--;
                k--;
            }
            histogram[j][i] = (char)(characterFrequency[i] - 1);
        }

        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                if (i != 11 && histogram[i][j] != 0 && histogram[i][j] != '#') {
                    System.out.print(histogram[i][j] + 1 + "   ");

                }
                else if (histogram[i][j] != 0)
                    System.out.print(histogram[i][j] + "   ");
            }
        }
    }

    public static void main(String[] args) {
        char[] charByFrequency = new char[65536];
        int charactersNumber = 0;
        int minCharacter = 65535;
        int maxCharacter = 0;
        char[] frequentCharacter;
        int[] characterFrequency;

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] charArrayLine = line.toCharArray();
        for (int i = 0; i < charArrayLine.length; i++) {
            if (charByFrequency[charArrayLine[i]] == 0)
                charactersNumber++;
            charByFrequency[charArrayLine[i]] += 1;
            if (minCharacter > (int) charArrayLine[i])
                minCharacter = charArrayLine[i];
            if (maxCharacter < (int) charArrayLine[i])
                maxCharacter = charArrayLine[i];
        }

        if (charactersNumber > 10)
            charactersNumber = 10;

        frequentCharacter = new char[charactersNumber];
        characterFrequency = new int[charactersNumber];

        int j = 0;
        while (j < charactersNumber) {
            int i = minCharacter;
            int k = 0;
            int mostFrequent = 0;
            while (i >= minCharacter && i <= maxCharacter) {
                if (charByFrequency[i] > mostFrequent) {
                    k = i;
                    mostFrequent = charByFrequency[i];
                }
                i++;
            }
            frequentCharacter[j] = (char) k;
            characterFrequency[j] = mostFrequent;
            charByFrequency[k] = 0;
            j++;
        }

        if (charactersNumber != 0)
            printResult(frequentCharacter, characterFrequency, charactersNumber);
    }
}
