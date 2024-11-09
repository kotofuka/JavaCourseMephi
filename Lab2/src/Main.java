import UserPackage.User;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // объявление начальных данных
        int someConst = 7;

        var user = new User("Pavel", "Khristenko", 20, "Russia");
        var user1 = new User("Michel", "Mars", 21, "USA");
        var user2 = new User("Ann", "Hope", 22, "Germany");
        var user3 = new User("German", "Fauls", 19, "Germany");

        // создается список User'ов
        List <User> users = new ArrayList<>(Arrays.asList(user, user1, user2, user3));

        // метод печатает пользователей в отсортированном по фамилии порядке
        printUsersOrderedLastName(users);

        // метод печатает пользователей в отсортированном по фамилии порядке
        printUsersOrderedAge(users);

        // метод печатает пользователей в отсортированном по возрасту порядке
        System.out.printf("\nПроверка, что все пользователи в списке достигли возраста '%d': %b\n",
                someConst, ageAllUsersInListAboveConst(users, someConst));

        // печатается средний возраст пользователей из списка
        System.out.println("\nСредний возраст пользователей: " + averageAgeUsers(users));

        // печатается количество различных стран среди пользователей
        System.out.println("\nКоличество различных стран: " + numberDiffCountriesOfUsers(users));
    }

    // метод для вывода в строку имен пользователей в списке
    public static void printUsers(List <User> users){
        for (var user: users){
            System.out.print(user.getFirstName() + " ");
        }
    }

    // метод для вывода в консоль пользователей в отсортированном по фамилии порядке
    public static void printUsersOrderedLastName(List<User> users){
        System.out.println("\nСписок пользователей отсортированный по фамилии (id: Имя Фамилия (Возраст))");
        users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(x -> System.out.println(x.getInfo()));

    }

    // метод для вывода в консоль пользователей в отсортированном по возрасту порядке
    public static void printUsersOrderedAge(List<User> users){
        System.out.println("\nСписок пользователей отсортированный по возрасту (id: Имя Фамилия (Возраст))");
        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(x -> System.out.println(x.getInfo()));
    }

    // метод определяет, что возраст всех пользователей в списке > someConst
    public static boolean ageAllUsersInListAboveConst(List <User> users, int someConst){
        return users.stream().allMatch(x -> x.getAge() > someConst);
    }

    // метод по подсчету среднего возраста пользователей
    public static double averageAgeUsers(List <User> users){
        return !users.isEmpty() ? users.stream().mapToInt(User::getAge).average().getAsDouble() : 0;
    }

    // метод определяет количество различных стран пользователей
    public static int numberDiffCountriesOfUsers(List <User> users){
        List <String> countryList = new ArrayList<>();
        return (int) users.stream().map(User::getCountry).distinct().count();
    }
}