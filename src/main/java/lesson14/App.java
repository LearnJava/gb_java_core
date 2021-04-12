package lesson14;

import java.util.Arrays;
import java.util.stream.IntStream;

public class App {
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
//		int[] arr = getAfterLast4(new int[]{ 1, 2, 4, 4, 2, 3, 4, 1, 7});
		new App().checkArrayOnly1and4(new int[]{1, 1, 4});
		System.out.println();
	}

	public int[] getAfterLast4(int[] myArray) {
		int lastEntryIndex = -1;

		for (int i = 0; i < myArray.length; i++) {
			if (myArray[i] == 4){
				lastEntryIndex = i;
			}
		}

		if (lastEntryIndex > 0) {
			return Arrays.copyOfRange(myArray, lastEntryIndex + 1, myArray.length);
		} else {
			throw new RuntimeException("Массив не содержит четвёрок.");
		}
	}

	public boolean checkArrayOnly1and4(int[] myArr) {
		if (IntStream.of(myArr).allMatch(x -> x == 4 || x == 1)) {
			if (IntStream.of(myArr).filter(x -> x == 1).count() > 0 && IntStream.of(myArr).filter(x -> x == 4).count() > 0) {
				return true;
			}
		}
		return false;
	}
}
