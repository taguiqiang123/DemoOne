package com.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DemoLock {
	
	public static void main(String[] args) {
		DemoLocks de = new DemoLocks();
		for (int i = 0; i < 5; i++) {
			new Thread(de).start();
			System.out.println(999998999);
		}
	}
	
}
class DemoLocks implements Runnable {
	private int count = 15;
	private Lock lock = new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		lock.lock();
			try {
				Thread.sleep(200);
				getCount();
				System.out.println(count);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

	}
	
	public void getCount () {
		count ++;
	}
	
}
