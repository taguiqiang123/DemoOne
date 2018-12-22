package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * “¿¥ŒÀ≥–Ú
 * @author Administrator
 *
 */
public class TestABC {

	public static void main(String[] args) {
		DemoABC demo = new DemoABC("A",5);
		DemoABC demo1 = new DemoABC("B",5);
		DemoABC demo2 = new DemoABC("C",5);
		new Thread(demo).start();
		new Thread(demo1).start();
		new Thread(demo2).start();
	}
}

class DemoABC implements Runnable {
	private String name;
	private int count;
	private Lock lock = new ReentrantLock();
	private Condition con = lock.newCondition();
	private Condition con1 = lock.newCondition();
	private Condition con2 = lock.newCondition();
	public DemoABC(String name,int count) {
		this.name = name;
		this.count = count;
	}
	@Override
	public void run() {	
		lock.lock();
		try {
			
			for (int i = 0; i < count; i++) {
				System.out.println("¥Ú”°Œ™£∫"+name);
			}
		} finally {
			lock.unlock();
		}

	}
	
}
