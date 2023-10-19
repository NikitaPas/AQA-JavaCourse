package Lesson3;
import java.util.Arrays;

public class Task6 {
    public static void replaceElementsArray(){
        int[] arr = {0, 1, 0, 1, 1, 0, 1, 0, 0};
        for(int i = 0; i < arr.length; i++){
            switch (arr[i]){
                case 0:
                    arr[i] = 1;
                    break;
                case 1:
                    arr[i] = 0;
                    break;
                default:
                    arr[i] = 10;
            }
        }
        System.out.println("Задание 6. " + Arrays.toString(arr));
    }
    }
