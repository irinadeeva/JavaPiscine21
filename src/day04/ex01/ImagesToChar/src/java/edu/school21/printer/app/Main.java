package edu.school21.printer.app;

import edu.school21.printer.logic.ArrayParse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Main {
    final static String signatureBMP = "BM";
    final static String photoPath = "src/resources";


    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please, enter 2 parameters: characters in place of white and black pixels.\n" +
                    "Usage: java Program CHARACTER CHARACTER");
            System.exit(0);
        }

        File folder = new File(photoPath);
        for (File file : folder.listFiles()) {
            if (file.exists() && !file.getName().startsWith(".") && !file.isDirectory()) {
                if (checkParams(args, file)) {
                    ArrayParse arrayParse = new ArrayParse(args[0], args[1], file);
                    arrayParse.seeBMPImage();
                    arrayParse.printImage();
                }
            }
        }
        if (folder.length() == 0) {
            System.out.println("There is no image.");
        }
    }

    private static boolean checkParams(String[] args, File file) {
        if (args[0].length() != 1 || args[1].length() != 1) {
            System.out.println("Please, enter characters in place of white and black pixels. One character (ex. \"-\", \"0\") for every color.");
            System.exit(0);
        }

        try {
            FileInputStream fis = new FileInputStream(file);
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
                System.out.println("Please, input image.bmp format.");
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
