package com.juc;
import java.util.concurrent.*;
/**
 * CountDownLatch �� ����
 * @author Administrator
 *
 */
public class ConcurrentHashMap {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callables cl = new Callables();
		// ִ��Callable��ʽ����ҪFutureTaskʵ�����֧�֣����ڽ�����������FutureTask ��Futrue�ӿڵ�ʵ����
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

