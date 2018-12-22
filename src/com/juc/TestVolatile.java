package com.juc;

/**
 * һ volatile�ؼ���
 * @author Administrator
 *
 */
public class TestVolatile {
	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
		while(true) {
			if (td.isFlag()) {
				System.out.println("����ѭ��");
				break;
			}
			}
	}
}

class ThreadDemo implements Runnable {
	private volatile boolean flag = false;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO: handle exception
		}
		flag = true;
		System.out.println("flag=true");
	}
	
	public boolean isFlag() {
		return flag;
	}
}