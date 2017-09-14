package laicode;

import static org.junit.Assert.*;

import org.junit.Test;

public class TDDExample {

	@Test
	public void test1() {
		Myset myset = new Myset(1000);
		assertEquals(myset.size() , 1000);
		assertEquals(myset.isEmpty(), false);
	}

	@Test
	public void test2() {
		Myset myset = new Myset(1000);
		myset.add(500);
	}

	@Test
	public void test3() {
		Myset myset = new Myset(1000);
		myset.add(500);
	}

	@Test
	public void test4() {
		Myset myset = new Myset(1000);
		myset.add(500);
	}
}
