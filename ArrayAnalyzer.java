import java.util.*;

public class ArrayAnalyzer
{
   public static void main(String[] args)
   {
       Scanner console = new Scanner(System.in);

       System.out.print("How many numbers will you enter? >>> ");
       int arrayLength = console.nextInt();

       console.nextLine();
       double[] theArray = new double[arrayLength];
       double[] mainArray = new double[arrayLength];
       double[] theArrayTwo = new double[arrayLength];
       System.out.print("Type in numbers with space in between >>> ");

       for ( int i = 0; i < theArray.length; i++ ) {
           theArray[i] = console.nextDouble();
           mainArray[i] = theArray[i];
           theArrayTwo[i] = theArray[i];
       }
       System.out.println();

       for ( int i = 1; i < theArray.length; i++ ) {
           if (theArray[0] < theArray[i]) {
               theArray[0] = theArray[i];
           }
           else {
               theArray[i] = theArray[0];
           }
       }
       System.out.println("Largest number: " + theArray[0]);
       theArray = mainArray;

       for ( int i = 1; i < theArray.length; i++ ) {
           if (theArray[0] > theArray[i]) {
               theArray[0] = theArray[i];
           }
           else {
               theArray[i] = theArray[0];
           }
       }
       System.out.println("Smallest number: " + theArray[0]);
       theArray = theArrayTwo;

       double num = 0;
       for ( int i = 0; i < theArray.length; i++ ) {
           num += theArray[i];
       }
       double avrg = num / theArray.length;
       System.out.println("Average (rounded to tenth) : " + Math.round(avrg*10.0)/10.0);

       num = 0.0;
       for ( int i = 0; i < theArray.length; i++ ) {
           if (theArray[i] % 2.0 == 0) {
               num++;
           }
           else if ((int)theArray[i] % 2.0 == 0) {
               num++;
           }
       }
       System.out.println("Number of evens : " + (int)num);

       double numT = 0;
       double numTwo = 0;
       int streak = 0;
       int streakTest = 0;
       for ( int i = 0; i < theArray.length; i++) {
           if (numT == theArray[i]) {
               streak++;
           }
           else {
               streak = 1;
               numT = theArray[i];
           }
           if (streak > streakTest) {
               streakTest = streak;
               numTwo = numT;
           }
       }
       System.out.println("Longest repeat: " + numTwo + " is repeated " + (streak + 1) + " times");

       int increaseStreak = 1;
       int max = 1;
       int maxIndex = 0;
       increaseStreak = 1;
       max = 1;
       maxIndex = 0;
       for ( int i = 1; i < theArray.length; i++ ) {
           if (theArray[i] > theArray[i-1]) {
               increaseStreak++;
           }   
           else {
               if (max < increaseStreak) {
                   max = increaseStreak;
                   maxIndex = i - max;
               }
               increaseStreak = 1;
           }
       }
       if (max < increaseStreak) {
           max = increaseStreak;
           maxIndex = theArray.length - max;
       }
       System.out.print("Longest increasing run: ");
       for (int i = maxIndex; i < max+maxIndex; i++) {
           System.out.print(theArray[i] + " ");
       }
       System.out.println();


       increaseStreak = 1;
       max = 1;
       maxIndex = 0;
       for ( int i = 1; i < theArray.length; i++ ) {
           if (theArray[i] < theArray[i-1]) {
               increaseStreak++;
           }   
           else {
               if (max < increaseStreak) {
                   max = increaseStreak;
                   maxIndex = i - max;
               }
               increaseStreak = 1;
           }
       }
       if (max < increaseStreak) {
           max = increaseStreak;
           maxIndex = theArray.length - max;
       }
       System.out.print("Longest decreasing run: ");
       for (int i = maxIndex; i < max+maxIndex; i++) {
           System.out.print(theArray[i] + " ");
       }

   }
}
