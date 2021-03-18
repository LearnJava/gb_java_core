package lesson7;

import java.util.ArrayList;
import java.util.List;

class Plate {
	private int food;

	public Plate(int food) {
		this.food = food;
	}

	public void decreaseFood(int n) {
		food -= n;
	}

	public void info() {
		System.out.println("plate: " + food);
	}

	public void addFood(int food) {
		this.food += food;
		System.out.println("Добавили еды в тарелку +" + food + ".Еды стало " + this.food);
	}

	public int getFood() {
		return food;
	}
}

class Cat {
	private String name;
	private int appetite;
	private boolean satiety = false;

	public Cat(String name, int appetite) {
		this.name = name;
		this.appetite = appetite;
	}

	public void eat(Plate p) {
		if (!satiety) {
			if ((p.getFood() - appetite) >= 0) {
				p.decreaseFood(appetite);
				satiety = true;
				System.out.println(name + " сказал: Cпасибо, покушал. Сытость = " + satiety);
			} else {
				System.out.println(name + " сказал: Для меня здесь мало еды, есть не буду. Сытость = " + satiety);
			}
		} else {
			System.out.println(name + " сказал: Cпасибо, но я уже сыт");
		}
	}

	public boolean isSatiety() {
		return satiety;
	}
}

public class MainClass {
	public static void main(String[] args) {
		Cat barsik = new Cat("Barsik", 5);
		Plate plate = new Plate(4);
		plate.info();
		barsik.eat(plate);
		plate.info();
		plate.addFood(100);
		barsik.eat(plate);
		plate.info();
		System.out.println("=====================================");

		List<Cat> cats = new ArrayList<>();
		cats.add(barsik);
		cats.add(new Cat("Вася", 10));
		cats.add(new Cat("Пушок", 7));
		cats.add(new Cat("Мурзик", 3));
		cats.add(new Cat("Цезарь", 8));
		cats.add(new Cat("Гав", 4));
		cats.add(new Cat("Обжора", 90));

		cats.forEach(cat -> {
			cat.eat(plate);
			System.out.println("в тарелке осталось " + plate.getFood() + " единиц еды.");
			System.out.println("-------------------------------------------");
		});
		System.out.println("После обеда в тарелке осталось " + plate.getFood() + " единиц еды.");
	}
}
