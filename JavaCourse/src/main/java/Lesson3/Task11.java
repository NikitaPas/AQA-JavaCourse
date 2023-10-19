package Lesson3;
public class Task11 {
    public static int[] createArray(int len, int initialValue){
        int[] arr = new int[len];
        for(int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        return arr;
    }
}
