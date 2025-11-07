package ch15;

import java.util.LinkedList;
import java.util.Queue;

public class MethodEx {
	public static void main(String[] args) {
		test1();
		System.out.println(Math.pow(Math.round(3.14), 2)); // 메소드 내의 메소드 -> 안쪽부터
	}
	static void test1() {
		test2();
		System.out.println("test1");
	}
	static void test2() {
		test3();
		System.out.println("test2");
		
	}

	static void test3() {
		System.out.println("test3");
	}
}
