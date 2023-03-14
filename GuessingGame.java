import java.util.Scanner;
import java.util.Random;

public class GuessingGame 
{
   public static void main(String[] args) 
   {

    Random rand = new Random();
    int randomNumber = rand.nextInt(100) + 1;

    int userGuess;
    int numGuesses = 0;
    boolean win = false;

    Scanner input = new Scanner(System.in);

    System.out.println("I'm thinking of a number between 1 and 100. Can you guess what it is?");

    while (numGuesses < 10) 
    {
        System.out.print("Enter your guess: ");
        userGuess = input.nextInt();
        numGuesses++;
        
        if (userGuess == randomNumber) 
        {
            System.out.println("Congratulations, you guessed the number in " + numGuesses + " tries!");
            win = true;
            break;
        }
        
        else if (userGuess < randomNumber) 
        {
            System.out.println("Your guess is too low. Guess higher.");
        }
        
        else 
        {
            System.out.println("Your guess is too high. Guess lower.");
        }
    }
    if (!win) 
      {
        System.out.println("Sorry, you didn't guess the number. The correct number was " + randomNumber + ".");
      }
   }
}
