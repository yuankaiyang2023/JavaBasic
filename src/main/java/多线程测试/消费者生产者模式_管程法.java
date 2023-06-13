package 多线程测试;

public class 消费者生产者模式_管程法 {

	public static void main(String[] args) {
		SynContainer synContainer = new SynContainer();
		new Productor(synContainer).start();
		new Consumer(synContainer).start();
	}

}

class Productor extends Thread {
	SynContainer synContainer;

	public Productor(SynContainer synContainer) {
		super();
		this.synContainer = synContainer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			synContainer.push(new Steamedbun(i));
			System.out.println("生产第" + i + "个馒头。。。" + "剩余包子个数： " + synContainer.count);
		}
	}
}

class Consumer extends Thread {
	SynContainer synContainer;

	public Consumer(SynContainer synContainer) {
		super();
		this.synContainer = synContainer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			synContainer.pop();
			System.out.println("消费第" + i + "个馒头。。。" + "剩余包子个数： " + synContainer.count);
		}
	}
}

class SynContainer {
	Steamedbun[] buns = new Steamedbun[10];
	int count = 0;

	public synchronized void push(Steamedbun bun) {
		if (count == buns.length) {
			try {
				
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buns[count++] = bun;// insert buns[count], count++
		this.notifyAll();
	}

	public synchronized Steamedbun pop() {
		if (count == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Steamedbun bun = buns[--count];
		this.notifyAll();
		return bun;// return buns[count-1],count--.
	}
}

class Steamedbun {
	int id;

	public Steamedbun(int id) {
		super();
		this.id = id;
	}

}