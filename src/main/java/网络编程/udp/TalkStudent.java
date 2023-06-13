package 网络编程.udp;

public class TalkStudent {

	public static void main(String[] args) {
		new Thread(new TalkSender(7777, "localhost", 9999)).start();
		new Thread(new TalkReceiver(8888, "老师说")).start();
	}

}
