import java.util.*;
public class TShirtLauncher
{
   public static void main(String[] args)
   {
       Scanner console = new Scanner(System.in);

       System.out.print("Enter launch velocity (m/s) >>> ");
       double launchVelocity = console.nextDouble();
       System.out.print("Enter launch angle (degrees) >>> ");
       double launchAngle = console.nextDouble();

       System.out.println();
       System.out.println("Projectile's path:");
       double theTime = 0;
       double two = 2;
       double xpos = Math.cos(Math.toRadians(launchAngle)) * theTime * launchVelocity;
       double ypos = Math.sin(Math.toRadians(launchAngle)) * theTime * launchVelocity - 0.5 * 9.8 * Math.pow(theTime, two);
       double zero = 0;
       System.out.println("Time: " + (int)theTime + " seconds");
       System.out.println("\tx-pos: " + xpos + " meters");
       System.out.println("\ty-pos: " + zero + " meters");

       theTime = 1;
       xpos = Math.cos(Math.toRadians(launchAngle)) * theTime * launchVelocity;
       ypos = Math.sin(Math.toRadians(launchAngle)) * theTime * launchVelocity - 0.5 * 9.8 * Math.pow(theTime, two);
       System.out.println("Time: " + (int)theTime + " seconds");
       if (ypos < 0) {
               ypos = 0.0;
           }
       System.out.println("\tx-pos: " + xpos + " meters");
       System.out.println("\ty-pos: " + ypos + " meters");

       while (ypos > 0) {
           theTime++;
           xpos = Math.cos(Math.toRadians(launchAngle)) * theTime * launchVelocity;
           ypos = Math.sin(Math.toRadians(launchAngle)) * theTime * launchVelocity - 0.5 * 9.8 * Math.pow(theTime, two);
           System.out.println("Time: " + (int)theTime + " seconds");
           if (ypos < 0) {
               ypos = 0.0;
           }
           System.out.println("\tx-pos: " + xpos + " meters");
           System.out.println("\ty-pos: " + ypos + " meters");
           }
   }
}