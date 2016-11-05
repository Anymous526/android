package kevin.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Environment;

public class FileUtils {
	private String SDPATH;
	private String getSDPATH(){
		return SDPATH;
	}
	public FileUtils(){
		//得到当前外部存储设备的目录
		SDPATH = Environment.getExternalStorageDirectory() +"/";
	}
	
	/**
	 * 
	 * @param fileName
	 * @return file
	 * @throws IOException
	 * @funtion 通过fileName在SD的/下面创建文件
	 */
	public File CreateSDFile(String fileName) throws IOException{
		File file = new File(SDPATH+fileName);
		file.createNewFile();
		return file;
	}
	
	/**
	 * 
	 * @param dirName
	 * @return file
	 * @function 根据dirName创建目录
	 */
	public File createSDDir(String dirName){
		File dir = new File(SDPATH+dirName);
		dir.mkdir();
		return dir;
	}
	
	/**
	 * 
	 * @param fileName
	 * @return boolean
	 * @funtcion 判断文件是否存在
	 */
	public boolean isFileExist(String fileName){
		File file = new File(SDPATH+fileName);
		return file.exists();
		}
	
	/**
	 * 
	 * @param path
	 * @param fileName
	 * @param input
	 * @return File
	 * @funcion 将一个InputStream里面的数据写入SD卡中
	 */
	public File write2SDFromInput(String path,String fileName,InputStream input){
		File file = null;
		OutputStream output = null;
		try {
			createSDDir(path);
			file = CreateSDFile(path+fileName);
			output = new FileOutputStream(file);
			byte buffer[] = new byte[4*1024];
			while((input.read(buffer)) != -1){
				output.write(buffer);
			}
			output.flush();
 		} catch (Exception e) {
 			e.printStackTrace();
		}finally{
			try {
				output.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return file;
		
	}
}
