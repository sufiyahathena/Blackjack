package edu.nyu.cs;

import java.util.Scanner;

/**
 * A variation of the game of Blackjack.  
 * Complete this program according to the instructions in the README.md file as well as within the given comments below.
 */
public class Blackjack {

  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {
    // complete this function according to the instructions
    Scanner input = new Scanner(System.in);

    boolean continueOn = true;
		boolean continuedealer = true;
		int count = 0;

    int total = 21;

    System.out.println("Welcome to Blackjack!");

    int ucard1 = (int) (2 + Math.random() * 10);
		int ucard2 = (int) (2 + Math.random() * 10);
		int user_total = ucard1 + ucard2;

		int dcard1 = (int) (2 + Math.random() * 10);
		int dcard2 = (int) (2 + Math.random() * 10);
		int dealer_total = dcard1 + dcard2;
		
		int dealer_stop = (int) (16 + Math.random() * 3);

    String printedLine = ("Your cards are: " + Integer.toString(ucard1) + ", " + Integer.toString(ucard2));
		System.out.println(printedLine);

    String printedDealer = ("The dealers cards are: " + Integer.toString(dcard1) + ", " + Integer.toString(dcard2));

    while (continueOn) {
			// creates new card each loop if hit
			System.out.println("Would you like to hit or stand (can also type in 'stop' or 'pass')?");
			String answer = input.next();
			int newCard;
			
			if (user_total > total) {
				continueOn = false;
				continuedealer = false;
				break;

			} else if (answer.equals("stand") || answer.equals("stop") || answer.equals("pass")) {
				continueOn = false;
				break;
				
			} else {
				newCard = (int) (2 + Math.random() * 10);
				user_total += newCard;
				printedLine = printedLine.concat(", " + Integer.toString(newCard));
				System.out.println(printedLine);
				
				if (user_total > total) {
					continueOn = false;
					System.out.println("You have bust!");
					System.out.println("Dealer wins!");
					continuedealer = false;
					count = 1;
				}
			}
		}

    while (continuedealer) {
			int newestCard;

			if (dealer_total > total) {
				System.out.println("The dealer stands.");
				continuedealer = false;
				break;
			} else if (dealer_total >= dealer_stop) {
				System.out.println("The dealer stands.");
				continuedealer = false;
			} else {
				System.out.println("The dealer hits.");
				newestCard = (int) (2 + Math.random() * 10);
				dealer_total += newestCard;
				printedDealer = printedDealer.concat(", " + Integer.toString(newestCard));
			}
		}

    while (count < 1) {
			count++;
			
			System.out.println(printedLine);
			System.out.println(printedDealer);
			
			if (dealer_total > total) {
				System.out.println("The dealer has bust!");
				System.out.println("You win!");
			} else if (user_total > total) {
				System.out.println("You have bust!");
				System.out.println("The dealer wins!");
			} else if (user_total == dealer_total) {
				System.out.println("Tie!");
			} else if (user_total > dealer_total) {
				System.out.println("You Win!");
			} else {
				System.out.println("Dealer Wins!");
			}

		}
    
  } 

}
