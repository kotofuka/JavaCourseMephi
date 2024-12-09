
import StudentPackage.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainForStudentTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }

    @Nested
    @DisplayName("Transfer Student tests:")
    class TransferStudentTest {

        @Test
        @DisplayName("Test 1")
        void transferStudentTest1() {

            var student0 = new Student("Alex", 36, 3, new int[]{3, 4, 5, 6, 12});
            var student1 = new Student("Pavel", 36, 3, new int[]{2, 3, 1, 2});
            var student2 = new Student("Ann", 37, 3, new int[]{3, 5, 6, 5, 7});
            var student3 = new Student("Max", 37, 3, new int[]{2, 3, 4, 5, 5, 6, 6});
            var student4 = new Student("Michel", 46, 4, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));

            var truthResult = "[" +
                    "Student{name='Alex', group=36, course=4, marks=[3, 4, 5, 6, 12]}, " +
                    "Student{name='Ann', group=37, course=4, marks=[3, 5, 6, 5, 7]}, " +
                    "Student{name='Max', group=37, course=4, marks=[2, 3, 4, 5, 5, 6, 6]}, " +
                    "Student{name='Michel', group=46, course=5, marks=[4, 5, 6, 7, 7, 4, 2]}]";

            Assertions.assertEquals(Main.transferStudents(studentList).toString(), truthResult);
        }

        @Test
        @DisplayName("Test 2")
        void transferStudentTest2() {

            var student0 = new Student("Leon", 31, 3, new int[]{1, 2, 3, 4, 5});
            var student1 = new Student("Ben", 32, 3, new int[]{1, 2, 3, 2});
            var student2 = new Student("Cris", 33, 3, new int[]{3, 1, 2, 3, 1});
            var student3 = new Student("Max", 44, 4, new int[]{2, 3, 4, 1, 1, 1, 6});
            var student4 = new Student("Michel", 45, 4, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));
            var truthResult = "[" +
                    "Student{name='Leon', group=31, course=4, marks=[1, 2, 3, 4, 5]}, " +
                    "Student{name='Michel', group=45, course=5, marks=[4, 5, 6, 7, 7, 4, 2]}]";

            Assertions.assertEquals(Main.transferStudents(studentList).toString(), truthResult);
        }

        @Test
        @DisplayName("Test 3")
        void transferStudentTest3() {

            var student0 = new Student("Mark", 11, 1, new int[]{5, 5, 3, 4, 5});
            var student1 = new Student("Philip", 22, 2, new int[]{6, 2, 3, 6});
            var student2 = new Student("Luna", 33, 3, new int[]{4, 5, 2, 3, 4});
            var student3 = new Student("Leona", 44, 4, new int[]{2, 3, 4, 1, 1, 1, 6});
            var student4 = new Student("Duck", 55, 5, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));
            var truthResult = "[Student{name='Mark', group=11, course=2, marks=[5, 5, 3, 4, 5]}, " +
                    "Student{name='Philip', group=22, course=3, marks=[6, 2, 3, 6]}, " +
                    "Student{name='Luna', group=33, course=4, marks=[4, 5, 2, 3, 4]}, " +
                    "Student{name='Duck', group=55, course=6, marks=[4, 5, 6, 7, 7, 4, 2]}]";

            Assertions.assertEquals(Main.transferStudents(studentList).toString(), truthResult);
        }
    }
    
    @Nested
    @DisplayName("Print Students tests:")
    class PrintStudentsTest{

        @Test
        @DisplayName("Test 1")
        void printStudentsTest1(){

            var course = 3;

            var student0 = new Student("Alex", 36, 3, new int[]{3, 4, 5, 6, 12});
            var student1 = new Student("Pavel", 36, 3, new int[]{2, 3, 1, 2});
            var student2 = new Student("Ann", 37, 3, new int[]{3, 5, 6, 5, 7});
            var student3 = new Student("Max", 37, 3, new int[]{2, 3, 4, 5, 5, 6, 6});
            var student4 = new Student("Michel", 46, 4, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));

            Main.printStudents(studentList, course);

            var truthResult = "Alex Pavel Ann Max \n";

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 2")
        void printStudentsTest2(){

            var course = 4;

            var student0 = new Student("Leon", 31, 3, new int[]{1, 2, 3, 4, 5});
            var student1 = new Student("Ben", 32, 3, new int[]{1, 2, 3, 2});
            var student2 = new Student("Cris", 33, 3, new int[]{3, 1, 2, 3, 1});
            var student3 = new Student("Max", 44, 4, new int[]{2, 3, 4, 1, 1, 1, 6});
            var student4 = new Student("Michel", 45, 4, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));

            Main.printStudents(studentList, course);

            var truthResult = "Max Michel \n";

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 3")
        void printStudentsTest3(){

            var course = 2;

            var student0 = new Student("Mark", 11, 1, new int[]{5, 5, 3, 4, 5});
            var student1 = new Student("Philip", 22, 2, new int[]{6, 2, 3, 6});
            var student2 = new Student("Luna", 33, 3, new int[]{4, 5, 2, 3, 4});
            var student3 = new Student("Leona", 44, 4, new int[]{2, 3, 4, 1, 1, 1, 6});
            var student4 = new Student("Duck", 55, 5, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));

            Main.printStudents(studentList, course);

            var truthResult = "Philip \n";

            Assertions.assertEquals(truthResult, outContent.toString());
        }
    }

    @Nested
    @DisplayName("Print Student List tests:")
    class PrintStudentListTest{
        @Test
        @DisplayName("Test 1")
        void transferStudentTest1() {

            var student0 = new Student("Alex", 36, 3, new int[]{3, 4, 5, 6, 12});
            var student1 = new Student("Pavel", 36, 3, new int[]{2, 3, 1, 2});
            var student2 = new Student("Ann", 37, 3, new int[]{3, 5, 6, 5, 7});
            var student3 = new Student("Max", 37, 3, new int[]{2, 3, 4, 5, 5, 6, 6});
            var student4 = new Student("Michel", 46, 4, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));

            var truthResult = """
                    Name - course
                    Alex - 3
                    Pavel - 3
                    Ann - 3
                    Max - 3
                    Michel - 4
                    """;

            Main.printStudentList(studentList);

            Assertions.assertEquals(outContent.toString(), truthResult);
        }

        @Test
        @DisplayName("Test 2")
        void printStudentsTest2(){

            var student0 = new Student("Leon", 31, 3, new int[]{1, 2, 3, 4, 5});
            var student1 = new Student("Ben", 32, 3, new int[]{1, 2, 3, 2});
            var student2 = new Student("Cris", 33, 3, new int[]{3, 1, 2, 3, 1});
            var student3 = new Student("Max", 44, 4, new int[]{2, 3, 4, 1, 1, 1, 6});
            var student4 = new Student("Michel", 45, 4, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));

            Main.printStudentList(studentList);

            var truthResult = """
                    Name - course
                    Leon - 3
                    Ben - 3
                    Cris - 3
                    Max - 4
                    Michel - 4
                    """;

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 3")
        void printStudentsTest3(){

            var student0 = new Student("Mark", 11, 1, new int[]{5, 5, 3, 4, 5});
            var student1 = new Student("Philip", 22, 2, new int[]{6, 2, 3, 6});
            var student2 = new Student("Luna", 33, 3, new int[]{4, 5, 2, 3, 4});
            var student3 = new Student("Leona", 44, 4, new int[]{2, 3, 4, 1, 1, 1, 6});
            var student4 = new Student("Duck", 55, 5, new int[]{4, 5, 6, 7, 7, 4, 2});

            List<Student> studentList = new ArrayList<>(Arrays.asList(student0, student1, student2, student3, student4));

            Main.printStudentList(studentList);

            var truthResult = """
                    Name - course
                    Mark - 1
                    Philip - 2
                    Luna - 3
                    Leona - 4
                    Duck - 5
                    """;

            Assertions.assertEquals(truthResult, outContent.toString());
        }
    }

    @AfterEach
    public void restoreStreams(){
        System.setOut(originalOut);
    }
}