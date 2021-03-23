package lesson9;

import lesson9.exceptions.MyArrayDataException;
import lesson9.exceptions.MyArraySizeException;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        App app = new App();
        String[][] myArray = new String[4][4];//измените размер массива, чтобы получить инслючение
        try {
            if (app.checkArraySize(myArray)) {
                myArray = app.fillArray(myArray);
                myArray[1][3] = "rt";//Закоментируйте эту строку для проверки правильности работы сложения чисел из массива
                try {
                    System.out.println("Сумма всех чисел массива равна " + app.summAllElems(myArray));
                } catch (MyArrayDataException e) {
                    e.printStackTrace();
                }
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    Integer summAllElems(String[][] myArray) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0, myArrayLength = myArray.length; i < myArrayLength; i++) {
            String[] arr = myArray[i];
            for (int j = 0, arrLength = arr.length; j < arrLength; j++) {
                System.out.print(myArray[i][j] + "\t");
                try {
                    sum += Integer.parseInt(myArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке с индексами " + i + " и " + j + " неверные данные.");
                }
            }
            System.out.println();
        }
        return sum;
    }

    String[][] fillArray(String[][] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = String.valueOf(randomNumber());
            }
        }
        return myArray;
    }

    int randomNumber() {
        return new Random().nextInt(50);
    }

    boolean checkArraySize(Object[][] myArray) throws MyArraySizeException {
        if (myArray.length != 4) {
            throw new MyArraySizeException("Массив должен быть 4х4.");
        } else {
            for (int i = 0; i < myArray.length; i++) {
                for (int j = 0; j < myArray[i].length; j++) {
                    if (myArray[i].length != 4) {
                        throw new MyArraySizeException("Массив должен быть 4х4.");
                    }
                }
            }
        }
        return true;
    }
}