package by.epamtc.automation.io.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static final String DIRECTORY_PREFIX = "|------";
    public static final String FILE_PREFIX = "|      ";

    public static void main(String[] args) {

        File file = new File(args[0]);

        if(file.exists() && file.isDirectory()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/mainTask.txt"))) {
                treatFileAsDirectory(file, 0, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(file.exists() && file.isFile()) {
            treatFileAsFile(args[0]);
        } else {
            System.out.println("The path to the file or directory is specified!");
        }
    }

    public static void treatFileAsDirectory(File sourceDirectory, int indentationLevel, BufferedWriter writer) throws IOException {
        File[] files = sourceDirectory.listFiles();
        String startingIndentationForDirectories = "";
        String startingIndentation = "  ";
        String growIndentPerIteration = "    ";

        for (int i = 0; i < indentationLevel - 1; i++) {
            startingIndentation += growIndentPerIteration;
        }

        if (indentationLevel > 0) {
            startingIndentationForDirectories = startingIndentation + DIRECTORY_PREFIX;
        }
        writer.write(startingIndentationForDirectories + sourceDirectory.getName());
        writer.newLine();

        for(File file: files) {
            if(file.isDirectory()) {
                treatFileAsDirectory(file, indentationLevel + 1, writer);
            }
        }
        for(File file: files) {
            if(file.isFile()) {
                writer.write(startingIndentation + FILE_PREFIX + file.getName());
                writer.newLine();
            }
        }
    }

    public static void treatFileAsFile(String pathToFile) {
        List <String> stringLines = convertFileToStringList(pathToFile);
        int fileCounter = 0;
        int folderCounter = 0;
        for(int i = 0; i < stringLines.size(); i++) {
            if(stringLines.get(i).contains(DIRECTORY_PREFIX)) {
                folderCounter++;
            } else if(stringLines.get(i).contains(FILE_PREFIX)) {
                fileCounter++;
            }
        }
        System.out.printf("Number of folders: %d\n", folderCounter);
        System.out.printf("Number of files: %d\n", fileCounter);
        System.out.printf("Average file name length: %f\n", findAverageFileNameLength(stringLines));
        System.out.printf("Average number of files in a folder: %f\n", (double)fileCounter/folderCounter);
    }

    public static List<String> convertFileToStringList(String pathToFile) {
        List<String> stringLines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while((line = reader.readLine()) != null){
                stringLines.add(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return stringLines;
    }

    public static double findAverageFileNameLength(List <String> stringLines) {
        int fileCounter = 0;
        int sumLengthFileNames = 0;
        for(int i = 0; i < stringLines.size(); i++) {
            if(stringLines.get(i).contains(FILE_PREFIX)) {
                fileCounter++;
                sumLengthFileNames += stringLines.get(i).trim().replace(FILE_PREFIX, "").length();
            }
        }
        return (double)sumLengthFileNames/fileCounter;
    }
}
