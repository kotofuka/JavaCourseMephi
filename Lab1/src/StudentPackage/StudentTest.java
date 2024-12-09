package StudentPackage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Nested
    @DisplayName("Upgrade Course tests:")
    class UpgradeCourseTest{

        @Test
        @DisplayName("Truth test 1")
        void upgradeCourseTruthTest1(){
            assertTrue((new Student("Alex", 32, 3, new int[]{1, 2, 3, 4, 5, 5, 5, 5})).tryUpgradeCourse());
        }

        @Test
        @DisplayName("Truth test 2")
        void upgradeCourseTruthTest2(){
            assertTrue((new Student("Leon", 36, 3, new int[]{3, 3, 3})).tryUpgradeCourse());
        }

        @Test
        @DisplayName("Truth test 3")
        void upgradeCourseTruthTest3(){
            assertTrue((new Student("Cris", 42, 4, new int[]{4, 5, 1, 3})).tryUpgradeCourse());
        }

        @Test
        @DisplayName("Exception test")
        void upgradeCourseExceptionTest(){
            assertThrows(ArithmeticException.class, () ->(new Student("Steven", 42, 3, new int[]{})).tryUpgradeCourse());
        }

        @Test
        @DisplayName("False test 1")
        void upgradeCourseFalseTest1(){
            assertFalse((new Student("Ann", 35, 3, new int[]{1, 2, 3, 4})).tryUpgradeCourse());
        }

        @Test
        @DisplayName("False test 2")
        void upgradeCourseFalseTest2(){
            assertFalse((new Student("Leon", 46, 4, new int[]{3, 3, 1})).tryUpgradeCourse());
        }

        @Test
        @DisplayName("False test 3")
        void upgradeCourseFalseTest3(){
            assertFalse((new Student("Cris", 42, 4, new int[]{2, 3, 1, 3})).tryUpgradeCourse());
        }
    }

}