package com.imooc.o2o.service;

import java.io.File;
import java.io.InputStream;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

public interface ShopService {
	/**
	 * 添加shop
	 * @param shop
	 * @param shopImg
	 * @return
	 */
//	ShopExecution addShop(Shop shop,File shopImg);
	/**
	 * shopImg  改造为inputstream类型
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution addShop(Shop shop,InputStream shopImgInputStream,String fileName);

}
