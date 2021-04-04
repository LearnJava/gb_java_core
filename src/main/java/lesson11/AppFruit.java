package lesson11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.Supplier;

public class AppFruit {
	public static void main(String[] args) {
		new AppFruit().run();
	}

	public void run() {
		//создадим ящики для наших хруфтов
		Box<Apple> boxOfApples1 = createBoxOfT(Apple::new, getRandomNumber());
		Box<Apple> boxOfApples2 = createBoxOfT(Apple::new, getRandomNumber());
		Box<Orange> boxOfOranges1 = createBoxOfT(Orange::new, getRandomNumber());
		Box<Orange> boxOfOranges2 = createBoxOfT(Orange::new, getRandomNumber());

		System.out.println("Общий вес ящика с яблоками равен " + boxOfApples1.getWeight());
		System.out.println("Общий вес ящика с апельсинами равен " + boxOfOranges1.getWeight());

		boxOfApples1.addToBox(new Apple());
		boxOfOranges1.addToBox(new Orange());

		System.out.println("=======================================================");
		System.out.println("Добавили по одному фрукту в каждую коробку.");
		System.out.println("Количество яблок в ящике " + boxOfApples1.getContainer().size() + ".Общий вес ящика с яблоками равен " + boxOfApples1.getWeight());
		System.out.println("Количество яблок в ящике " + boxOfApples2.getContainer().size() + ".Общий вес ящика с яблоками равен " + boxOfApples2.getWeight());
		System.out.println("Количество апельсинов в ящике " + boxOfOranges1.getContainer().size() + ".Общий вес ящика с апельсинами равен " + boxOfOranges1.getWeight());
		System.out.println("Количество апельсинов в ящике " + boxOfOranges2.getContainer().size() + ".Общий вес ящика с апельсинами равен " + boxOfOranges2.getWeight());

		System.out.println("=======================================================");
		System.out.println("Сравним вес коробок.");

		System.out.println(boxOfApples1.compareTo(boxOfApples1));//просто сравнил сам с собой ящик
		System.out.println(boxOfApples1.compareTo(boxOfOranges1));

		System.out.println("Переложим по 10 фруктов из коробок.");
		boxOfApples2 = boxOfApples1.transferSomeFruitsToOtherBox(boxOfApples2, 10);
		boxOfOranges1 = boxOfOranges2.transferSomeFruitsToOtherBox(boxOfOranges1, 10);

		System.out.println("======================================================");
		System.out.println("Количество яблок в ящике " + boxOfApples1.getContainer().size() + ".Общий вес ящика с яблоками равен " + boxOfApples1.getWeight());
		System.out.println("Количество яблок в ящике " + boxOfApples2.getContainer().size() + ".Общий вес ящика с яблоками равен " + boxOfApples2.getWeight());
		System.out.println("Количество апельсинов в ящике " + boxOfOranges1.getContainer().size() + ".Общий вес ящика с апельсинами равен " + boxOfOranges1.getWeight());
		System.out.println("Количество апельсинов в ящике " + boxOfOranges2.getContainer().size() + ".Общий вес ящика с апельсинами равен " + boxOfOranges2.getWeight());

		System.out.println();
	}

	public <T extends Fruit> Box<T> createBoxOfT(Supplier<T> supplier, int count ) {
		List<T> heapOfT = new ArrayList<>();
		for (int i = 0; i < getRandomNumber(); i++) {
			heapOfT.add(supplier.get());
		}
		Box<T> box = new Box<>();
		box.addToBox(heapOfT);
		return box;
	}

	private int getRandomNumber() {
		return (int)(Math.random() * 10000);
	}
}

class Fruit {
	double weight;

	public double getWeight() {
		return weight;
	}
}

class Apple extends Fruit {
	Apple() {
		weight = 1;
	}
}

class Orange extends Fruit {
	Orange() {
		weight = 1.5;
	}
}

class Box<T extends Fruit> implements Comparable<Box<T>>{
	private LinkedHashSet<T> container = new LinkedHashSet<T>();

	public boolean addToBox(T item) {
		container.add(item);
		return true;
	}

	public boolean addToBox(List<T> items) {
		container.addAll(items);
		return true;
	}

	public double getWeight(){
		if (!container.isEmpty()) {
			return container.stream().mapToDouble(a -> a.weight).sum();
		}
		return 0;
	}

	@Override
	public int compareTo(Box anyBox) {
		if (this.getWeight() > anyBox.getWeight()) {
			return 1;
		} else if (this.getWeight() < anyBox.getWeight()) {
			return -1;
		} else {
			return 0;
		}
	}

	public Box<T> transferSomeFruitsToOtherBox(Box<T> destBox, int count) {
		if (count > 0 && !this.equals(destBox)) {
			Iterator<T> iterator = this.container.iterator();
			for ( int i = 0; iterator.hasNext() && i < count; i++) {
				destBox.addToBox(iterator.next());
				iterator.remove();
			}
		}
		return destBox;
	}

	public LinkedHashSet<T> getContainer() {
		return container;
	}

	public void setContainer(LinkedHashSet<T> container) {
		this.container = container;
	}
}