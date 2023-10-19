package Lesson3;
import java.util.Arrays;

public class Task10 {
    public static void diagonalElementsArray(){
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(i == j){
                    arr[i][j] = 1;
                }
                if(i + j == arr.length - 1){
                    arr[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
