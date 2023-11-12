package Lesson6;

import java.io.*;
import java.util.Arrays;


public class CSVFileHandler {
    public static void save(AppData data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            String headerRow = String.join(";", data.getHeader());
            writer.write(headerRow);
            writer.newLine();

            int[][] dataRows = data.getData();
            for (int i = 0; i < dataRows.length; i++) {
                StringBuilder rowData = new StringBuilder();
                for (int j = 0; j < dataRows[i].length; j++) {
                    if (j > 0) {
                        rowData.append(";");
                    }
                    rowData.append(dataRows[i][j]);
                }
                writer.write(rowData.toString());
                writer.newLine();
            }

            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
    public static AppData load(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String headerLine = reader.readLine();
            String[] header = headerLine.split(";");

            String line;
            int[][] data = new int[3][3];
            int rowIndex = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }
                data[rowIndex] = row;
                rowIndex++;
            }

            System.out.println("Data loaded successfully.");

            AppData loadedData = new AppData();
            loadedData.setHeader(header);
            loadedData.setData(data);
            return loadedData;
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return null;
        }
    }
}
