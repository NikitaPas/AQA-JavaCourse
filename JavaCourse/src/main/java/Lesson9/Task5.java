package Lesson9;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> logins = new ArrayList<>();
        while (true){
            System.out.println("Введите login: ");
            String writedLogin = in.nextLine();
            if(writedLogin.isEmpty()){
                break;
            }
            else {
                logins.add(writedLogin);
            }
        }
        List<String> newLogins = logins.stream()
                .filter(s -> s.indexOf("f") == 0)
                .collect(Collectors.toList());
        System.out.println("Логины на букву f " + newLogins);
    }
}
