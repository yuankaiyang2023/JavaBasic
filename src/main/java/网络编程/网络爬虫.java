package 网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 1.获取url
 * 
 * 2.下载资源
 * 
 * 3.分析资源 ，正则表达式
 * 
 * 4.抽取，清洗，存储
 * 
 * @author Administrator
 *
 */
public class 网络爬虫 {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		// URL url = new URL("https://www.jd.com");
		// BufferedReader br =new BufferedReader(new InputStreamReader(url.openStream(),
		// "utf-8"));

		URL url2 = new URL("https://www.dianping.com");
		HttpURLConnection hUConnection = (HttpURLConnection) url2.openConnection();
		hUConnection.setRequestMethod("GET");
		hUConnection.setRequestProperty("User-Agent", "Mozilla/....");
		BufferedReader br = new BufferedReader(new InputStreamReader(hUConnection.getInputStream(), "utf-8"));
		String msg = null;
		while ((msg = br.readLine()) != null) {
			System.out.println(msg);
		}
	}

}
