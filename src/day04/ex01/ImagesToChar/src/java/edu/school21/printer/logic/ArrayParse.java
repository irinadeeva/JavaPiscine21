package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArrayParse {
    private String whiteS;
    private String blackS;
    private File photoPath;
    private String[][] array2D;

    public ArrayParse(String whiteS, String blackS, File photoPath) {
        this.whiteS = whiteS;
        this.blackS = blackS;
        this.photoPath = photoPath;
    }

    public void seeBMPImage() {
        try {
            BufferedImage image = ImageIO.read(photoPath);
            array2D = new String[image.getHeight()][image.getWidth()];

            for (int xPixel = 0; xPixel < image.getHeight(); xPixel++)
            {
                for (int yPixel = 0; yPixel < image.getWidth(); yPixel++)
                {
                    int color = image.getRGB(yPixel, xPixel);
                    if (color == Color.BLACK.getRGB()) {
                        array2D[xPixel][yPixel] = blackS;
                    } else {
                        array2D[xPixel][yPixel] = whiteS;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printImage(){
        for (String[] strings : array2D) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
