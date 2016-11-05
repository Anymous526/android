package kevin.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UTFDataFormatException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.view.inputmethod.InputBinding;

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

	/**
	 * 
	 * @param urlStr
	 * @param path
	 * @param fileName
	 * @return -1:代表文件下载出错.0代表下载文件成功 1:代表文件存在
	 */
	public int downFile(String urlStr,String path, String fileName){
		InputStream inputStream = null;
		try {
			FileUtils fileUtil = new FileUtils();
			if(fileUtil.isFileExist(path+fileName)){
				return 1;
			}else{
				inputStream = getInputStreamFromUrl(urlStr);
				File resultFile = fileUtil.write2SDFromInput(path, fileName, inputStream);
				if(resultFile == null){
					return -1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}finally{
			try {
				inputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return 0;
		
	}
	
	/**
	 * 
	 * @param urlStr
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 * @funcion  根据URL得到输入流
	 */
	public InputStream getInputStreamFromUrl(String urlStr) throws MalformedURLException,IOException {
		url = new URL(urlStr);
		HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
		InputStream inputStream = urlConn.getInputStream();
		return inputStream;
	}
}
