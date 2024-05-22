import java.util.Random;

public class ActsOfKindness {

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 50);
        Person p2 = new Person("Bob", 50);

        System.out.println("Initial States:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println();

        System.out.println("Acts of Kindness:");
        p1.actOfKindness(p2);
        p2.actOfKindness(p1);
        p1.actOfKindness(p2);
        p2.actOfKindness(p1);

        System.out.println();

        System.out.println("Final States:");
        System.out.println(p1);
        System.out.println(p2);
    }
}

class Person {
    private String name;
    private int happiness;

    public Person(String n, int h) {
        name = n;
        happiness = h;
    }

    public void actOfKindness(Person other) {
        Random randomGen = new Random();
        int amount = randomGen.nextInt(21) + 10; 
        if (amount <= 17) {
            System.out.println(name + " hugs " + other.name + " (+" + amount + " happiness)");
        } else if (amount <= 24) {
            System.out.println(name + " compliments " + other.name + "'s shoes (+" + amount + " happiness)");
        } else {
            System.out.println(name + " helps " + other.name + " with homework. (+" + amount + " happiness)");
        }
        other.happiness += amount;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    @Override
    public String toString() {
        return name + " (" + happiness + " happiness)";
    }
}
