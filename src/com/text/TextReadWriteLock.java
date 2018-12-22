package com.text;

import java.util.concurrent.Executors;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池
 * @author Administrator
 *
 */
public class TextReadWriteLock {
	
	public static void main(String[] args) {
		
 	}

}

class ForkJoinSum extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long statr;
	private long end;

	private static final long THURSHLOD = 100L; //临界值
	
	public ForkJoinSum(long statr, long end) {
		this.statr = statr;
		this.end = end;
	}
	@Override
	protected Long compute() {
		long length = end - statr;
		
		if (length <= THURSHLOD) {
			long sum = 0L;
			for (long i = statr; i<=end; i++) {
				sum += i;
			}
			return sum;
		} else {
			long middle = (statr + end) / 2;
			
			ForkJoinSum left = new ForkJoinSum(statr, end);
			left.fork();
		}
		
		return null;
	}
	
}
