package com.juc;

/**
 * �����ߺ������߰���
 * @author  
 *
 */
public class TestProductorAndConsumer {
	
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		
		Productor pro = new Productor(clerk);
		Consumer con = new Consumer(clerk);
		
		new Thread(pro,"�����߰�����").start();
		new Thread(con,"�����������").start();
	}
}
class Clerk{
	// ��Ʒ
	private int product = 0;
	
	//����
	public synchronized void get() {
		if (product > 1) {
			System.out.println("��Ʒ����");
			try {
				this.wait();// �ͷ���
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + ":" + ++product);
			this.notifyAll();// ����������
		}
	}
	// ����
	public synchronized void slae() {
		if (product <= 0) {
			System.out.println("ȱ��");
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
// ������
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

// ������
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