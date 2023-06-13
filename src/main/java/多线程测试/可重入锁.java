package 多线程测试;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁可以延续使用 + 计数器
 * 
 * @author Administrator
 *
 */
public class 可重入锁 {
	static ReLock lock = new ReLock();
	//static ReentrantLock lock = new ReentrantLock();

	static void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount() + "----------------2");

		// do something
		lock.unlock();
		System.out.println(lock.getHoldCount() + "----------------3");

	}

	public static void main(String[] args) throws InterruptedException {
		lock.lock();
		System.out.println(lock.getHoldCount() + "----------------1");
		doSomething();
		lock.unlock();
		System.out.println(lock.getHoldCount() + "----------------4");

	}

}

class ReLock {
	private boolean isLocked = false;
	private Thread lockedBy = null;
	private int holdCount = 0;

	public int getHoldCount() {
		return holdCount;
	}

	public synchronized void lock() throws InterruptedException {
		Thread t = Thread.currentThread();
		while (isLocked && t != lockedBy) {
			wait();
		}
		isLocked = true;
		lockedBy = t;
		holdCount++;
	}

	public synchronized void unlock() {
		Thread t = Thread.currentThread();
		if (t == lockedBy) {
			holdCount--;
			if (holdCount == 0) {
				isLocked = false;
				lockedBy = null;
				notify();
			}
		}
	}
}