import java.util.Scanner;
public class BackAccount {  
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double amt = 0;
        System.out.println("(1) Deposit Funds");
        System.out.println("(2) Withdraw Cash");
        System.out.print("What would you like to do? >>> ");
        int choice = console.nextInt();
        System.out.println();
        while (choice != 1 && choice != 2)
        {
            System.out.println("Incorrect input." + "\n");
            System.out.println("(1) Deposit Funds");
            System.out.println("(2) Withdraw Cash");
            System.out.print("What would you like to do? >>> ");
            choice = console.nextInt();
            System.out.println();
        }
        if(choice == 1) 
        {
            System.out.print("Enter amount >>> $");
            amt += console.nextDouble();
            System.out.print("Deposit successful. Account details: $" );
            System.out.println(amt + "\n");
        }
        else if (choice == 2) 
        {
            System.out.print("Enter amount >>> $");
            amt -= console.nextDouble();
            System.out.print("Withdraw successful. Account details: $" );
            System.out.println(amt + "\n");
        }

        System.out.print("Perform another transaction? (y/n) >>> ");
        console.nextLine();
        String pat = console.nextLine();
        System.out.println();

        while (!pat.equals("y") && !pat.equals("n"))
        {
            System.out.println("Incorrect input." + "\n");
            System.out.print("Perform another transaction? (y/n) >>> ");
            pat = console.nextLine();
            System.out.println();
        }

        while (pat.equals("y")) {
            System.out.println("(1) Deposit Funds");
            System.out.println("(2) Withdraw Cash");
            System.out.print("What would you like to do? >>> ");
            choice = console.nextInt();
            System.out.println();
            while (choice != 1 && choice != 2)
            {
                System.out.println("Incorrect input." + "\n");
                System.out.println("(1) Deposit Funds");
                System.out.println("(2) Withdraw Cash");
                System.out.println();
                System.out.print("What would you like to do? >>> ");
                choice = console.nextInt();
            }
            if(choice == 1) 
            {
                System.out.print("Enter amount >>> $");
                amt += console.nextDouble();
                System.out.print("Deposit successful. Account details: $" );
                System.out.println(amt + "\n");
            }
            else 
            {
                System.out.print("Enter amount >>> $");
                amt -= console.nextDouble();
                System.out.print("Withdraw successful. Account details: $" );
                System.out.println(amt + "\n");
            }
            System.out.print("Perform another transaction? (y/n) >>> ");
            console.nextLine();
            pat = console.nextLine();
            System.out.println();
            while (!pat.equals("y") && !pat.equals("n"))
            {
                System.out.println("Incorrect input." + "\n");
                System.out.print("Perform another transaction? (y/n) >>> ");
                pat = console.nextLine();
                System.out.println();
            }
        }
    }
}
