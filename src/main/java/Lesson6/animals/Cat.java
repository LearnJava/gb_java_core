package Lesson6.animals;

public class Cat extends Animal{

	public static int catCount = 0;

	public Cat(String nickName) {
		super(nickName);
		catCount++;
	}
}
