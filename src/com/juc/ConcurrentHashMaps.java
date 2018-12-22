package com.juc;

import java.util.concurrent.CountDownLatch;

public class ConcurrentHashMaps {

	public static void main(String[] args) {
			int count = 10;
			final CountDownLatch codola = new CountDownLatch(count);
			System.out.println("线程开始");
			for (int i = 0; i < count; i++) {
				int n = i;
				new Thread(() -> {
					System.out.println("老" + n + "开始奔跑");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("老" + n + "跑到了终点");
					codola.countDown();
				}).start();
			}
			try {
				codola.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("所有人已经奔跑完毕：谢谢大家的努力");
	}
}
