package Lesson9;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.OptionalDouble;

public class Task4 {
    static Collection<Student> students = Arrays.asList(
            new Student("Дмитрий", 18, Gender.MAN),
            new Student("Вася", 17, Gender.MAN),
            new Student("Маша", 20, Gender.WOMAN),
            new Student("Миша", 28, Gender.MAN)
    );

    private enum Gender {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "name=" + name + "\n" +
                    "gender=" + gender + "\n" +
                    "age=" + age;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }

    public static void main(String[] args) {
        OptionalDouble averageAge = students.stream()
                .filter(student -> student.getGender().equals(Gender.MAN))
                .mapToInt(Student::getAge).average();
        System.out.println(averageAge);

        students.stream()
                .filter(student -> student.getGender().equals(Gender.MAN) && student.getAge() <= 27 && student.getAge() >= 18)
                .forEach(student -> System.out.println("Грозит повестка: \n" + student.toString()));
    }

}
