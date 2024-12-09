import StudentPackage.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // формирование начальных данных
        var course = 3; // курс для проверки

        var student0 = new Student("Alex", 36, 3, new int[]{3, 4, 5, 6, 12});
        var student1 = new Student("Pavel", 36, 3, new int[]{2, 3, 1, 2});
        var student2 = new Student("Ann", 37, 3, new int[] {3, 5, 6, 5, 7});
        var student3 = new Student("Max", 37, 3, new int[]{2, 3, 4, 5, 5, 6, 6});
        var student4 = new Student("Michel", 46, 4, new int[]{4,5,6,7,7,4,2});

        // создаем список студентов

        // заполняем список студентов
        List<Student> studentList = new ArrayList<Student>(Arrays.asList(student0, student1, student2, student3, student4));

        // вызов метода "printStudents"
        System.out.printf("Список студентов %d курсе:\n", course);
        printStudents(studentList, 3);

        // пытаемся перевести студентов на следующий курс
        studentList = transferStudents(studentList);

        //вывод переведенных студентов
        System.out.println("\nСписок переведенных студентов:");
        printStudentList(studentList);

    }

    public static void printStudents(List<Student> students, int course) {
        for (var student : students) {
            System.out.print(course == student.getCourse() ? student.getName() + " " : "");

        }
        System.out.print("\n");
    }

    public static List<Student> transferStudents(List<Student> students){
        students.removeIf(student -> !student.tryUpgradeCourse());
        return students;
    }

    public static void printStudentList(List<Student> students){
        System.out.print("Name - course\n");
        for (var student : students){
            System.out.print(student.getName() + " - " + student.getCourse() + "\n");
        }
    }
}