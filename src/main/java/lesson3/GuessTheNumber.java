package lesson3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessTheNumber {
	BufferedReader reader;


	public int method2(int myVarM2) {

		int newIntM2 = myVarM2 + 1;
		return newIntM2;
	}

	public int method3(int myVarM3) {

		int newIntM3 = method2(myVarM3);
		return newIntM3;
	}

	public int method4(int myVarM4) {

		int newIntM4 = method2(myVarM4);
		return newIntM4;
	}








	public static void main(String[] args) {
		new GuessTheNumber().run();
	}

	public void run() {
		int yesOrNo;

		do {
			game();
			System.out.println("{«Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).");
			yesOrNo = enterNumber();
		} while (yesOrNo != 0 );
		brClose();
	}
//	Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3
//	попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
//	указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
//	выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

	private void game() {

		int randNum = genRandomNumber();
		int numberOfAttampts = 3;
		System.out.println("Я загадал число от 0 до 10, попробуй его угадай за " + numberOfAttampts + " попытки(ок).");
		for (int i  = 0; i < numberOfAttampts; i++) {
			int myNumber = enterNumber();

			if (myNumber > randNum) {
				System.out.println("Ваше число больше загаданного.");
			} else if (myNumber < randNum) {
				System.out.println("Ваше число меньше загаданного.");
			} else {
				System.out.println("Поздравляю!!! Вы угадали число.");
				break;
			}
			if (i == numberOfAttampts - 1) {
				System.out.println("Вы исчерпали количество попыток.");
			}
		}
	}

	private int genRandomNumber() {
		return (int)(Math.random() * 10 + 1);
	}

	private int enterNumber() {
		reader = new BufferedReader(new InputStreamReader(System.in));

		String sAge = "";
		try {
			sAge = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(sAge);
	}

	private void brClose() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
