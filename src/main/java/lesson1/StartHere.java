package lesson1;

public class StartHere {
	byte variableByteType = 11;
	public static void main(String[] args) {
		//2. Создать переменные всех пройденных типов данных и инициализировать их значения.
		byte variableByteType = 13;
		short variableShortType = 13;
		int variableIntType = 13;
		long variableLongType = 13;
		float variableFloatType = 13.13f;
		double variableDoubleType = 13.14;
		char variableCharType = 'Z';
		boolean isSumTrue = false;

		StartHere sh = new StartHere();
		variableFloatType = sh.hardFun(1, 2, 3, 4);
		isSumTrue = sh.trueSum(10, 5);
		isSumTrue = sh.trueSum(10, 25);

		positiveOrNegativePrint(-13);
		boolean isPositive = sh.isPositiveOrNegative(67);
		printName("Konstantin");

		int year = 2023;
		System.out.println("Правда ли, что " + year + " високосный? ---> " + sh.isLeapYear(year));
	}

	//3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
	//где a, b, c, d – аргументы этого метода, имеющие тип float.
	public float hardFun(float a, float b, float c, float d) {
		byte variableByteType = 23;
		System.out.println(variableByteType);
		System.out.println(this.variableByteType);
		return a * (b + (c / d));
	}

	//4. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
	//в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

	public boolean trueSum(long a, long b) {
		long sum = a + b;
		return sum > 10 && sum <= 20;
	}

	//5. Написать метод, которому в качестве параметра передается целое число, метод должен
	//напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль
	//считаем положительным числом.
	public static void positiveOrNegativePrint(long a) {
		if (a >= 0) {
			System.out.println("Number is positive.");
		} else {
			System.out.println("Number is negative.");
		}
	}

	//6. Написать метод, которому в качестве параметра передается целое число. Метод должен
	//вернуть true, если число отрицательное, и вернуть false если положительное.
	public boolean isPositiveOrNegative(long a) {
		return a >= 0;
	}

	//7. Написать метод, которому в качестве параметра передается строка, обозначающая имя.
	//Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
	public static void printName(String name) {
		System.out.println("Привет, " + name);
	}

	//8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в
	//консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й високосный.
	public boolean isLeapYear(int year) {
		return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
	}
}
