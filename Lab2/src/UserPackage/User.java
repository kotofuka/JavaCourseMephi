package UserPackage;

public class User {
    private static int lastId = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private int age;
    private String country;

    public User(String firstName, String lastName, int age, String country) {
        this.id = lastId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
    }

    public String getInfo(){
        return String.format("%d: %s %s (%d)", getId(), getFirstName(), getLastName(), getAge());
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
