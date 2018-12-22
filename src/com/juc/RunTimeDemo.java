package com.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RunTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new Thread(() -> 
//		{
//			try {
//				Thread.sleep(2000);
//				System.out.println(123);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//				).start();
		ThreadPoolExecutor th = new ThreadPoolExecutor(5, 4, 5, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(6));
	}
	

}
