import java.util.Scanner;
import java.util.Random;

public class numberguess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int minnum = 1;
        int maxnum = 100;
        int randomnum = random.nextInt(maxnum - minnum + 1) + minnum;
        int attempts = 0;
        int maxattempts = 5;
        int score = 100;

        System.out.println("Welcome to Guess the Number");
        System.out.println("I have selected a number from " + minnum + " and " + maxnum + ". Try to guess the number.");

        while (attempts < maxattempts) {
            System.out.print("Enter the number: ");
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                attempts++;

                if (number == randomnum) {
                    System.out.println("Congratulations! Your number is correct, and you guessed the number in " + attempts + " attempts.");
                    break;
                } else if (number < randomnum) {
                    System.out.println("The number is greater than your guess! Try again.");
                } else {
                    System.out.println("The number is smaller than your guess! Try again.");
                }
                score -= 20;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); 
            }
        }

        if (attempts == maxattempts) {
            System.out.println("You have run out of attempts. The number was " + randomnum + ".");
        }

        System.out.println("Your score is: " + score);
        sc.close();
    }
}
