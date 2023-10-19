package Lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1. " + Task1.checkSum(10, 2));
        Task2.negativeOrPositive(5);
        System.out.println("Задание 3. " + Task3.negativeOrPositive(-10));
        Task4.howManyToPrint("Задание 4...", 3);
        System.out.println("Задание 5. " + Task5.leapYear(700));
        Task6.replaceElementsArray();
        Task7.fillArray();
        Task8.countArray();
        System.out.println("Задание 10.");
        Task10.diagonalElementsArray();
        System.out.println("Задание 11. " + Arrays.toString(Task11.createArray(5, 100)));
        }
    }