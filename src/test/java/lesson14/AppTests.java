package lesson14;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTests {

	@Test
	public void myArrTest1() {
		App app = new App();
		int[] i = app.getAfterLast4(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
		assertArrayEquals(i, new int[]{1, 7});
	}

	@Test
	public void myArrTest2() {
		App app = new App();
		int[] i = app.getAfterLast4(new int[]{1, 2, 4, 4, 2, 3, 1, 7});
		assertArrayEquals(i, new int[]{2, 3, 1, 7});
	}

	@Test
	public void myArrTest3() {
		App app = new App();
		int[] i = app.getAfterLast4(new int[]{1, 2, 4, 4, 2, 3, 1, 4});
		assertArrayEquals(i, new int[]{});
	}

	@Test(expected = RuntimeException.class)
	public void myArrTestException() {
		App app = new App();
		int[] i = app.getAfterLast4(new int[]{1, 2, 6, 7, 2, 3, 3, 1, 7});
	}

	@Test
	public void myArrTest1and4_1() {
		App app = new App();
		boolean b = app.checkArrayOnly1and4(new int[]{1, 1, 4});
		assertTrue(b);
	}
	@Test
	public void myArrTest1and4_2() {
		App app = new App();
		boolean b = app.checkArrayOnly1and4(new int[]{1, 1, 1,1});
		assertFalse(b);
	}
	@Test
	public void myArrTest1and4_3() {
		App app = new App();
		boolean b = app.checkArrayOnly1and4(new int[]{4, 4, 4});
		assertFalse(b);
	}
	@Test
	public void myArrTest1and4_4() {
		App app = new App();
		boolean b = app.checkArrayOnly1and4(new int[]{1, 1, 4, 3});
		assertFalse(b);
	}
}
