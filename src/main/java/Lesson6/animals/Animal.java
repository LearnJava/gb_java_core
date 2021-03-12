package Lesson6.animals;

public abstract class Animal {

	public static int animalsCount = 0;

	private String nickName = "";

	Animal(String nickName) {
		this.nickName = nickName;
		animalsCount++;
	}

	public String run(int distance) {

		if (this instanceof Dog) {
			if (distance > 500) {
				return nickName + " не может пробежать " + distance + " метров.";
			}
		} else if (this instanceof Cat) {
			if (distance > 200) {
				return nickName + " не может пробежать " + distance + " метров.";
			}
		}
		return nickName + " пробежал " + distance + " метров.";
	}

	public String getNickName() {
		return nickName;
	}
}
