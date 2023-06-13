package 多线程测试;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS操作 {
	private static AtomicInteger stock = new AtomicInteger(5);

	public static void main(String[] args) {
		System.out.println(stock);
		for (int i = 0; i < 6; i++) {
			new Thread(() -> {
				Integer left = stock.decrementAndGet();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (left < 0) {
					System.out.println("抢完了。。。" + Thread.currentThread().getName() + "没抢到");
					return;
				}
				System.out.println(Thread.currentThread().getName() + "抢到了一件商品，商品编号：" + left);
			}).start();
		}
	}

}
