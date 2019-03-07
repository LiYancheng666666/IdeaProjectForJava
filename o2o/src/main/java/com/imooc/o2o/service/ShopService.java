package com.imooc.o2o.service;

import java.io.InputStream;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;

public interface ShopService {
	
	/**
	 *  根据shopCo ndition分页返回相应店铺列表
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
	
	/**
	 * 通过店铺Id获取店铺信息
	 */
	Shop getByShopId(long shopId);
	
	/**
	 * 更新店铺信息
	 */
	ShopExecution modifyShop(Shop shop,InputStream shopImgInputStream,String fileName) throws ShopOperationException;
	
	/**
	 * 添加shop  包括图片处理
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
	ShopExecution addShop(Shop shop,InputStream shopImgInputStream,String fileName) throws ShopOperationException;

}
