package com.juc;

import java.util.concurrent.CountDownLatch;

public class ConcurrentHashMaps {

	public static void main(String[] args) {
			int count = 10;
			final CountDownLatch codola = new CountDownLatch(count);
			System.out.println("�߳̿�ʼ");
			for (int i = 0; i < count; i++) {
				int n = i;
				new Thread(() -> {
					System.out.println("��" + n + "��ʼ����");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("��" + n + "�ܵ����յ�");
					codola.countDown();
				}).start();
			}
			try {
				codola.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�������Ѿ�������ϣ�лл��ҵ�Ŭ��");
	}
}
