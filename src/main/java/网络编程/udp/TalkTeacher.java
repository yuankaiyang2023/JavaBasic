package 网络编程.udp;

public class TalkTeacher {

	public static void main(String[] args) {
		new Thread(new TalkReceiver(9999, "学生说")).start();
		new Thread(new TalkSender(5555, "localhost", 8888)).start();
	}

}
