import java.util.*;

public class Pendulum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int choice;
        double pendLength;
        double pendPeriod;
        boolean exit = false;

        do {
            System.out.println("\nWelcome to the Pendulum Simulator");
            System.out.println("1. Calculate period from length");
            System.out.println("2. Calculate length from period");
            System.out.println("3. Compare different pendulum lengths");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            choice = console.nextInt();
            console.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter pendulum length in meters: ");
                    pendLength = readDouble(console);
                    if (pendLength > 0) {
                        pendPeriod = calculatePeriod(pendLength);
                        System.out.printf("For a length of %.2fm, the pendulum's period is %.2f seconds.\n",
                                pendLength, pendPeriod);
                    }
                    break;
                case 2:
                    System.out.print("Enter pendulum period in seconds: ");
                    pendPeriod = readDouble(console);
                    if (pendPeriod > 0) {
                        pendLength = calculateLength(pendPeriod);
                        System.out.printf("For a period of %.2f seconds, the pendulum's length is %.2f meters.\n",
                                pendPeriod, pendLength);
                    }
                    break;
                case 3:
                    System.out.print("Enter first pendulum length in meters >>> ");
                    double length1 = readDouble(console);
                    System.out.print("Enter second pendulum length in meters >>> ");
                    double length2 = readDouble(console);

                    if (length1 > 0 && length2 > 0) {
                        double period1 = calculatePeriod(length1);
                        double period2 = calculatePeriod(length2);

                        System.out.printf("For a length of %.2fm, the pendulum's period is %.2f seconds.\n", length1, period1);
                        System.out.printf("For a length of %.2fm, the pendulum's period is %.2f seconds.\n", length2, period2);

                        if (period1 < period2) {
                            System.out.printf("The pendulum with length %.2fm has a shorter period.\n", length1);
                        } else if (period1 > period2) {
                            System.out.printf("The pendulum with length %.2fm has a shorter period.\n", length2);
                        } else {
                            System.out.println("Both pendulums have the same period.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Goodbye.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }

        } while (!exit);

        console.close();
    }

    private static double readDouble(Scanner console) {
        while (true) {
            try {
                return console.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                console.next(); // Clear the invalid input
            }
        }
    }

    private static double calculatePeriod(double length) {
        return 2 * Math.PI * Math.sqrt(length / 9.8);
    }

    private static double calculateLength(double period) {
        return Math.pow(period / (2 * Math.PI), 2) * 9.8;
    }
}
