package Lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"День", "День", "День", "День", "Время", "Дом", "Самовар", "Ночь", "День", "Привет", "Пока", "Рыба", "Весы", "Время", "Час", "Волк", "Медведь", "День"};
        HashSet<String> uniqueWords = new HashSet<String>();
        for(int i = 0; i < arr.length; i++) {
            uniqueWords.add(arr[i]);
        }
        for(String word : uniqueWords){
            System.out.println(word);
        }
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for(int i = 0; i < arr.length; i++){
            if(!words.containsKey(arr[i])){
                words.put(arr[i], 1);
            }
            else{
                int count = words.get(arr[i]);
                words.put(arr[i], count + 1);
            }
        }

        Phonebook phonebook = new Phonebook();
        phonebook.add("Киров", "+80295234512");
        phonebook.add("Павлов", "+80294165317");
        phonebook.add("Ильющенков", "+80291543864");
        phonebook.add("Иванов", "+80294164317523");
        phonebook.add("Киров", "+80291234515");

        phonebook.get("Киров");
        phonebook.getAll();

    }
}
