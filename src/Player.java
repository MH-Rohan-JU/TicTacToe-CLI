import java.util.Scanner;

public class Player {
    private String name;
    private Byte age;
    private char gender;
    private String country;

    public Player() {
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public char getGender() {
        return this.gender;
    }

    public String getCountry() {
        return this.country;
    }

    Scanner sc = new Scanner(System.in);

    public void input() {
        System.out.print("Player's Name: ");
        this.name = sc.nextLine();
        System.out.print("Player's Age: ");
        this.age = sc.nextByte();
//        sc.nextLine();
        System.out.print("Male or Female [m/f]: ");
        this.gender = sc.next().charAt(0);
        sc.nextLine();
        System.out.print("Player's Country: ");
        this.country = sc.nextLine();
    }

    public void displayInfo() {
        System.out.println("Name: \t" + name);
        System.out.println("Age:\t" + age);
        System.out.println("Gender: " + ((gender == 'm' || gender == 'M') ? "Male" : "Female"));
        System.out.println("Country:" + country);
    }
}
