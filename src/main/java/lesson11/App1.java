package lesson11;

import java.util.ArrayList;
import java.util.List;

public class App1 {
    public static void main(String[] args) {
        new App1().run();
    }

    private void run() {
        String[] aSrtind = {"a", "b", "c", "d", "e"};
        Integer[] bInteger = {1,2,3,4,5,6,7};

        aSrtind = changeTwoArrayElements(aSrtind, 1, 3);
        bInteger = changeTwoArrayElements(bInteger, 0, 6);

        List<String> myStrings = transformArrayToArrayList(aSrtind);
        List<Integer> myIntegers = transformArrayToArrayList(bInteger);
        System.out.println();

    }

    //Задача 1
    public <T> T[] changeTwoArrayElements(T[] anyTypeArray, int firstChangable, int secondGangable) {
        T temp = anyTypeArray[firstChangable];
        anyTypeArray[firstChangable] = anyTypeArray[secondGangable];
        anyTypeArray[secondGangable] = temp;
        return anyTypeArray;
    }

    //Задача 2
    public <R> ArrayList<R> transformArrayToArrayList(R[] absolutlyAnyTypeArray) {
        ArrayList<R> newList = new ArrayList<>(absolutlyAnyTypeArray.length);
        //Идея предлагает заменить цикл на newList.addAll(Arrays.asList(absolutlyAnyTypeArray));
        //цикл оставил для наглядности
        for (R elem: absolutlyAnyTypeArray) {
            newList.add(elem);
        }
        return newList;
    }
}