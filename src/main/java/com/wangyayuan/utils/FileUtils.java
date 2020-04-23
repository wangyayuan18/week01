package com.wangyayuan.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	/***
	 * 涓婁紶鏂规硶
	 * @param photo
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String upload (MultipartFile photo) throws IllegalStateException, IOException {
		String filePath = "";
		String originalFilename = "";
		String uuid = "";
		if(!photo.isEmpty()) {
			//鏈嶅姟鍣ㄤ笂鐪熷疄鐨勮矾寰�
			//String realPath = session.getServletContext().getRealPath("upload/");
			String realPath = "G:\\img\\";
			/*File file = new File(realPath);
			file.mkdirs();*/
			//鏂囦欢鐨勫師濮嬪悕绉�
			originalFilename = photo.getOriginalFilename();
			//涓轰簡淇濊瘉鏂囦欢鍚嶇殑鍞竴鎬�
			uuid = UUID.randomUUID().toString().replace("-", "");
			if(originalFilename.endsWith("png")||originalFilename.endsWith("jpg")) {
				File file = new File(realPath+"/"+uuid+originalFilename);
				photo.transferTo(file);
			}
		}
		//鏂囦欢鍦ㄦ湰鍦扮鐩樹腑
		filePath = "G:\\img\\"+uuid+originalFilename;

		return filePath;
	}
	/***
	 * 鏌ョ湅鏈湴纾佺洏鐨勫浘鐗�
	 * @param path
	 * @param request
	 * @param response
	 */
	public static  void lookImg(String path,HttpServletRequest request,
			HttpServletResponse response) {
		
		File file = new File(path);
		if(file.exists()){
			FileInputStream fis = null;
			OutputStream os = null;
			try {
				fis = new FileInputStream(path);
				os = response.getOutputStream();
				int count = 0;
				byte[] buffer = new byte[1024 * 8];
				while ((count = fis.read(buffer)) != -1) {
					os.write(buffer, 0, count);
					os.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				fis.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/***
	 * 涓嬭浇鏂规硶
	 * @param filepath
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static String download(String filepath,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		OutputStream fos = null;
		InputStream fis = null;

		try {
			// 濡傛灉鏄粠鏈嶅姟鍣ㄤ笂鍙栧氨鐢ㄨ繖涓幏寰楃郴缁熺殑缁濆璺緞鏂规硶銆�
			//String filepath = request.getRealPath(filepatha);//鏂规硶杩囨椂浜�
			//String filepathall = request.getSession().getServletContext().getRealPath(filepath);

			File uploadFile = new File(filepath);

			fis = new FileInputStream(uploadFile);
			bis = new BufferedInputStream(fis);
			fos = response.getOutputStream();
			bos = new BufferedOutputStream(fos);

			//寰楀埌鏂囦欢鍚�
			String filename = filepath.substring(filepath.lastIndexOf("\\")+1);

			// 杩欎釜灏卞氨鏄脊鍑轰笅杞藉璇濇鐨勫叧閿唬鐮�
			response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));

			int bytesRead = 0;
			// 鐢ㄨ緭鍑烘祦鍘诲啓锛岀紦鍐茶緭鍏ヨ緭鍑烘祦
			byte[] buffer = new byte[8192];
			while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.flush();
				}
				if (fis != null) {
					fis.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
