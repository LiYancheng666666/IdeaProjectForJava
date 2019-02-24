package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import ch.qos.logback.classic.Logger;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtil {
	/**
	 * 处理店铺缩略图
	 * 
	 * @param args
	 * @throws IOException
	 */
	/**
	 * CommonsMultipartFile spring自带处理流方法
	 * 
	 * @param thumbnail
	 * @param targetAddr
	 * @return
	 */
	public static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	public static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final Random r = new Random();

	public static String generateThumbnail(InputStream thumbnailInputStream,String fileName, String targetAddr) {
		/**
		 * 文件名
		 */
		String realFileName = getRandomFileName();
		/**
		 * 文件扩展名
		 */
		String extension = getFileExtension(fileName);
		/**
		 * 创建文件夹
		 */
		makeDirPath(targetAddr);
		String relativeAddr = targetAddr + realFileName + extension;
		
		

		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);

		try {
			Thumbnails.of(thumbnailInputStream).size(200, 200)
					.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
					.outputQuality(0.8f).toFile(dest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return relativeAddr;
	}

	/**
	 * 创建目标路径所涉及到的目录,即/home/work/leo/xxx.jpg 那么 home work leo这三个文件夹都得创建
	 * 
	 * @param targetAddr
	 */

	private static void makeDirPath(String targetAddr) {
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		File dirPath = new File(realFileParentPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();

		}

	}

	/**
	 * 获取输入文件流的扩展名
	 * 
	 * @param thumbnail
	 * @return
	 */
	private static String getFileExtension(String fileName) {
//		String originalFileName = cFile.getOriginalFilename();
//		String originalFileName = cFile.getName();
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 生成随机文件名,当前年月日小时分钟+五位随机数字
	 * 
	 * @return
	 */
	public static String getRandomFileName() {
		// 获取随机的五位数
		int rannum = r.nextInt(89999) + 100000;
		String nowTimeStr = sDateFormat.format(new Date());

		return nowTimeStr + rannum;
	}

	public static void main(String[] args) throws IOException {

		System.out.println("basePath" + basePath);
		Thumbnails.of(new File("D:/Picture/xiaohuangren.jpg")).size(200, 200)
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("D:/Picture/xiaohuangrennew.jpg");

	}

}
