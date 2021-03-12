package lesson5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StartHere {
	public static void main(String[] args) {
		Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
		persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",30000, 30);
		persArray[1] = new Person("Sergeu Sergeev", "Manager", "s@mailbox.com", "3222232",35000, 25);
		persArray[2] = new Person("Petr Petrov", "Director", "p@mailbox.com", "345689876",300000, 42);
		persArray[3] = new Person("Alexey Alexeev", "Driver", "a@mailbox.com", "1234565",20000, 34);
		persArray[4] = new Person("Степан Воронин", "Translator", "sv@mailbox.com", "98765433456",500000, 39);

		System.out.println();
//		Arrays.stream(persArray).filter(person -> person.getAge() > 40).collect(Collectors.toList()).forEach(System.out::println);
	}
}
