package Lesson9;

import java.util.*;
import java.util.stream.*;

public class Task13 {
    public static void main(String[] args) {
        //Task 1
        countEvenNumbersRandomArray();

        //Task 2

        List<String> load = new ArrayList<>();
        Collections.addAll(load, "Highload", "High", "Load", "Highload");

        countHighCollection(load);

        String firstElement = load.stream()
                .findFirst().orElse("0");
        System.out.println(firstElement);

        String lastElement = load.stream()
                .reduce((first, second) -> second).orElse("0");
        System.out.println(lastElement);

        // Task 3
        sortedString();
    }
    public static void countEvenNumbersRandomArray(){
        int[] arr = new int[10];
        Random rnd = new Random();
        IntStream.range(0, arr.length)
                .forEach(index -> arr[index] = rnd.nextInt(100));
        System.out.println(Arrays.toString(arr));
        long count = IntStream.of(arr)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(count);
    }
    public static void countHighCollection(List<String> load){
        long countHigh = load.stream()
                .filter(s -> s.equals("High"))
                .count();

        System.out.println("объект «High» встречается в коллекции " + countHigh + " раз");
    }
    public static void sortedString(){
        List<String> elements = new ArrayList<>();
        Collections.addAll(elements, "f10", "f15", "f2", "f4", "f4");
        Object[] arr1 = elements.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1)))).toArray();

        System.out.println(Arrays.toString(arr1));
    }
}
