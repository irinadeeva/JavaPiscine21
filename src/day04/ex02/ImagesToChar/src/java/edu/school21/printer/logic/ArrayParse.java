package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.beust.jcommander.Parameter;

import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

@Parameters(separators = "=")
public class ArrayParse {
    @Parameter(names = "--white")
    private String whiteS;

    @Parameter(names = "--black")
    private String blackS;

    private File photoPath;

    private Ansi.BColor bgW;

    public void setBgW(Ansi.BColor bgW) {
        this.bgW = bgW;
    }

    public void setBgB(Ansi.BColor bgB) {
        this.bgB = bgB;
    }

    private Ansi.BColor bgB;

    public String getWhiteS() {
        return whiteS;
    }

    public String getBlackS() {
        return blackS;
    }

    public ArrayParse(File photoPath) {
        this.photoPath = photoPath;
    }

    public void seeBMPImage() {
        try {
            BufferedImage image = ImageIO.read(photoPath);

            ColoredPrinter cpB = new ColoredPrinter.Builder(1, false)
                    .foreground(Ansi.FColor.WHITE).background(bgB)
                    .build();

            ColoredPrinter cpW = new ColoredPrinter.Builder(1, false)
                    .foreground(Ansi.FColor.WHITE).background(bgW)
                    .build();


            for (int xPixel = 0; xPixel < image.getHeight(); xPixel++) {
                for (int yPixel = 0; yPixel < image.getWidth(); yPixel++) {
                    int color = image.getRGB(yPixel, xPixel);
                    if (color == Color.BLACK.getRGB()) {
                        cpB.print(" ");
                    } else {
                        cpW.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
