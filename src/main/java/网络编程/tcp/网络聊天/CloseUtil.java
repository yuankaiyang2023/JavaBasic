package 网络编程.tcp.网络聊天;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {

	public static void closeAll(Closeable... closeables) {
		for (Closeable c : closeables) {
			try {
				if (null != c)
					c.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
