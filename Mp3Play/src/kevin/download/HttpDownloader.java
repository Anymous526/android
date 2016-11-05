package kevin.download;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class HttpDownloader {
	private URL url =null;
	
	/**
	 * 根据URL下载文件,前提是这个文件中的内容是文本.函数的返回值就是
	 * 文件中的内容
	 * 1,创建一个URL对象
	 * 2,对象URL对象,创建一个HttpURLConnection对象
	 * 3得到InputStream
	 * 3从InputStream当中读取数据
	 * @param urlStr
	 * @return
	 */
	public String download(String urlStr){
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader buffer = null;
		try {
			//创建一个URL对象
			url = new URL(urlStr);
			HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
			//使用IO读取流数据
			buffer = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while((line= buffer.readLine() )!=null){
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				buffer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return sb.toString();
	}
}

