package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.diogonunes.jcdp.color.api.Ansi;
import edu.school21.printer.logic.ArrayParse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Main {
    final static String signatureBMP = "BM";
    final static String photoPath = "src/resources";
    private static ArrayParse arrayParse;

    public static void main(String[] args) {


        File folder = new File(photoPath);
        for (File file : folder.listFiles()) {
            if (file.exists() && !file.getName().startsWith(".") && !file.isDirectory()) {
                if (checkParams(args, file)) {
                    arrayParse = new ArrayParse(file);
                    JCommander.newBuilder()
                            .addObject(arrayParse)
                            .build()
                            .parse(args);
                    arrayParse.setBgW(defineColors(arrayParse.getWhiteS()));
                    arrayParse.setBgB(defineColors(arrayParse.getBlackS()));
                    arrayParse.seeBMPImage();
                }
            }
        }
        if (folder.length() == 0) {
            System.out.println("There is no image.");
        }
    }

    private static boolean checkParams(String[] args, File file) {
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

    private static Ansi.BColor defineColors(String color) {
        switch (color) {
            case ("RED"):
                return Ansi.BColor.RED;
            case ("GREEN"):
                return Ansi.BColor.GREEN;
            case ("BLACK"):
                return Ansi.BColor.BLACK;
            case ("BLUE"):
                return Ansi.BColor.BLUE;
            case ("YELLOW"):
                return Ansi.BColor.YELLOW;
            case ("CYAN"):
                return Ansi.BColor.CYAN;
            case ("MAGENTA"):
                return Ansi.BColor.MAGENTA;
            case ("WHITE"):
                return Ansi.BColor.WHITE;
            default:
                System.out.println("Unknown color");
                System.exit(0);
        }
        return null;
    }


}
