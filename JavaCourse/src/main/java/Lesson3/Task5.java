package Lesson3;
public class Task5 {
    public static boolean leapYear(int year){
        if(year % 100 == 0){
            if(year % 400 == 0){
                return true;
            }
            else{
                return false;
            }
        }
        else if(year % 4 == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
