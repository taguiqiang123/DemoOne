package com.juc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
	
	private static final int NTHREADS = 100;
	private static final ScheduledThreadPoolExecutor exec =
			new ScheduledThreadPoolExecutor(1);
	
	public static void main(String[] args) throws IOException {
		Thread th = new Thread(() -> 
		{
			int i = 0;
				try {
				while (true) {
					if (i > 5) {
						break;
					}
					Thread.sleep(1000);
					System.out.println("进来了");
					i++;
				}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(Thread.currentThread().isInterrupted());
				}
				
		});
		th.start();
	/*	try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(th.isInterrupted());
		th.interrupt();
		System.out.println(th.isInterrupted());
		/*try {
			Thread.sleep(2000);
			th.interrupt();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println(th.isInterrupted());
		}*/
		/*Thread th1 = new Thread(() -> 
		{
			while (true) {
				try {
					Thread.sleep(1000);
					System.out.println("进来了Two");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
//		exec.scheduleAtFixedRate(th, 0, 10000, TimeUnit.MILLISECONDS);
		exec.execute(th);
		try {
			th.interrupt();
			Thread.sleep(200);
			th.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	/*	
		exec.execute(th1);*/
	}
}
