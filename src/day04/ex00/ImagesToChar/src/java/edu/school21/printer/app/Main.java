package edu.school21.printer.app;

import edu.school21.printer.logic.ArrayParse;

import java.io.FileInputStream;
import java.io.IOException;


public class Main {
    final static String signatureBMP = "BM";


    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please, enter 3 parameters: 2 characters in place of white and black pixels and the full path to the image on your disk.\n" +
                    "Usage: java Program CHARACTER CHARACTER ABSOLUTE PATH");
            System.exit(0);
        }
        if (checkParams(args)) {
            ArrayParse arrayParse = new ArrayParse(args[0], args[1], args[2]);
            arrayParse.seeBMPImage();
            arrayParse.printImage();
        }
    }

    private static boolean checkParams(String[] args) {
        if (args[0].length() != 1 || args[1].length() != 1) {
            System.out.println("Please, enter characters in place of white and black pixels. One character (ex. \"-\", \"0\") for every color.");
            System.exit(0);
        }

        String photoPath = args[2];
        try {
            FileInputStream fis = new FileInputStream(photoPath);
            StringBuilder fileData = new StringBuilder();
            while (fis.available() > 0) {
                int i = fis.read();
                fileData.append((char) i);
                if (findSignature(fileData.toString())) {
                    fis.close();
                    return true;
                }
            }
            if (fis.available() == 0) {
                System.out.println("Please, input an absolute path to an image.bmp format.");
                System.exit(0);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean findSignature(String fileData) {
        return fileData.startsWith(signatureBMP);
    }
}
