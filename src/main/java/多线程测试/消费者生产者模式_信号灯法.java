package 多线程测试;

public class 消费者生产者模式_信号灯法 {

	public static void main(String[] args) {
		TV tv = new TV();
		new Player(tv).start();
		new Watcher(tv).start();

	}

}

class TV {
	final static boolean PLAY = true;
	final static boolean WATCH = false;
	String voice;
	boolean flag = PLAY;

	public synchronized void getVoice() {
		if (flag == PLAY) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("听到了:" + voice);
		this.flag = PLAY;
		this.notifyAll();
	}

	public synchronized void setVoice(String voice) {
		if (flag == WATCH) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.voice = voice;
		System.out.println("表演了" + voice);
		this.flag = WATCH;
		this.notifyAll();
	}

}

class Player extends Thread {
	TV tv;

	public Player(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0)
				tv.setVoice("aaaaaaaa");
			else
				tv.setVoice("bbbbbbbbbb");
		}
	}
}

class Watcher extends Thread {
	TV tv;

	public Watcher(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			tv.getVoice();
		}
	}
}