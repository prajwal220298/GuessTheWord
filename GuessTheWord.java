package com.game.demo;

import java.util.Scanner;

public class GuessTheWord {

	private boolean play = true;
	private Scanner scanner = new Scanner(System.in);
	private int rounds = 10;
	private char lastRound;

	private Words randomWord = new Words();

	private void showWord() {
		System.out.println("You have " + rounds + " tries left");
		System.out.println(randomWord);
	}

	private void getInput() {
		System.out.println("Enter a letter to guess the word: ");
		String userGuess = scanner.nextLine();
		lastRound = userGuess.charAt(0);
	}

	private void checkInput() {
		boolean isGuessedRight = randomWord.guess(lastRound);

		if (isGuessedRight) {
			if (randomWord.isGuessedRight()) {
				System.out.println("Congrats, You Won...!");
				System.out.println("The word is: " + randomWord);
				play = false;
			}
		} else {
			rounds--;
			if (rounds == 0) {
				System.out.println("Game Over...!");
				System.out.println("The word was: " + randomWord.getSelectedWord());
				play = false;
			}
		}
	}

	public void start() {
		do {
			showWord();
			getInput();
			checkInput();
		} while (play);
	}

	public void end() {
		scanner.close();
	}
}
