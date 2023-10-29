package Lesson_4;

public class Main {
    public static void main(String[] args) {

    Employee[] employeeArray = new Employee[5];

    employeeArray[0] = new Employee("Ivanov Ivan Ivanov", "engineer", "ivan@mailbox.com",
            "859599555", 25000, 35);
    employeeArray[1] = new Employee("Jacob Murray", "Driver", "jacobmur@mailbox.com",
            "588477554", 28000, 43);
    employeeArray[2] = new Employee("Alan Jordan", "AQA engineer", "alanjord@mailbox.com",
            "58858523", 25000, 24);
    employeeArray[3] = new Employee("Scott Wilson", "Business Analyst", "scottwil@mailbox.com",
            "12345523", 19000, 27);
    employeeArray[4] = new Employee("William Warren", "Junior java engineer", "willwarr@mailbox.com",
            "54345532", 40000, 45);

    for(int i = 0; i< employeeArray.length; i++){
        if(employeeArray[i].age > 40){
            employeeArray[i].employeeInfo();
        }
    }

    }
}
