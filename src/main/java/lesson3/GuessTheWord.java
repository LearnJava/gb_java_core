package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GuessTheWord {
//	Создать массив из слов
//	String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
//			"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
//			"peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
//			При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//	сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если
//	слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
//			apple – загаданное
//	apricot - ответ игрока
//	ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//	Для сравнения двух слов посимвольно можно пользоваться:
//	String str = "apple";
//	char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
//	Играем до тех пор, пока игрок не отгадает слово.
//	Используем только маленькие буквы.

	BufferedReader reader;

	public static void main(String[] args) {
		new GuessTheWord().game();
	}

	private void game() {
		String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
				"cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
				"peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
		int numberOfGuessedLetters = 0;
		String secretWord = selectWordFromArray(words);
		System.out.println(secretWord + " - Это ответ, использовать только для тестирования.");

		do {
			System.out.println("Введите слово целиком или первые буквы. Вводить нужно всю извествую часть целиком всё время.");
			String tempPart = enterALetters();
			numberOfGuessedLetters = findEqualsSymbols(secretWord, tempPart);
			if (secretWord.equalsIgnoreCase(tempPart)) {
				System.out.println("Вы угадали слово целиком. Это слово -> " + secretWord);
				break;
			} else if (numberOfGuessedLetters > 0){
				System.out.println(hideWord(secretWord.substring(0, numberOfGuessedLetters), numberOfGuessedLetters));
				System.out.println("Вы угадали некую часть слова.");
			} else {
				System.out.println("Пока вы не открыли ни одной буквы.");
			}
			System.out.println("==========================================================");
		} while (true);

		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int findEqualsSymbols(String secretWord, String myVersionOfWord) {
		int letters = 0;
		for (int i = 1; i <= secretWord.length() && i <= myVersionOfWord.length(); i++) {
			if (secretWord.substring(0, i).equalsIgnoreCase(myVersionOfWord.substring(0,i))) {
				letters++;
			} else {
				break;
			}
		}
		return letters;
	}

	private String selectWordFromArray(String[] words) {
		List<String> wordList = Arrays.asList(words);
		Collections.shuffle(Arrays.asList(words));
		return wordList.get(0);
	}

	private String hideWord(String secretWord, int knownLetter) {
		String wordPart = secretWord.substring(0, knownLetter);
		StringBuilder sb = new StringBuilder();
		sb.append(wordPart);
		for (int i = 0; i < (15 - knownLetter); i++) {
			sb.append("#");
		}
		return sb.toString();
	}

	private String enterALetters() {
		reader = new BufferedReader(new InputStreamReader(System.in));

		String letters = "";
		try {
			letters = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return letters;
	}

	private void brClose() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
