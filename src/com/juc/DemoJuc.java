package com.juc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoJuc {
	public static void main(String[] args) {
		AtomicDemo ao = new AtomicDemo();
		for (int i = 0; i < 10; i++) {
			new Thread(ao).start();
		}
	}
}
class AtomicDemo implements Runnable {
	/*private volatile int count = 0;*/
	private volatile AtomicInteger count = new AtomicInteger(0);
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		getCount();
		System.out.println(count);
	}
	public synchronized void getCount()  {
		count.getAndIncrement();
	}
}