package 多线程测试;

/**
 * 同步方法锁住当前方法所属实例，对thread实例无效（因为每个线程实例是不同的）,对runnable实例有效，因为多个线程代理同一个对象
 * 
 * 同一个普通对象被多个线程调用，内部synchronized 方法也有用
 * 
 * 还可以用ReentrantLock实现
 * 
 * 用CAS实现
 * 
 * @author Administrator
 *
 */
public class 同步方法和同步块 {

	public static void main(String[] args) {
		Account2 acc = new Account2("", 50);
		Run r = new Run(100, acc);
		for (int i = 0; i < 100; i++) {
//		new Thread(r).start();
			new Mythread(1111, acc).start();
		}
	}

}

class Account2 {
	String name;
	int money;

	public Account2(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	synchronized void minus() throws InterruptedException {
		Thread.currentThread().sleep(5000);
		money -= 10;
	}
}

class Run implements Runnable {
	Account2 account;
	int sum;

	public Run(int sum, Account2 account) {
		super();
		this.sum = sum;
		this.account = account;
	}

	public void run() {
		try {
			// minus();
			minus2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void minus() throws InterruptedException {
		System.out.println(111111111 + Thread.currentThread().getName());
		Thread.sleep(5000);
		account.money -= 10;
		sum--;
		System.out.println(account.money);
		System.out.println(sum);
	}

	void minus2() throws InterruptedException {
		synchronized (account) {
			System.out.println(111111111 + Thread.currentThread().getName());
			Thread.sleep(5000);
			account.money -= 10;
			sum--;
			// System.out.println(sum);
			System.out.println(account.money);
		}
	}
}

class Mythread extends Thread {
	Account2 account;
	int sum;

	public Mythread(int sum, Account2 account) {
		super();
		this.sum = sum;
		this.account = account;
	}

	public void run() {
		try {
			// minus();
			// minus2();
			minus3();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized void minus() throws InterruptedException {
		System.out.println(111111111 + Thread.currentThread().getName());
		Thread.sleep(5000);
		account.money -= 10;
		sum--;
		// System.out.println(sum);
		System.out.println(account.money);
	}

	void minus2() throws InterruptedException {
		synchronized (account) {
			System.out.println(111111111 + Thread.currentThread().getName());
			Thread.sleep(5000);
			account.money -= 10;
			sum--;
			// System.out.println(sum);
			System.out.println(account.money);
		}
	}

	void minus3() throws InterruptedException {

		System.out.println(111111111 + Thread.currentThread().getName());
		Thread.sleep(5000);
		// account.money -= 10;
		// sum--;
		account.minus();
		// System.out.println(sum);
		System.out.println(account.money);

	}
}