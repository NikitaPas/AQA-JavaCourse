package Lesson6;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        AppData appData = new AppData();
        appData.setHeader(new String[]{"Name", "Age", "City"});
        appData.setData(new int[][]{{1, 25, 100}, {2, 30, 200}, {3, 35, 300}});

        CSVFileHandler.save(appData, "data.csv");

        AppData loadedData = CSVFileHandler.load("data.csv");
        if (loadedData != null) {
            System.out.println("Loaded Data:");
            System.out.println("Header: " + Arrays.toString(loadedData.getHeader()));
            System.out.println("Data: " + Arrays.deepToString(loadedData.getData()));
        }
    }
}
