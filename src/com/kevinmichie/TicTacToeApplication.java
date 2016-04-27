package com.kevinmichie;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeApplication {


    public static void main(String[] args) {
        // Getting input
        Scanner scanner = new Scanner(System.in);
        // Allows for continuous games
        boolean doYouWantToPlay = true;

        while(doYouWantToPlay){
            System.out.println("Welcome to Tic Tac Toe!"+
            " You are to go against\nthe master of Tic Tac Toe. "+
            "\n Are you ready? Pick a character you want to be " +
            "\n and which character I will be.");
            System.out.println();
            System.out.println("Enter a single character that will represent you: ");
            char playerToken = scanner.next().charAt(0);
            System.out.println("Enter a single character that will represent your opponent: ");
            char opponentToken = scanner.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken,opponentToken);
            AI ai = new AI();

            // Set up the game
            System.out.println();
            System.out.println("Now we can start the game. \n"+
            " To play, enter a number and your token shall be put in its place."+
            "\n The numbers for from 1-9, left to right. we shall see who will win this round.");
            game.printIndexBoard();
            System.out.println();

            // Let's play
            while (game.gameOver().equals("notOver")) {
                if (game.currentMarker == game.userMarker) {
                    //USER TURN
                    System.out.println("It's your turn! Enter a spot for your token.");
                    int spot = scanner.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println(" Try again. " + spot + " is invalid. This spot \n" +
                                " is already taken or is out of range");
                        spot = scanner.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                }
                else{
                    //AI turn
                    System.out.println("It's my turn!");
                    // Pick spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked "+aiSpot+"!");

                }
                // Print out new board
                System.out.println();
                game.printBoard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            // Set up a new game.. or not depending on the response
            System.out.println("Do you want to play again?\n"+
            "Enter Y if you do. Type anything else if no.");
            char userResponse = scanner.next().charAt(0);
            char convertedResponse = Character.toUpperCase(userResponse);
            doYouWantToPlay = (convertedResponse == 'Y');
            System.out.println();
            System.out.println();
        }
    }
}
