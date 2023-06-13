package IO流测试.CommonsIO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class IOUtils测试 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		String data = IOUtils.toString(new URL("http://www.baidu.com"), "utf8");
	}
}
