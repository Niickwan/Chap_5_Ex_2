package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static boolean ShouldWeGoAgain (int x) {
        if (x == 2) {
            System.out.print("Too many tries, do you want to try again? (y/n): ");
            return ShouldWeGoAgainInput();
        } else if (x > 2) {
            System.out.print("Do you want to go again? (y/n): ");
            return ShouldWeGoAgainInput();
        }
        return false;
    }

    public static boolean ShouldWeGoAgainInput () {
        Scanner scanner = new Scanner(System.in);
        String startAgain = scanner.next();
        if (startAgain .equalsIgnoreCase("y")) {
            System.out.println("\nHere we go gain!\n");
            return true;
        } else {
            System.out.println("\nThanks for playing!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Pick a random number
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int counter = 0;
        int number = 0;
        boolean startOver = true;
        boolean exit = false;

        while (!exit) {
            if (startOver){
                number = random.nextInt(100) + 1;
                System.out.println("I'm thinking of a number between 1 and 100 (including both). you have 3 guesses, can you guess what it is?");
                startOver = false;
            }
            if (counter < 3) {
                while (counter < 3) {
                    System.out.print("Type a number: ");
                    int guess = scanner.nextInt();
                    System.out.println("Your guess is: " + guess);
                    if (number > guess) {
                        System.out.println("Your guess was too low\n");
                        counter++;
                    } else if (number < guess) {
                        System.out.println("Your guess was too high\n");
                        counter++;
                    } else if (number == guess) {
                        System.out.println("Spot on! nice guess!\n");
                        counter = 5;
                        startOver = ShouldWeGoAgain(counter);
                    }
                }
            }
            if (counter == 3) {
                startOver = ShouldWeGoAgain(counter);
            }
            if (!startOver) {
                exit = true;
            } else {
                counter = 0;
            }
        }
    }
}
