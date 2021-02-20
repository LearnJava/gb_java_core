package lesson2;

import java.util.Arrays;

public class StartHere {
	public static void main(String[] args) throws InterruptedException {
		//1.
		StartHere sh = new StartHere();
		int[] myArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
		int[] newArr = sh.invertArrayElems(myArray);
		System.out.println("Number 1.");
		System.out.println(Arrays.toString(myArray));
		System.out.println(Arrays.toString(newArr));

		//2.
		System.out.println("Number 2.");
		createArray();

		//3.
		System.out.println("Number 3.");
		powerArray();

		//4.
		System.out.println("Number 4.");
		diagonal();

		//5.
		System.out.println("Number 5.");
		minElem();

		//6.
		System.out.println("Number 6.");
		int[] arr = {2, 2, 2, 1, 2, 2, 1, 1};
		boolean result = equalsPart(arr);
		System.out.println(result);

		//7.
		System.out.println("Number 7.");
		int[] myArr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int step = -10;
		circle(myArr, step);
		step = 10;
		circle(myArr, step);
	}

	//1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
	//0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
	public int[] invertArrayElems(int[] arr) {
		int[] tempArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				tempArr[i] = 1;
			} else if (arr[i] == 1) {
				tempArr[i] = 0;
			}
		}
		return tempArr;
	}

	//Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
	public static void createArray() {
		int[] myArr = new int[8];
		for (int i = 0; i < 8; i++) {
			myArr[i] = i * 3;
		}
		System.out.println(Arrays.toString(myArr));
	}

	//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6	умножить на 2;
	public static void powerArray() {
		int[] myArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i] < 6) {
				myArr[i] *= 2;
			}
		}
		System.out.println(Arrays.toString(myArr));
	}

	//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
	//одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
	public static void diagonal() {
		int[][] my2Arr = new int[5][5];
		for (int i = 0; i < my2Arr[0].length; i++) {
			for (int j = 0; j < my2Arr[0].length; j++) {
				if (i == j) {
					my2Arr[i][j] = 1;
				}
			}
		}
	}

	//5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
	//помощи интернета);
	public static void minElem() {
		int[] myArr = {53, 22, 24, 83, 92, 62, 1, 5, 3, 2, 11, 4};
		int min = myArr[0];
		for (int i : myArr) {
			if (min > i) {
				min = i;
			}
		}
		System.out.println(min);
	}

	//6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
	//метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
	//массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, ||
	//2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
	public static boolean equalsPart(int[] arr) {
		int sum1 = 0;
		for (int i : arr) {
			sum1 += i;
			int sum2 = 0;
			for (int j = arr.length - 1; j > i; j--) {
				sum2 += arr[j];
				if (sum1 < sum2) {
					break;
				} else if (sum1 == sum2) {
					return true;
				}
			}
		}
		return false;
	}

	public static void circle(int[] myArr, int step) throws InterruptedException {
		for (int i = 0; i < Math.abs(step); i++) {
			int temp;
			if (step > 0) {
				for (int j = 0; j < myArr.length - 1; j++) {
					temp = myArr[j + 1];
					myArr[j + 1] = myArr[0];
					myArr[0] = temp;
				}
				System.out.print(Arrays.toString(myArr));
				System.out.print("\r");
				Thread.sleep(500);
			} else if (step < 0) {
				for (int j = myArr.length; j > 0; j--) {
					temp = myArr[j - 1];
					myArr[j - 1] = myArr[myArr.length - 1];
					myArr[myArr.length - 1] = temp;
				}
				System.out.print(Arrays.toString(myArr));
				System.out.print("\r");
				Thread.sleep(500);
			}
		}
	}
}