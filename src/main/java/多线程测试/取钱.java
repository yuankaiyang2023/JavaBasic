package 多线程测试;

public class 取钱 {

	public static void main(String[] args) {
		// 非同步
		Account account = new Account("我的账户", 100);
		Thread you = new Drawing(account, 80, "我的操作");
		Thread wife = new Drawing(account, 90, "老婆的操作");
		you.start();
		wife.start();
		System.out.println("*****************");
		Account account2 = new Account("我的账户", 100);
		// 同步
		Thread you2 = new Drawing2(account2, 80, "我的操作2");
		Thread wife2 = new Drawing2(account2, 90, "老婆的操作2");
		you2.start();
		wife2.start();
	}

}

class Account {
	String name;
	int money;

	public Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

}

class Drawing extends Thread {
	Account c;
	int drawingMoney;
	int pocketMoney;

	public Drawing(Account c, int drawingMoney, String name) {
		super(name);
		this.c = c;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		c.money -= drawingMoney;
		pocketMoney += drawingMoney;
		System.out.println(c.name + "********" + c.money + "********" + pocketMoney + "********" + this.getName());
	}
}

class Drawing2 extends Thread {
	Account c;
	int drawingMoney;
	int pocketMoney;

	public Drawing2(Account c, int drawingMoney, String name) {
		super(name);
		this.c = c;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}

	private void test() {
		if (c.money - drawingMoney <= 0) {
			return;
		}
		synchronized (c) {
			if (c.money - drawingMoney <= 0) {
				return;
			}
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.money -= drawingMoney;
			pocketMoney += drawingMoney;
			System.out.println(c.name + "********" + c.money + "********" + pocketMoney + "********" + this.getName());
		}
	}
	
	
}
