import java.util.*;
import java.util.Arrays;

public class DigitalBingo {
    public static void main(String[] args) {
        
        // In this program, you(the user) will be able to play bingo!.
        // The system will print out a random number, and you
        // (the user) will be given a bingo card which the system
        // will automatically fill out; it will fill out once 
        // it displays a number that your bingo card contains.
        // Once you get a row of numbers crossed off
        // (horizontally, vertically, or diagonally) you will win
        // and obtain a prize. 
        // You(the user) will be playing against the computer
        // (a bot); the bots bingo card will not be displayed
        // though... you just have to trust it ;)

        Scanner console = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            playGame(console);
            System.out.println();
            System.out.println("Would you like to play again?");
            System.out.println("\t1 = Yes\n\t2 = No");
            System.out.print("Answer: ");
            int playAgainNum = console.nextInt();
            playAgain = TrueOrFalse(playAgainNum == 1);
            if (playAgainNum == 2)
            {
                playAgain = false;
            }
            else
            {
                while (playAgainNum != 1 && playAgainNum != 2)
                {
                    System.out.println("Incorrect Input.\n");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Would you like to play again?");
                    System.out.println("\t1 = Yes\n\t2 = No");
                    System.out.print("Answer: ");
                    playAgainNum = console.nextInt();
                    System.out.println();
                    if (playAgainNum == 2)
                    {
                        playAgain = false;
                    }
                }
            } 
        }
    
        console.close();
        System.out.print('\u000C');
    }
    
    public static boolean TrueOrFalse(boolean TruFalse)
    {
        if (TruFalse == true)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    private static void playGame(Scanner console) 
    {
        
        System.out.println("\n\nHello there, welcome to Dingo(Digital Bingo)!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("You will play against the computer.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Your card will be displayed while\nyour oppenents will be kept secrete\n-you must be credulous :)");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();

        boolean playAgain = true;
        boolean playAgain2 = true;

        while (playAgain == true)
        {
            System.out.println(
                "Would you like to play a short round(9 values card) \nor a longer round(16 values card)\n\t1 = Short Round\n\t2 = Long Round");
            System.out.print("Answer: ");
            int roundChoice = console.nextInt();

            System.out.println();
            int nextBingoLine = 0;
            boolean flag = false;
            if (roundChoice == 1) {
                System.out.println("Great Choice!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Here are your numbers(bingo card): \n");
                //the array and list that I will be using to store all the bingo card values
                int[] bingoNumbers = new int[9];
                int[] bingoCard = new int[9];
                int[] bingoCard2 = new int[9];

                List<Integer> allBingoNumbers = new ArrayList<>();
                List<Integer> bingoNumbersList = new ArrayList<>();
                List<Integer> bingoNumbersList2 = new ArrayList<>();

                //prints out the numbers in the bingo numbers list in order
                for (int i = 0; i < bingoNumbers.length; i++) 
                {
                    bingoNumbers[i] = (int) (Math.random() * 18) + 1;
                    int nonRepeat = bingoNumbers[i];

                    //create  a loop which checks all the values in  bingoNumbers and sees if
                    //that number is already in there - 
                    if (bingoNumbersList.contains(nonRepeat)){
                        while (bingoNumbersList.contains(nonRepeat))
                        {
                            nonRepeat = (int) (Math.random() * 18) + 1;
                        }
                        bingoNumbersList.add(nonRepeat);
                    }
                    else
                    {
                        bingoNumbersList.add(nonRepeat);
                    }

                    bingoCard[i] = nonRepeat;
                    allBingoNumbers.add(nonRepeat);

                    if(i == 0)
                    {
                        System.out.println("_____________");
                    }

                    //print each number in rows of 5(like a bingo card)
                    if (nextBingoLine == 3 || nextBingoLine == 6 || nextBingoLine == 9)
                    {
                        System.out.print("|");
                        System.out.println();
                    }
                    if (bingoCard[i] == 1 || bingoCard[i] == 2 || bingoCard[i] == 3 || bingoCard[i] == 4 ||
                    bingoCard[i] == 5 || bingoCard[i] == 6 || bingoCard[i] == 7 || bingoCard[i] == 8 || 
                    bingoCard[i] == 9)
                    {
                        {
                            System.out.print("| " + bingoCard[i] + " "); 
                        }
                    }

                    else 
                    {
                        System.out.print("|" + bingoCard[i] + " ");
                    }

                    nextBingoLine++;
                    if (nextBingoLine == 9)
                    {
                        System.out.println("|");
                        System.out.println("-------------");
                    }
                }

                //The computers Bingo Card
                for(int i =0; i < bingoCard2.length; i++)
                {
                    int random = (int) (Math.random() * 18) + 1;

                    while(allBingoNumbers.contains(random))
                    {
                        random = (int) (Math.random() * 18) + 1;
                    }
                    allBingoNumbers.add(random);

                    bingoCard2[i] = random;
                }

                //We need to make a string array that is the same as the bingo card-
                //so we can change the values to "/"
                String[] stringCard = new String[9];

                for (int i = 0; i < stringCard.length;)
                {
                    stringCard[i] = Integer.toString(bingoCard[i]);
                    i++;
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                boolean win = false;
                boolean numSlash = false;
                boolean crisCrossWin = false;

                int counter = 0;
                int moveOn = 0;

                List<Integer> nextNumber = new ArrayList<>();

                //for loop to see if the number equals the number in the main array
                while (win == false)
                {

                    if (counter >= 1)
                    {
                        System.out.println("\nAre you ready to move on?");
                        System.out.println("\t1 = Yes\n\t2 = No(I want to quit)");
                        System.out.print("Answer: ");
                        moveOn = console.nextInt(); 
                        while(moveOn != 1 && moveOn != 2)
                        {
                            System.out.println("Invalid Input.");
                            System.out.println("\nAre you ready to move on?");
                            System.out.println("\t1 = Yes\n\t2 = No(I want to quit)");
                            System.out.print("Answer: ");
                            moveOn = console.nextInt(); 
                        }

                    }

                    //end the loop if the user wants to
                    if (moveOn == 2)
                    {
                        break;
                    }

                    if (counter == 0)
                    {
                        System.out.print("\nHere's the first number: ");
                    }
                    else if (counter >= 1) 
                    {
                        System.out.print("\nHere's the next number: "); 
                    }

                    counter++;

                    int theNumber = (int) (Math.random() * 18) + 1;
                    while (nextNumber.contains(theNumber))
                    {
                        theNumber = (int) (Math.random() * 18) + 1;
                    }
                    nextNumber.add(theNumber);

                    System.out.println(theNumber);
                    System.out.println();

                    for (int i = 0; i < bingoCard.length;)
                    {
                        if (theNumber == bingoCard[i])
                        {
                            if (theNumber >= 1 && theNumber <=9)
                            {
                                stringCard[i] = " /";
                                numSlash = true;
                            }
                            else 
                            {
                                stringCard[i] = " /";
                                numSlash = true;
                            }
                            bingoCard[i] = 0;
                        }
                        i++;
                    }
                    for (int i = 0; i < bingoCard2.length;i++)
                    {
                        if (theNumber == bingoCard2[i])
                        {
                            bingoCard2[i]=0;
                        }
                    }

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    int num =0;
                    if (numSlash == true)
                    {
                        System.out.println("Nice! You have that number.\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        for (int i = 0; i < stringCard.length;)
                        {
                            if (i==0)
                            {
                                System.out.println("_____________");
                            }
                            if (bingoCard[i] == 1 || bingoCard[i] == 2 || 
                            bingoCard[i] == 3 || bingoCard[i] == 4 ||
                            bingoCard[i] == 5 || bingoCard[i] == 6 || 
                            bingoCard[i] == 7 || bingoCard[i] == 8 || 
                            bingoCard[i] == 9) 
                            {
                                System.out.print("| " + stringCard[i] + " "); 
                            }
                            else 
                            {
                                System.out.print("|" + stringCard[i] + " ");
                            }

                            num++;
                            if (num == 3 || num == 6 || num == 9) {
                                System.out.print("|");
                                System.out.println();
                            }

                            if (num == 9)
                            {
                                System.out.println("-------------");
                            }
                            i++;

                        }

                        if (bingoCard[0] == 0 && bingoCard[1] == 0 && bingoCard[2] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        } 
                        if (bingoCard[3] == 0 && bingoCard[4] == 0 && bingoCard[5] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[6] == 0 && bingoCard[7] == 0 && bingoCard[8] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[0] == 0 && bingoCard[3] == 0 && bingoCard[6] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[1] == 0 && bingoCard[4] == 0 && bingoCard[7] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[2] == 0 && bingoCard[5] == 0 && bingoCard[8] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[0] == 0 && bingoCard[4] == 0 && bingoCard[8] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[2] == 0 && bingoCard[4] == 0 && bingoCard[6] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    else if(numSlash == false)
                    {
                        System.out.print("Awe man! You dont have that number.\n");
                        System.out.println("Your opponent got one!\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        //for the 50 number one just use a number to add every time the user doesnt have a-
                        //number becuase the computer will have it
                        for (int i = 0; i < stringCard.length;)
                        {
                            if (i==0)
                            {
                                System.out.println("_____________");
                            }
                            if (bingoCard[i] == 1 || bingoCard[i] == 2 || 
                            bingoCard[i] == 3 || bingoCard[i] == 4 ||
                            bingoCard[i] == 5 || bingoCard[i] == 6 || 
                            bingoCard[i] == 7 || bingoCard[i] == 8 || 
                            bingoCard[i] == 9) 
                            {
                                System.out.print("| " + stringCard[i] + " "); 
                            }
                            else 
                            {
                                System.out.print("|" + stringCard[i] + " ");
                            }

                            num++;
                            if (num == 3 || num == 6 || num == 9) {
                                System.out.print("|");
                                System.out.println();
                            }

                            if (num == 9)
                            {
                                System.out.println("-------------");
                            }
                            i++;

                        }

                        if (bingoCard2[0] == 0 && bingoCard2[1] == 0 && bingoCard2[2] == 0)
                        {
                            break;
                        } 
                        if (bingoCard2[3] == 0 && bingoCard2[4] == 0 && bingoCard2[5] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[6] == 0 && bingoCard2[7] == 0 && bingoCard2[8] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[0] == 0 && bingoCard2[3] == 0 && bingoCard2[6] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[1] == 0 && bingoCard2[4] == 0 && bingoCard2[7] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[2] == 0 && bingoCard2[5] == 0 && bingoCard2[8] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[0] == 0 && bingoCard2[4] == 0 && bingoCard2[8] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[2] == 0 && bingoCard2[4] == 0 && bingoCard2[6] == 0)
                        {
                            break;
                        }

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    numSlash = false;
                }

                if (crisCrossWin == true)
                {
                    System.out.println();
                    System.out.println("Great Job! You won!");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Here's your prize: ");
                    System.out.println(" ___________ ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|    1st    |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|   Place   |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|   Medal   |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|___________|");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }
                else 
                {
                    System.out.println();
                    if (moveOn == 1)
                    {
                        System.out.println("Oppenent says: \"Bingo!\"");
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Awe man! You lost.");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Here's your prize: ");

                    System.out.println(" ___________ ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|    2nd    |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|   Place   |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|   Medal   |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|___________|");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }
                playAgain = false;
            }
            else if (roundChoice == 2) 
            {
                System.out.println("Great Choice!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("Here are your numbers(bingo card): \n");
                //the array and list that I will be using to store all the bingo card values
                int[] bingoNumbers = new int[16];
                int[] bingoCard = new int[16];
                int[] bingoCard2 = new int[16];

                List<Integer> allBingoNumbers = new ArrayList<>();
                List<Integer> bingoNumbersList = new ArrayList<>();
                List<Integer> bingoNumbersList2 = new ArrayList<>();

                //prints out the numbers in the bingo numbers list in order
                for (int i = 0; i < bingoNumbers.length; i++) 
                {
                    bingoNumbers[i] = (int) (Math.random() * 32) + 1;
                    int nonRepeat = bingoNumbers[i];

                    //create  a loop which checks all the values in  bingoNumbers and sees if
                    //that number is already in there - 
                    if (bingoNumbersList.contains(nonRepeat)){
                        while (bingoNumbersList.contains(nonRepeat))
                        {
                            nonRepeat = (int) (Math.random() * 32) + 1;
                        }
                        bingoNumbersList.add(nonRepeat);
                    }
                    else
                    {
                        bingoNumbersList.add(nonRepeat);
                    }

                    bingoCard[i] = nonRepeat;
                    allBingoNumbers.add(nonRepeat);

                    if(i == 0)
                    {
                        System.out.println("_________________");
                    }

                    //print each number in rows of 5(like a bingo card)
                    if (nextBingoLine == 4 || nextBingoLine == 8 || nextBingoLine == 12 || nextBingoLine == 16)
                    {
                        System.out.print("|");
                        System.out.println();
                    }
                    if (bingoCard[i] == 1 || bingoCard[i] == 2 || bingoCard[i] == 3 || bingoCard[i] == 4 ||
                    bingoCard[i] == 5 || bingoCard[i] == 6 || bingoCard[i] == 7 || bingoCard[i] == 8 || 
                    bingoCard[i] == 9)
                    {
                        {
                            System.out.print("| " + bingoCard[i] + " "); 
                        }
                    }

                    else 
                    {
                        System.out.print("|" + bingoCard[i] + " ");
                    }

                    nextBingoLine++;
                    if (nextBingoLine == 16)
                    {
                        System.out.println("|");
                        System.out.println("-----------------");
                    }
                }

                //The computers Bingo Card
                for(int i =0; i < bingoCard2.length; i++)
                {
                    int random = (int) (Math.random() * 32) + 1;

                    while(allBingoNumbers.contains(random))
                    {
                        random = (int) (Math.random() * 32) + 1;
                    }
                    allBingoNumbers.add(random);

                    bingoCard2[i] = random;
                }

                //We need to make a string array that is the same as the bingo card-
                //so we can change the values to "/"
                String[] stringCard = new String[16];

                for (int i = 0; i < stringCard.length;)
                {
                    stringCard[i] = Integer.toString(bingoCard[i]);
                    i++;
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                boolean win = false;
                boolean numSlash = false;
                boolean crisCrossWin = false;

                int counter = 0;
                int moveOn = 0;

                List<Integer> nextNumber = new ArrayList<>();

                //for loop to see if the number equals the number in the main array
                while (win == false)
                {

                    if (counter >= 1)
                    {
                        System.out.println("\nAre you ready to move on?");
                        System.out.println("\t1 = Yes\n\t2 = No(I want to quit)");
                        System.out.print("Answer: ");
                        moveOn = console.nextInt(); 
                        while(moveOn != 1 && moveOn != 2)
                        {
                            System.out.println("Invalid Input.");
                            System.out.println("\nAre you ready to move on?");
                            System.out.println("\t1 = Yes\n\t2 = No(I want to quit)");
                            System.out.print("Answer: ");
                            moveOn = console.nextInt(); 
                        }

                    }

                    //end the loop if the user wants to
                    if (moveOn == 2)
                    {
                        break;
                    }

                    if (counter == 0)
                    {
                        System.out.print("\nHere's the first number: ");
                    }
                    else if (counter >= 1) 
                    {
                        System.out.print("\nHere's the next number: "); 
                    }

                    counter++;

                    int theNumber = (int) (Math.random() * 32) + 1;
                    while (nextNumber.contains(theNumber))
                    {
                        theNumber = (int) (Math.random() * 32) + 1;
                    }
                    nextNumber.add(theNumber);

                    System.out.println(theNumber);
                    System.out.println();

                    for (int i = 0; i < bingoCard.length;)
                    {
                        if (theNumber == bingoCard[i])
                        {
                            if (theNumber >= 1 && theNumber <=9)
                            {
                                stringCard[i] = " /";
                                numSlash = true;
                            }
                            else 
                            {
                                stringCard[i] = " /";
                                numSlash = true;
                            }
                            bingoCard[i] = 0;
                        }
                        i++;
                    }
                    for (int i = 0; i < bingoCard2.length;i++)
                    {
                        if (theNumber == bingoCard2[i])
                        {
                            bingoCard2[i]=0;
                        }
                    }

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    int num =0;
                    if (numSlash == true)
                    {
                        System.out.println("Nice! You have that number.\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        for (int i = 0; i < stringCard.length;)
                        {
                            if (i==0)
                            {
                                System.out.println("_________________");
                            }
                            if (bingoCard[i] == 1 || bingoCard[i] == 2 || 
                            bingoCard[i] == 3 || bingoCard[i] == 4 ||
                            bingoCard[i] == 5 || bingoCard[i] == 6 || 
                            bingoCard[i] == 7 || bingoCard[i] == 8 || 
                            bingoCard[i] == 9) 
                            {
                                System.out.print("| " + stringCard[i] + " "); 
                            }
                            else 
                            {
                                System.out.print("|" + stringCard[i] + " ");
                            }

                            num++;
                            if (num == 4 || num == 8 || num == 12 || num == 16) {
                                System.out.print("|");
                                System.out.println();
                            }

                            if (num == 16)
                            {
                                System.out.println("-----------------");
                            }
                            i++;

                        }

                        if (bingoCard[0] == 0 && bingoCard[1] == 0 && bingoCard[2] == 0 && bingoCard[3] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        } 
                        if (bingoCard[4] == 0 && bingoCard[5] == 0 && bingoCard[6] == 0 && bingoCard[7] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[8] == 0 && bingoCard[9] == 0 && bingoCard[10] == 0 && bingoCard[11] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[12] == 0 && bingoCard[13] == 0 && bingoCard[14] == 0 && bingoCard[15] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[0] == 0 && bingoCard[4] == 0 && bingoCard[8] == 0 && bingoCard[12] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[1] == 0 && bingoCard[5] == 0 && bingoCard[9] == 0 && bingoCard[13] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[2] == 0 && bingoCard[6] == 0 && bingoCard[10] == 0 && bingoCard[14] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[3] == 0 && bingoCard[7] == 0 && bingoCard[11] == 0 && bingoCard[15] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[0] == 0 && bingoCard[5] == 0 && bingoCard[10] == 0 && bingoCard[15] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }
                        if (bingoCard[3] == 0 && bingoCard[6] == 0 && bingoCard[9] == 0 && bingoCard[12] == 0)
                        {
                            crisCrossWin = true;
                            break;
                        }

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    else if(numSlash == false)
                    {
                        System.out.print("Awe man! You dont have that number.\n");
                        System.out.println("Your opponent got one!\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        //for the 50 number one just use a number to add every time the user doesnt have a-
                        //number becuase the computer will have it
                        for (int i = 0; i < stringCard.length;)
                        {
                            if (i==0)
                            {
                                System.out.println("_________________");
                            }
                            if (bingoCard[i] == 1 || bingoCard[i] == 2 || 
                            bingoCard[i] == 3 || bingoCard[i] == 4 ||
                            bingoCard[i] == 5 || bingoCard[i] == 6 || 
                            bingoCard[i] == 7 || bingoCard[i] == 8 || 
                            bingoCard[i] == 9) 
                            {
                                System.out.print("| " + stringCard[i] + " "); 
                            }
                            else 
                            {
                                System.out.print("|" + stringCard[i] + " ");
                            }

                            num++;
                            if (num == 4 || num == 8 || num == 12 || num == 16) {
                                System.out.print("|");
                                System.out.println();
                            }

                            if (num == 16)
                            {
                                System.out.println("-----------------");
                            }
                            i++;

                        }

                        if (bingoCard2[0] == 0 && bingoCard2[1] == 0 && bingoCard2[2] == 0 && bingoCard2[3] == 0)
                        {
                            break;
                        } 
                        if (bingoCard2[4] == 0 && bingoCard2[5] == 0 && bingoCard2[6] == 0 && bingoCard2[7] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[8] == 0 && bingoCard2[9] == 0 && bingoCard2[10] == 0 && bingoCard2[11] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[12] == 0 && bingoCard2[13] == 0 && bingoCard2[14] == 0 && bingoCard2[15] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[0] == 0 && bingoCard2[4] == 0 && bingoCard2[8] == 0 && bingoCard2[12] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[1] == 0 && bingoCard2[5] == 0 && bingoCard2[9] == 0 && bingoCard2[13] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[2] == 0 && bingoCard2[6] == 0 && bingoCard2[10] == 0 && bingoCard2[14] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[3] == 0 && bingoCard2[7] == 0 && bingoCard2[11] == 0 && bingoCard2[15] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[0] == 0 && bingoCard2[5] == 0 && bingoCard2[10] == 0 && bingoCard2[15] == 0)
                        {
                            break;
                        }
                        if (bingoCard2[3] == 0 && bingoCard2[6] == 0 && bingoCard2[9] == 0 && bingoCard2[12] == 0)
                        {
                            break;
                        }

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    numSlash = false;
                }

                if (crisCrossWin == true)
                {
                    System.out.println();
                    System.out.println("Great Job! You won!");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Here's your prize: ");
                    System.out.println(" ___________ ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|    1st    |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|   Place   |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|   Medal   |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|___________|");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                }
                else 
                {
                    System.out.println();
                    if (moveOn == 1)
                    {
                        System.out.println("Oppenent says: \"Bingo!\"");
                    }

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Awe man! You lost.");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Here's your prize: ");

                    System.out.println(" ___________ ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|    2nd    |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|   Place   |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|   Medal   |");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("|___________|");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }


                }
                playAgain = false;
            }
        }

    }
}
