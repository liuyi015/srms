package cn.ly.srms.action.common.tool;

import org.apache.log4j.Logger;


import java.io.*;
/**
 * <p>Title: 与文件相关操作的支持类</p>
 * <p>Description:只能使用它的静态方法</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: 雁联</p>
 * @author 郭兵
 * @version 1.0
 */
public class FileUtil {
	/**
	 * Log4J Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FileUtil.class);

	private FileUtil(){};
	
	/**
	 * 根据给定的文件位置获取该文件的输入流
	 * @param file String 文件路径，注意可以是相对classpath的路径
	 * @return InputStream
	 */
	public static InputStream getInputStream(String file) {
		
		InputStream in = null;
		
		//如果是磁盘路径
		try
		{
			in = new FileInputStream(file);
			return in;
		}
		catch (FileNotFoundException e)
		{
		}

		//如果磁盘路径找不到，尝试从classpath中寻找
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = FileUtil.class.getClassLoader();
		}
		in = classLoader.getResourceAsStream(file);
		return in;
	}

	
	/**
	 * 复制文件
	 * @param srcFile  源文件路径
	 * @param destFile  目标文件路径
	 */
	public static void copy(String srcFile, String destFile) throws Exception
	{
		
		if (null == srcFile || 0 == srcFile.length())
		{
			logger.error("要复制的源文件为空，复制失败");
			throw new RuntimeException("要复制的源文件为空，复制失败");
		}

		if (null == destFile || 0 == destFile.length())
		{
			logger.error("要复制的目的文件为空，复制失败");
			throw new RuntimeException("要复制的目的文件为空，复制失败");
		}
		
		File fileFrom = new File(srcFile);
		File fileTo = new File(destFile);
		
		try
		{
			int byteRead = 0;
			InputStream inStream = new FileInputStream(fileFrom);
			FileOutputStream foStream = new FileOutputStream(fileTo);
			BufferedOutputStream boStream = new BufferedOutputStream(foStream);
			byte[] buffer = new byte[1440];
			while ((byteRead = inStream.read(buffer)) != -1)
			{
				boStream.write(buffer, 0, byteRead);
				boStream.flush();
			}
			inStream.close();
			foStream.close();

		}
		catch (Exception e)
		{
			logger.error("复制文件" + srcFile + "到" + destFile + "失败，" + e);
			throw e;
		}
	}

	/**
	 * 根据文件全路径获取文件名
	 * @param filePath 文件全路径
	 * @return 文件名
	 */
	public static String getFileName(String filePath)
	{
		int start = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));
		return filePath.substring(start+1);
	}
	
	/**
	 * 根据文件全路径获取文件内容
	 * @param filePath 文件全路径
	 * @return 文件名
	 */
	public static String getFileContent(String filePath) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

		StringBuffer sb = new StringBuffer();
		String data = null;
		while((data = in.readLine())!=null)
		{
			sb.append(data + System.getProperty("line.separator"));
		}
		in.close();
		return sb.toString();
	}

	/**
	 * 根据文件全路径获取文件第一行内容
	 * @param filePath 文件全路径
	 * @return 文件名
	 */
	public static String getFileFirstLine(String filePath) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "GBK"));
		StringBuffer sb = new StringBuffer();
		String data = null;
		data = in.readLine();
		sb.append(data);
		in.close();
		return sb.toString();
	}
	

	
	/**
	 * 删除目录，包括目录下文件
	 * @param delpath 目录路径
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void deletefile(File delpath) throws FileNotFoundException,
			IOException {
		File[] filelist = delpath.listFiles();
		if (filelist.length != 0) {
			for (int i = 0; i < filelist.length; i++) {
				if (filelist[i].isDirectory())
					deletefile(filelist[i]);
				else
					filelist[i].delete();
			}
			delpath.delete();
		} else
			delpath.delete();
	}
	
	/**
	 * 清除文件夹中的全部内容
	 * @param dir
	 */
	public static void clearDir(File dir) throws FileNotFoundException,
	IOException{
		File[] filelist = dir.listFiles();
		if (filelist.length != 0) {
			for (int i = 0; i < filelist.length; i++) {
				if (filelist[i].isDirectory())
					deletefile(filelist[i]);
				else
					filelist[i].delete();
			}
		}
	}
	/**
	 * 清除文件夹中的全部内容
	 * @param dirPath 
	 */
	public static void clearDir(String dirPath) throws FileNotFoundException,IOException{
		File dir = new File(dirPath);
		clearDir(dir);
	}
    /**
     * 获得指定文件的byte数组 
     * @param filePath
     * @return
     */
    public static byte[] getBytes(String filePath)
    {
        byte[] buffer = new byte[0];
        try
        {
            File file = new File(filePath);
            if (!file.exists())
                return buffer;
            
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return buffer;
    }
    
    /**
     * 創建一個目錄，
     * 如果目錄存在則返回成功，
     * @param folder 文件夾路徑
     * @return true，成功，false 失敗
     */
    public static boolean mkdir(String folder)
    {
    	File file = new File(folder);
    	if(file.isFile())
    	{
    		return false;
    	}
    	if(file.isDirectory())
    	{
    		return true;
    	}
    	
    	return file.mkdir();
    }
    
    /**
     * 將文本内容寫入文件
     * @param filePath  文件路徑
     * @param context   寫入内容
     * @return
     * @throws IOException 
     */
    public static boolean writeFile(String filePath,String context) throws IOException
    {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
		
		// 将数据写入文件
		bufferedWriter.write(context);
		
		// 结束操作
		bufferedWriter.flush();
		bufferedWriter.close();
		return true;
    }
    
    
    public static void writeFile(String targetFileName,  File sourceFile) throws IOException{
		
		FileOutputStream out = new FileOutputStream(targetFileName);
		FileInputStream in = new FileInputStream(sourceFile);
		
		byte [] buffer = new byte[1024];
		int len = 0;
		
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
		}
		
		out.close();
		in.close();
    }
    public static String getFlleLength(File file){
    	return file.length()+"";
    }
    

	public static void main(String[] args)
	{
			String  dir = "D:/123";
			try {
				clearDir(new File(dir));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
  
	
}
