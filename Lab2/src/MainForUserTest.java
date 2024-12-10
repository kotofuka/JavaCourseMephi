import UserPackage.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

class MainForUserTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream outDefault = System.out;

    public static ArrayList<User> userListTest1;
    public static ArrayList<User> userListTest2;
    public static ArrayList<User> userListTest3;

    @BeforeEach
    public void setUpStream(){
        System.setOut(new PrintStream(outContent));
    }

    @BeforeAll
    public static void initializeTestLists(){
        var user0 = new User("Pavel", "Khristenko", 20, "Russia");
        var user1 = new User("Michel", "Mars", 21, "USA");
        var user2 = new User("Ann", "Hope", 22, "Germany");
        var user3 = new User("German", "Fauls", 19, "Germany");

        userListTest1 = new ArrayList<>(Arrays.asList(user0, user1, user2, user3));

        user0 = new User("Cris", "Anderson", 20, "USA");
        user1 = new User("Mel", "Grinch", 32, "Canada");
        user2 = new User("Leon", "Miles", 14, "French");
        user3 = new User("Angel", "Brightness", 19, "Canada");

        userListTest2 = new ArrayList<>(Arrays.asList(user0, user1, user2, user3));

        user0 = new User("Kristian", "Beaufort", 34, "French");
        user1 = new User("Adam", "Bois", 38, "French");
        user2 = new User("Claire", "Boucher", 24, "French");
        user3 = new User("Garcia", "Rodriguez", 56, "Mexico");

        userListTest3 = new ArrayList<>(Arrays.asList(user0, user1, user2, user3));
    }

    @Nested
    @DisplayName("Print users tests:")
    class PrintUsersTest {

        @Test
        @DisplayName("Test 1")
        void printUsersTest1(){

            var truthResult = "Pavel Michel Ann German ";

            Main.printUsers(userListTest1);

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 2")
        void printUsersTest2(){

            var truthResult = "Cris Mel Leon Angel ";

            Main.printUsers(userListTest2);

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 3")
        void printUsersTest3(){

            var truthResult = "Kristian Adam Claire Garcia ";

            Main.printUsers(userListTest3);

            Assertions.assertEquals(truthResult, outContent.toString());
        }
    }

    @Nested
    @DisplayName("Print users ordered lastName test:")
    class printUsersOrderedLastNameTest {

        @Test
        @DisplayName("Test 1")
        void printUsersOrderedLastNameTest1(){
            var truthResult = """
                    
                    Список пользователей отсортированный по фамилии (id: Имя Фамилия (Возраст))
                    3: German Fauls (19)
                    2: Ann Hope (22)
                    0: Pavel Khristenko (20)
                    1: Michel Mars (21)
                    """;

            Main.printUsersOrderedLastName(userListTest1);

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 2")
        void printUsersOrderedLastNameTest2(){

            var truthResult = """
                    
                    Список пользователей отсортированный по фамилии (id: Имя Фамилия (Возраст))
                    4: Cris Anderson (20)
                    7: Angel Brightness (19)
                    5: Mel Grinch (32)
                    6: Leon Miles (14)
                    """;

            Main.printUsersOrderedLastName(userListTest2);

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 3")
        void printUsersOrderedLastNameTest3(){

            var truthResult = """
                    
                    Список пользователей отсортированный по фамилии (id: Имя Фамилия (Возраст))
                    8: Kristian Beaufort (34)
                    9: Adam Bois (38)
                    10: Claire Boucher (24)
                    11: Garcia Rodriguez (56)
                    """;

            Main.printUsersOrderedLastName(userListTest3);

            Assertions.assertEquals(truthResult, outContent.toString());
        }
    }

    @Nested
    @DisplayName("Print users ordered Age tests:")
    class printUsersOrderedAgeTest {

        @Test
        @DisplayName("Test 1")
        void printUsersOrderedLastNameTest1(){

            var truthResult = """
                    
                    Список пользователей отсортированный по возрасту (id: Имя Фамилия (Возраст))
                    3: German Fauls (19)
                    0: Pavel Khristenko (20)
                    1: Michel Mars (21)
                    2: Ann Hope (22)
                    """;

            Main.printUsersOrderedAge(userListTest1);

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 2")
        void printUsersOrderedLastNameTest2(){

            var truthResult = """
                    
                    Список пользователей отсортированный по возрасту (id: Имя Фамилия (Возраст))
                    6: Leon Miles (14)
                    7: Angel Brightness (19)
                    4: Cris Anderson (20)
                    5: Mel Grinch (32)
                    """;

            Main.printUsersOrderedAge(userListTest2);

            Assertions.assertEquals(truthResult, outContent.toString());
        }

        @Test
        @DisplayName("Test 3")
        void printUsersOrderedLastNameTest3(){

            var truthResult = """
                    
                    Список пользователей отсортированный по возрасту (id: Имя Фамилия (Возраст))
                    10: Claire Boucher (24)
                    8: Kristian Beaufort (34)
                    9: Adam Bois (38)
                    11: Garcia Rodriguez (56)
                    """;

            Main.printUsersOrderedAge(userListTest3);

            Assertions.assertEquals(truthResult, outContent.toString());
        }
    }

    @Nested
    @DisplayName("Age all users in list above const tests:")
    class AgeAllUsersInListAboveConstTest {
        @Test
        @DisplayName("Test 1")
        void ageAllUsersInListAboveConstTest1(){

            var someConst = 20;

            Assertions.assertFalse(Main.ageAllUsersInListAboveConst(userListTest1, someConst));
        }

        @Test
        @DisplayName("Test 2")
        void ageAllUsersInListAboveConstTest2(){

            var someConst = 12;

            Assertions.assertTrue(Main.ageAllUsersInListAboveConst(userListTest2, someConst));
        }

        @Test
        @DisplayName("Test 3")
        void ageAllUsersInListAboveConstTest3(){

            var someConst = 30;

            Assertions.assertFalse(Main.ageAllUsersInListAboveConst(userListTest3, someConst));
        }
    }

    @Nested
    @DisplayName("Average age users tests:")
    class AverageAgeUsersTest {
        @Test
        @DisplayName("Test 1")
        void averageAgeUsersTest1(){

            var someConst = 20.5;

            Assertions.assertEquals(someConst, Main.averageAgeUsers(userListTest1));
        }

        @Test
        @DisplayName("Test 2")
        void averageAgeUsersTest2(){

            var someConst = 21.25;

            Assertions.assertEquals(someConst, Main.averageAgeUsers(userListTest2));
        }

        @Test
        @DisplayName("Test 3")
        void averageAgeUsersTest3(){

            var someConst = 38.0;

            Assertions.assertEquals(someConst, Main.averageAgeUsers(userListTest3));
        }
    }

    @Nested
    @DisplayName("Number different countries of users tests:")
    class NumberDiffCountriesOfUsersTest{
        @Test
        @DisplayName("Test 1")
        void numberDiffCountriesOfUsersTest1(){

            var someConst = 3;

            Assertions.assertEquals(someConst, Main.numberDiffCountriesOfUsers(userListTest1));
        }

        @Test
        @DisplayName("Test 2")
        void numberDiffCountriesOfUsersTest2(){

            var someConst = 3;

            Assertions.assertEquals(someConst, Main.numberDiffCountriesOfUsers(userListTest2));
        }

        @Test
        @DisplayName("Test 3")
        void numberDiffCountriesOfUsersTest3(){

            var someConst = 2;

            Assertions.assertEquals(someConst, Main.numberDiffCountriesOfUsers(userListTest3));
        }
    }

    @AfterEach
    public void restoreStream(){
        System.setOut(outDefault);
    }
}