package com.imooc.o2o.util;

public class PathUtil {
	public static String seperator = System.getProperty("file.separator");

	/**
	 * 返回项目图片根路径
	 * @return
	 */
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/Picture/";
		} else {
			basePath = "/home/leo/image/";
		}

		basePath = basePath.replace("/", seperator);

		return basePath;
	}

	/**
	 * 返回项目图片子路径
	 * @param shopId
	 * @return
	 */
	public static String getShopImagePath(long shopId) {
		String imagePath = "upload/item/shop/" + shopId + "/";

		return imagePath.replace("/", seperator);

	}

}
