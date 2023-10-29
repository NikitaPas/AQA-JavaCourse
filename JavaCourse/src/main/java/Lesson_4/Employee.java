package Lesson_4;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    public int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void employeeInfo(){
        System.out.println("ФИО: " + this.fullName + "\nДолжность: " + this.position + "\nemail: " + this.email +
                "\nТелефон: " + this.phoneNumber + "\nЗарплата: " + this.salary + "\nВозраст: " + this.age);
    }
}
