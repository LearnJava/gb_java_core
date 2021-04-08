package lesson12;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
	static final int SIZE = 10_000_000;
	static final int HALF = SIZE / 2;
	float[] arr = new float[SIZE];

	public static void main(String[] args) {
		App app = new App();
		Date startDateSingleThted = new Date();

		app.singleThread();
		System.out.println("Первый метод выполнялся ->" + ((new Date().getTime() - startDateSingleThted.getTime())));
		Date startDateMultiThted = new Date();
		System.out.println("========================================================================");
		app.twoThread();
		System.out.println("Второй метод выполнялся ->" + ((new Date().getTime() - startDateMultiThted.getTime())));


	}

	public void singleThread() {
		//Заполняем массив единицами
		for (int i = 0; i < SIZE; i++) {
			arr[i] = 1;
		}

		CallableArray callableArray = new CallableArray(arr);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Future<float[]> future = executorService.submit(callableArray);

		try {
			System.arraycopy(future.get(), 0, arr, 0, HALF);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
		System.out.println(arr.length);
	}

	public void twoThread() {
		//Заполняем массив единицами
		for (int i = 0; i < SIZE; i++) {
			arr[i] = 1;
		}
		float[] a1 = new float[HALF];
		float[] a2 = new float[HALF];
		System.arraycopy(arr, 0, a1, 0, HALF);
		System.arraycopy(arr, HALF, a2, 0, HALF);

		System.out.println("Разобрали массив на 2 половины.");

		CallableArray callableArray1 = new CallableArray(a1);
		CallableArray callableArray2 = new CallableArray(a2);

		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<float[]> future1 = executorService.submit(callableArray1);
		Future<float[]> future2 = executorService.submit(callableArray2);

		try {
			System.arraycopy(future1.get(), 0, arr, 0, HALF);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		try {
			System.arraycopy(future2.get(), 0, arr, HALF, HALF);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
		System.out.println("Склеили массив обратно из двух обработанных массивом и получили " + arr.length + " элементов.");
	}
}

class  CallableArray implements Callable<float[]> {

	float[] fArray;

	public CallableArray(float[] array) {
		this.fArray = array;
	}

	@Override
	public float[] call() {
		return changeArray();
	}

	private float[] changeArray() {
		for (int i = 0; i < fArray.length; i++) {
			fArray[i] = (float)(fArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
		}
		System.out.println("Поменяли внутренность массива в потоке " + Thread.currentThread().getName());
		return fArray;
	}
}

