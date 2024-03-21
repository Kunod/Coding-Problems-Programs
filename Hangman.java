
import java.util.*;
public class Hangman
{
   public static void main(String[] args)
   {
       Scanner console = new Scanner(System.in);

       //Enter secrete word

       System.out.print("Enter a secrete word >>> ");
       String str = console.nextLine();

       //char array
       char[] secretWord = str.toCharArray();
       System.out.println(Arrays.toString(secretWord));
       //System.out.print("\u000c");

       char[] displayWord = str.toCharArray();
       for (int i = 0; i < displayWord.length; i++) {
           displayWord[i] = '_' ;
       }

       int guesses = 6;
       boolean flag = false;
       boolean flagEnd = false;
       int num = 0;
       for (int i = 0; guesses != 0; i++) {
           System.out.print("Word: ");
           for (i = 0; i < displayWord.length; i++) {
               System.out.print(displayWord[i]);
               System.out.print(" ");
           }
           System.out.println();
           System.out.println("Guesses remaining: " + guesses);  
           System.out.print("Please guess a letter >>> ");
           String guessLetter = console.nextLine();
           char letter = guessLetter.charAt(0);
           for (i = 0; i < secretWord.length;) {
               if (letter == secretWord[i]) {
                   displayWord[i] = letter;
                   flag = true;
               }
               else {
                   flag = false;
               }
               i++;
           }

           if (flag == true) {
               guesses = guesses;
           }
           else {
               guesses--;
           }

           for (i = 0; i < secretWord.length; i++ ) {
               if (displayWord[i] == secretWord[i]) {
                   num++;
                   if (num == secretWord.length) {
                       System.out.print("You got it! The word was: ");
                       for (i = 0; i < displayWord.length; i++) {
                           System.out.print(secretWord[i]);
                       }
                       flagEnd = true;
                       break;
                   }
                   else {
                       flagEnd = false;

                   }
               }

           }

           num = 0;

           if (flagEnd == true) {
               break;
           }

       }

       if (guesses == 0) {
           System.out.print("\nOut of guesses! The word was: ");
           for (int i = 0; i < secretWord.length; i++) {
               System.out.print(secretWord[i]);
           }
       }
   }
}
