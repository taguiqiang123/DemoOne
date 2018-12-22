package com.juc;

/**
 * 生产者和消费者案例
 * @author  
 *
 */
public class TestProductorAndConsumer {
	
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		
		Productor pro = new Productor(clerk);
		Consumer con = new Consumer(clerk);
		
		new Thread(pro,"生产者棒棒的").start();
		new Thread(con,"消费者虚虚的").start();
	}
}
class Clerk{
	// 产品
	private int product = 0;
	
	//进货
	public synchronized void get() {
		if (product > 1) {
			System.out.println("产品已满");
			try {
				this.wait();// 释放锁
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + ":" + ++product);
			this.notifyAll();// 唤醒其他锁
		}
	}
	// 卖货
	public synchronized void slae() {
		if (product <= 0) {
			System.out.println("缺货");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + ":" + (--product));
			this.notifyAll();
		}
	}
}
// 生产者
class Productor implements Runnable {
	private Clerk clerk;
	
	public Productor (Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clerk.get();
		}
	}
}

// 消费者
class Consumer implements Runnable{
	private Clerk clerk;
	public Consumer (Clerk clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.slae();
		}
	}
	
}