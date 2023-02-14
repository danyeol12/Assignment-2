package rng;
import java.util.Scanner;

public class RandomNumberGuesser {
	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		String answer;
		int randNum;
		do {
			int nextGuess, lowGuess=0, highGuess=100;
			System.out.println("Enter your first guess");
			
			randNum = RNG.rand();
			do {
				RNG rng = new RNG();
				nextGuess = input.nextInt();
				System.out.println("Number of guesses is "+RNG.getCount()+"\n");
				if(nextGuess>randNum) {
					if(nextGuess>=highGuess || nextGuess<=lowGuess) {
						RNG.inputValidation(nextGuess, lowGuess, highGuess);
					}
					else {
						highGuess=nextGuess;
						System.out.println("Your guess is too high\nEnter your next guess between " + lowGuess + " and " + highGuess );
					
					}
				}else if(nextGuess<randNum) {
					if(nextGuess>=highGuess || nextGuess<=lowGuess) {
						RNG.inputValidation(nextGuess, lowGuess, highGuess);
					}
					else {
						lowGuess=nextGuess;
						System.out.println("Your guess is too low\nEnter your next guess between " + lowGuess + " and " + highGuess);
					}
					
				}
				
			}while(nextGuess!=randNum);
			RNG.resetCount();
			System.out.println("Congratulations, you guessed correctly\nTry again? (yes or no)");
			answer = input.next();
		}while(answer.equals("yes"));
		System.out.println("Thanks for playing...");
		
	}

}
