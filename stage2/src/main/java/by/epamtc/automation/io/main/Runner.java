package by.epamtc.automation.io.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    static String directoryPrefix = "|------";
    static String filePrefix = "|      ";

    public static void main(String[] args) {

        String directoryPath = "D:\\instal\\Nirvana";
        String filePath = "data/mainTask.txt";
        File file = new File(directoryPath);

        if(file.exists() && file.isDirectory()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                treatFileAsDirectory(file, 0, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(file.exists() && file.isFile()) {
//            treatFileAsFile(directoryPath);
        } else {
            System.out.println("Указан неверный путь к файлу либо директории!");
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
            startingIndentationForDirectories = startingIndentation + directoryPrefix;
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
                writer.write(startingIndentation + filePrefix + file.getName());
                writer.newLine();
            }
        }
    }

    public static void treatFileAsFile(String pathToFile) {
        List <String> stringLines = convertFileToStringList(pathToFile);
        int fileCounter = 0;
        int folderCounter = 0;
        for(int i = 0; i < stringLines.size(); i++) {
            if(stringLines.get(i).contains(directoryPrefix)) {
                folderCounter++;
            } else if(stringLines.get(i).contains(filePrefix)) {
                fileCounter++;
            }
        }
        System.out.printf("Number of folders: %d\n", folderCounter);
        System.out.printf("Number of files: %d\n", fileCounter);
        System.out.printf("Average file name length: %f\n", findAverageFileNameLength(stringLines));
        System.out.printf("Average number of files in a folder: %f\n", fileCounter/folderCounter);
    }

    //метод, который преобразует исходный текстовый файл в лист строк
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

    //метод расчитывает среднюю длину имен файлов
    public static double findAverageFileNameLength(List <String> stringLines) {
        int fileCounter = 0;
        int sumLengthFileNames = 0;
        for(int i = 0; i < stringLines.size(); i++) {
            if(stringLines.get(i).contains(filePrefix)) {
                fileCounter++;
                sumLengthFileNames += stringLines.get(i).trim().replace(filePrefix, "").length();
            }
        }
        return (double)sumLengthFileNames/fileCounter;
    }
}
