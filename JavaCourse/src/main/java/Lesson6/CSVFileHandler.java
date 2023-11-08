package Lesson6;

import java.io.*;
import java.util.Arrays;


public class CSVFileHandler {
    public static void save(AppData data, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            String headerRow = String.join(";", data.getHeader());
            writer.println(headerRow);

            int[][] dataRows = data.getData();
            for (int[] row : dataRows) {
                StringBuilder rowData = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    if (i > 0) {
                        rowData.append(";");
                    }
                    rowData.append(row[i]);
                }
                writer.println(rowData);
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
            int[][] data = new int[0][];
            int rowIndex = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }
                data = Arrays.copyOf(data, rowIndex + 1);
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
