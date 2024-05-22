import java.util.Random;

public class BoxerMatch {

    public static void main(String[] args) {
        Boxer b1 = new Boxer("Fred", 100);
        Boxer b2 = new Boxer("George", 100);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println("FIGHT!!!! \n");

        Random randomGen = new Random();

        while (b1.getHealth() > 0 && b2.getHealth() > 0) {
            if (randomGen.nextBoolean()) {
                b1.punch(b2);
            } else {
                b2.punch(b1);
            }
            System.out.println(b1 + " ::: " + b2 + "\n");
        }

        // Announce the winner
        if (b1.getHealth() > 0) {
            System.out.println("The winner by knockout is..... " + b1.getName());
        } else {
            System.out.println("The winner by knockout is..... " + b2.getName());
        }

        System.out.println();
        System.out.println("Match Statistics: ");
        System.out.println("Punches Thrown\t\t" + b1.getName() + ": " + b1.getPunchCount() + "\t" + b2.getName() + ": " + b2.getPunchCount());
        System.out.println("Damage Caused\t\t" + b1.getName() + ": " + b1.getDamageCaused() + "\t" + b2.getName() + ": " + b2.getDamageCaused());
    }
}

class Boxer {
    private String name;
    private int health;
    private int punchCount;
    private int damageCaused;

    public Boxer(String name, int health) {
        this.name = name;
        this.health = health;
        this.punchCount = 0;
        this.damageCaused = 0;
    }

    public void punch(Boxer other) {
        Random randomGen = new Random();
        int amount = randomGen.nextInt(10) + 1;
        punchCount++;
        damageCaused += amount;

        if (amount < 4) {
            System.out.print(name + " nails " + other.name + " with a left hook. ");
        } else if (amount < 8) {
            System.out.print(name + " smacks " + other.name + " with a right jab. ");
        } else {
            System.out.print(name + " destroys " + other.name + " with an uppercut. ");
        }
        System.out.println("Power: " + amount);

        other.health -= amount;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getPunchCount() {
        return punchCount;
    }

    public int getDamageCaused() {
        return damageCaused;
    }

    @Override
    public String toString() {
        return name + " (Health: " + health + ")";
    }
}
