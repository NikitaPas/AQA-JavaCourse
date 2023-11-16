package Lesson8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, ArrayList<String>> phones;
    public Phonebook(){
        phones = new HashMap<>();
    }
    public void add(String surname, String number){
        ArrayList<String> numbers = phones.getOrDefault(surname, new ArrayList<>());
        numbers.add(number);
        phones.put(surname, numbers);
    }
    public void get(String surname){
        if(!phones.containsKey(surname)){
            System.out.println("Телефонов по данной фамилии не найдено");
        }
        else{
            System.out.println(phones.get(surname));
        }
    }

    public void getAll(){
        for(Map.Entry<String, ArrayList<String>> item : phones.entrySet()){
            System.out.println("Фамилия: " + item.getKey() + " Номера телефонов: " + item.getValue());
        }
    }
}
