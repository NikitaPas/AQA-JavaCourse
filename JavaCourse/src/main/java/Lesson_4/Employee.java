package Lesson_4;

public class Employee {
    String fullName;
    String position;
    String email;
    String phoneNumber;
    int salary;
    int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void employeeInfo(){
        System.out.println("ФИО: " + this.fullName + "\nДолжность: " + this.position + "\nemail: " + this.email +
                "\nТелефон: " + this.phoneNumber + "\nЗарплата: " + this.salary + "\nВозраст: " + this.age);
    }
}
