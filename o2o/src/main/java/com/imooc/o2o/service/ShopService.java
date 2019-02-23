package com.imooc.o2o.service;

import java.io.File;


import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;

public interface ShopService {
	/**
	 * 添加shop
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution addShop(Shop shop,File shopImg);

}
