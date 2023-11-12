package Lesson7;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1", "2", "3", "4"}, {"2","4","2","1"}, {"0","0","0","0"}, {"0","0","0","0"}};
        try{
            arrayMethod(arr);
        }
        catch (MyArraySizeException ex){
            System.out.println(ex.getMessage());
        }
        catch (MyArrayDataException ex){
            System.out.println("Ошибка в ячейке: " + ex.getRow() + "x" + ex.getColumn());
        }
    }

    public static void arrayMethod(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if(arr.length != 4) throw new MyArraySizeException("Array should be 4x4");
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length != 4) throw new MyArraySizeException("Array should be 4x4");
        }

        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                try{
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException ex){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(sum);
    }
}
