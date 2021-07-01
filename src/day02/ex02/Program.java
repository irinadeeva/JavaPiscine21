package day02.ex02;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Program {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("NB! The flag with an absolute path to the folder where we start to work is not passed");
            System.exit(0);
        }
        if (!args[0].startsWith("--current-folder=")) {
            System.out.println("NB! The flag is wrong. The right flag is --current-folder=");
            System.exit(0);
        }

        String dirLocation = args[0].substring(args[0].indexOf('=') + 1);
        File root = new File(dirLocation);
        if (root.isDirectory()) {
            System.out.println(dirLocation);
        } else {
            System.out.println("The absolute path does not lead to the folder");
        }

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        check(line, scanner);
        while (!line.equals("exit")) {

            if (line.equals("ls")) {
                displayContents(root);
            }
            if (line.startsWith("mv")) {

                if (line.contains("../"))
                    moveWhatToWhere(line, root);
                else {
                    renameFile(line, root);
                }
            }

            if (line.startsWith("cd")) {

                String toWhere = line.substring(line.indexOf(' ') + 1);

                dirLocation = changeDirLocation(dirLocation, toWhere);
                root = new File(dirLocation);
                if (root.isDirectory()) {
                    System.out.println(dirLocation);
                } else {
                    System.out.println("The absolute path does not lead to the folder");
                    System.exit(0);
                }
            }

            line = scanner.nextLine();
            check(line, scanner);
        }


    }


    private static void moveWhatToWhere(String line, File root) {
        String[] split = line.split(" ");

        File[] files = root.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.getName().equals(split[1])) {

                    String path = file.getAbsolutePath();
                    path = changeDirLocation(path, split[2]) + "/" + split[1];
                    try {
                        Files.move(Paths.get(file.getAbsolutePath()), Paths.get(path), REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("No file in the directory");
        }

    }


    private static void renameFile(String line, File root) {

        String[] split = line.split(" ");
        boolean flag = false;

        File[] files = root.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.getName().equals(split[1])) {
                    flag = true;
                    String path = file.getParent() + "/" + split[2];
                    file.renameTo(new File(path));
                }
            }
            if (!flag) {
                System.out.println("There is no file with a name " + split[1]);
            }
        } else {
            System.out.println("No file in the directory");
        }
    }

    private static String changeDirLocation(String dirLocation, String toWhere) {
        while (true) {

            if (toWhere.equals(".."))
                return increaseLevel(dirLocation);
            if (!toWhere.startsWith("../")) {
                return dirLocation + "/" + toWhere;
            }
            dirLocation = increaseLevel(dirLocation);
            dirLocation = increaseLevel(dirLocation);
            toWhere = deleteWay(toWhere);
            changeDirLocation(dirLocation, toWhere);

        }
    }

    private static String increaseLevel(String dirLocation) {
        int i = dirLocation.lastIndexOf('/');
        return dirLocation.substring(0, i);
    }

    private static String deleteWay(String toWhere) {
        int i = toWhere.indexOf('/');
        return toWhere.substring(i + 1);
    }


    private static String check(String line, Scanner scanner) {
        while (true) {
            if (line.equals("exit"))
                return line;
            if (line.equals("ls"))
                return line;
            if (line.startsWith("mv ") && line.split(" ").length == 3)
                return line;
            if (line.startsWith("cd"))
                return line;
            System.out.println("Please, enter any command (ls, mv WHAT WHERE, cd) or \"exit\".");
            line = scanner.nextLine();
        }
    }

    private static void displayContents(File root) {
        if (root.isDirectory()) {

            File[] files = root.listFiles();

            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (!file.getName().startsWith(".")) {
                        long length = file.length() / 1024;
                        if (file.isDirectory()) {
                            length = folderSize(file) / 1014;
                        }

                        if (length < 1) length = 1;

                        System.out.println(file.getName() + "  " + length + " KB");
                    }
                }
            }
        }
    }

    private static long folderSize(File directory) {
        long length = 0;
        File[] files = directory.listFiles();

        if (files != null && files.length > 0) {
            for (File file : directory.listFiles()) {
                if (file.exists() && file.isFile())
                    length += file.length();
                else
                    length += folderSize(file);
            }
        }
        return length;
    }
}


