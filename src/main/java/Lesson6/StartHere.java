package Lesson6;

import Lesson6.animals.Animal;
import Lesson6.animals.Cat;
import Lesson6.animals.Dog;

public class StartHere {

	public static void main(String[] args) {
		Dog dogBobik = new Dog("Бобик");
		Animal catBarsik = new Cat("Барсик");

		System.out.println(dogBobik.run(150));
		System.out.println(catBarsik.run(11));

		System.out.println(dogBobik.swim(150));
		System.out.println(dogBobik.swim(9));

		System.out.println("Создано животных - " + Animal.animalsCount);
		System.out.println("Создано собак - " + Dog.dogsCount);
		System.out.println("Создано котов - " + Cat.catCount);
	}
}