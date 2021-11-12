package com.example.finalexam.utils;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * @author GuDongHu
 */
public class util {
	
	/**
	 * 32MD5锟斤拷锟斤拷
	 * @param str 锟斤拷锟斤拷锟斤拷锟街凤拷锟斤拷
	 * @return 32位MD5锟斤拷锟斤拷锟街凤拷锟斤拷
	 * @throws NoSuchAlgorithmException
	 */
	public static String UseMD5(String str) throws NoSuchAlgorithmException  {
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		BigInteger bigInteger=new BigInteger(1, md.digest());
		return bigInteger.toString(16);
	}
	
	/**
	 * 锟斤拷取系统锟斤拷前锟斤拷锟斤拷时锟斤拷
	 * @return 系统锟斤拷前锟斤拷锟斤拷时锟斤拷
	 */
	public static String getNowTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		return df.format(System.currentTimeMillis()); 
	}
	
	/**
	 * 锟斤拷取锟斤拷前学锟斤拷
	 * @return 系统锟斤拷前学锟斤拷
	 */
	public static String getNowCurricula(){
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		if(month<=8){
			return (year-1)+"-"+year+"学锟斤拷 锟斤拷学锟斤拷";
		}
		return year+"-"+(year+1)+"学锟斤拷 锟斤拷学锟斤拷";		
	}
	
	/**
	* 锟斤拷锟节斤拷锟届常锟斤拷锟斤拷e锟叫的达拷锟斤拷锟斤拷息锟斤拷锟斤拷为一锟斤拷String锟斤拷
	锟斤拷锟斤拷锟斤拷锟斤拷锟街凤拷锟斤拷
	* 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街撅拷募锟斤拷锟斤拷锟饺�
	* @param e 锟届常锟斤拷锟斤拷
	* @return 锟届常锟斤拷锟斤拷锟叫碉拷锟届常锟斤拷息锟街凤拷锟斤拷
	*/
	public static String getExceptionMsg(Throwable e){
		//锟斤拷锟届常锟斤拷锟斤拷锟叫碉拷锟届常锟斤拷录转锟斤拷为锟斤拷录锟斤拷锟斤拷
		StackTraceElement[] s = e.getStackTrace();
		StringBuffer sb = new StringBuffer();//锟斤拷锟斤拷锟斤拷锟斤拷取锟斤拷锟届常锟斤拷息锟斤拷锟斤拷锟斤拷为一锟斤拷锟街凤拷锟斤拷
		for(int i=0;i<s.length;i++){
			sb.append("\r\n");
			sb.append(s[i]);
		}
		return sb.toString();
	}
	
	public static Object convertNull(Object obj){
		if(obj==null)
			return "";
		return obj;
	}
	/**
	 * 锟侥硷拷锟较达拷锟斤拷锟斤拷
	 * @param servlet Servlet锟斤拷锟斤拷
	 * @param request request锟斤拷锟斤拷
	 * @param dirname 锟较达拷目锟斤拷锟侥硷拷锟斤拷
	 * @param fileName 锟较达拷锟斤拷锟侥硷拷锟斤拷
	 * @throws Exception 锟届常
	 */
	public static String fileupload(HttpServlet servlet,
			HttpServletRequest request, String dirname, String fileName)
			throws Exception {
		 // 锟斤拷锟斤拷锟较达拷锟斤拷锟斤拷
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 锟斤拷锟斤拷锟节达拷锟劫斤拷值 - 锟斤拷锟斤拷锟襟将诧拷锟斤拷锟斤拷时锟侥硷拷锟斤拷锟芥储锟斤拷锟斤拷时目录锟斤拷
        factory.setSizeThreshold(1024 * 1024 * 3);        
        // 锟斤拷锟斤拷锟斤拷时锟芥储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir"))); 
        ServletFileUpload upload = new ServletFileUpload(factory);         
        // 锟斤拷锟斤拷锟斤拷锟斤拷募锟斤拷洗锟街�
        upload.setFileSizeMax(1024 * 1024 * 40);         
        // 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街� (锟斤拷锟斤拷锟侥硷拷锟酵憋拷锟斤拷锟斤拷)
        upload.setSizeMax(1024 * 1024 * 50);        
        // 锟斤拷锟侥达拷锟斤拷
        upload.setHeaderEncoding("UTF-8"); 

        
        String uploadPath = servlet.getServletContext().getRealPath("/")  + dirname;
       
        System.out.println(uploadPath);
        // 锟斤拷锟侥柯硷拷锟斤拷锟斤拷锟斤拷虼唇锟�
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        } 
      
        // 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟饺★拷募锟斤拷锟斤拷锟�
        @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
            for (FileItem item : formItems) {
                // 锟斤拷锟斤拷锟节憋拷锟叫碉拷锟街讹拷
                if (!item.isFormField()) {
                	
                	String fName = new File(item.getName()).getName();
                	System.out.println(fName);
                	String type=fName.substring(fName.indexOf("."), fName.length());
                	System.out.println(type);
                	if(fileName.equals("")){
                		fileName = new File(item.getName()).getName();
                	}else{
                		fileName=fileName+type;
                	}
                    String filePath = uploadPath + File.separator + fileName;
                    System.out.println(filePath);
                    File storeFile = new File(filePath);
                    // 锟节匡拷锟斤拷台锟斤拷锟斤拷募锟斤拷锟斤拷洗锟铰凤拷锟�
                    System.out.println(filePath);
                    // 锟斤拷锟斤拷锟侥硷拷锟斤拷硬锟斤拷
                    if(storeFile.exists()){
                    	storeFile.delete();
                    }
                    item.write(storeFile);                        
                }
            }
        }
        return fileName;
   
	}
	//锟斤拷锟斤拷
	public static void main(String[] args) {
		System.out.println(getNowTime());
	}

}
