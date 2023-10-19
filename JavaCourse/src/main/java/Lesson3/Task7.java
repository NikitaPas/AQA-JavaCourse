package Lesson3;
import java.util.Arrays;

public class Task7 {
    public static void fillArray(){
        int[] arr = new int[100];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        System.out.println("Задание 7. " + Arrays.toString(arr));
    }
}
