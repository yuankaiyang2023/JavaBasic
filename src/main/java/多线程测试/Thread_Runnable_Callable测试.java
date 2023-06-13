package 多线程测试;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Thread_Runnable_Callable测试 {
//	static void say() {};
//	static void say2() {};
	public static void main(String[] args) {

		new Thread("线程名") {
			public void run() {

				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(1111 + Thread.currentThread().getName());
			};
		}.start();

		new Thread(new Runnable() {// 代理模式

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(222 + Thread.currentThread().getName());
			}
		}, "线程名2").start();
		Child c0 = new Child();
		c0.start();
		Child c = new Child();
		c.start();
		Child2 c2 = new Child2();
		new Thread(c2, "线程名5").start();
		new Thread(c2, "线程名6").start();
		Child3 c3 = new Child3();
		new Thread(() -> {// lambda表达式，形参一般是个接口，并且只有一个抽象方法
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("99999" + Thread.currentThread().getName());
		}).start();
		new Thread(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("99999" + Thread.currentThread().getName());
		}).start();
//		ExecutorService service = Executors.newFixedThreadPool(3);
//		Future<Boolean> b= service.submit(c3);
//		Future<Boolean> b2=service.submit(c3);
//
//		Thread_Runnable_Callable测试.testLambda(() -> {
//			System.out.println("0000000" + Thread.currentThread().getName());
//		});

	}

	public static void testLambda(Runnable r) {
		r.run();
	}

}

class Child extends Thread {

	@Override
	public void run() {
		try {
			// this.setName("线程名3");
			Thread.sleep(1000);
		//	int b =1/0;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(33333 + Thread.currentThread().getName());
	}
}

class Child2 implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(55555555 + Thread.currentThread().getName());
	}

}

class Child3 implements Callable<Boolean> {

	@Override
	public Boolean call() throws InterruptedException {

			Thread.sleep(1000);

		System.out.println(88888888 + Thread.currentThread().getName());
		return true;
	}

}