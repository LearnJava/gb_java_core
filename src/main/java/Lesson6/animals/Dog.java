package Lesson6.animals;

public class Dog extends Animal{

	public static int dogsCount = 0;

	public Dog(String nickName) {
		super(nickName);
		dogsCount++;
	}

	public String swim(int dictance) {
		if (dictance > 10) {
			return "Я не могу проплыть более 10 метров";
		}
		return getNickName() + " проплыл " + dictance + " метров.";
	}
}
