import StudentPackage.Student;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String name = "Alex";
        int group = 36, course = 3;
        int[] marks = {3, 4, 5, 6, 12}, mark1 = {2, 3, 1, 2};

        Student student0 = new Student(name, group, course, marks);
        var student1 = new Student("Pavel", group, 3, mark1);
        List <Student> studentList = new ArrayList<Student>();

        studentList.add(student0);
        studentList.add(student1);

        printStudents(studentList, 3);

        studentList = transferStudents(studentList);

        System.out.println(studentList);

    }

    public static void printStudents(List<Student> students, int course) {
        for (var student : students) {
            System.out.print(course == student.getCourse() ? student.getName() + " " : "");

        }
        System.out.println();
    }

    public static List<Student> transferStudents(List<Student> students){
        students.removeIf(student -> !student.tryUpgradeCourse());
        return students;
    }
}