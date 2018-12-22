package com.text;

import java.util.concurrent.ThreadPoolExecutor;

public class DieLock {

	public static void main(String[] args) {
		B b = new B();
		A a = new A();
		for (int i = 0; i < 1; i++) {
			new Thread(() -> {
				System.out.println(b.getCount());
			}).start();
			new Thread(() -> {
				System.out.println(a.getCount());
			}).start(); 
		}
	}
}
class A {
	int i = 15;
	public synchronized int getCount() {
		i++;
		return i + new B().getCount();
	}
}
class B {
	int j = 16;
	public synchronized int getCount() {
		return j + new A().getCount();
	}
}