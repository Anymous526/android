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
	 * ����URL�����ļ�,ǰ��������ļ��е��������ı�.�����ķ���ֵ����
	 * �ļ��е�����
	 * 1,����һ��URL����
	 * 2,����URL����,����һ��HttpURLConnection����
	 * 3�õ�InputStream
	 * 3��InputStream���ж�ȡ����
	 * @param urlStr
	 * @return
	 */
	public String download(String urlStr){
		StringBuffer sb = new StringBuffer();
		String line = null;
		BufferedReader buffer = null;
		try {
			//����һ��URL����
			url = new URL(urlStr);
			HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
			//ʹ��IO��ȡ������
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
	 * @return -1:�����ļ����س���.0���������ļ��ɹ� 1:�����ļ�����
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
	 * @funcion  ����URL�õ�������
	 */
	public InputStream getInputStreamFromUrl(String urlStr) throws MalformedURLException,IOException {
		url = new URL(urlStr);
		HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
		InputStream inputStream = urlConn.getInputStream();
		return inputStream;
	}
}
