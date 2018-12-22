package com.juc;
import java.util.concurrent.*;
/**
 * CountDownLatch ： 闭锁
 * @author Administrator
 *
 */
public class ConcurrentHashMap {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callables cl = new Callables();
		// 执行Callable方式，需要FutureTask实现类的支持，用于接受运算结果。FutureTask 是Futrue接口的实现类
		FutureTask<Integer> result = new FutureTask<>(cl);
		new Thread(result).start();
		System.out.println(result.get());
	}
	
}
class Callables implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for (int i = 0; i < 15; i++) {
			System.out.println(sum);
			sum ++;
		}
		return sum;
	}
	
}

/*class runbbeleDemo implements Runnable {

	@Override
	public void run(){
	}
	
}*/

