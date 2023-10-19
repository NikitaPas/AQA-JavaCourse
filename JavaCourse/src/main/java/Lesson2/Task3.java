public class Task3 {
    public static void printColor(){
        int value = 10;
        if(value <= 0){
            System.out.println("Задание 3. Красный");
        }
        if(value > 0 && value <= 100){
            System.out.println("Задание 3. Жёлтый");
        }
        if(value > 100){
            System.out.println("Задание 3. Зеленый");
        }
    }
}
