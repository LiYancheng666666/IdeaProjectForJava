package com.imooc.o2o.web.shopadmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.service.ShopCategoryService;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.CodeUtil;
import com.imooc.o2o.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	@Autowired
	private ShopService shopService;

	@Autowired
	private ShopCategoryService shopCategoryService;
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/getshopinitinfo", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopInitInfo() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
		List<Area> areaList = new ArrayList<Area>();

		try {
			shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
			areaList = areaService.getAreaList();
			modelMap.put("shopCategoryList", shopCategoryList);
			modelMap.put("areaList", areaList);
			modelMap.put("success", true);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}
		return modelMap;

	}

	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		if (!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "输入了错误的验证码！");
			return modelMap;
		}

		// 1.接收并转化相应的参数,包括店铺信息以及图片信息
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		// 将json转化为pojo
		// 1.先new ObjectMapper实例
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			// 将json转化为pojo
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}

		CommonsMultipartFile shopImg = null;
		// 传入的参数是 servletContext
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断其中是否有上传的文件流
		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		} else {

			modelMap.put("success", false);
			modelMap.put("errMsg", "上传图片不能为空");
			return modelMap;
		}

		// 2.注册店铺
		if (shop != null && shopImg != null) {
			PersonInfo owner = new PersonInfo();

			// Session TODO
			owner.setUserId(1L);

			shop.setOwner(owner);
			/**
			 * 
			 * File shopImgFile = new File(PathUtil.getImgBasePath() +
			 * ImageUtil.getRandomFileName());
			 * 
			 * try { shopImgFile.createNewFile(); } catch (IOException e) {
			 * modelMap.put("success", false); modelMap.put("errMsg", e.getMessage());
			 * return modelMap; }
			 */

			/**
			 * 这个转化不需要了 try { inputStreamToFile(shopImg.getInputStream(), shopImgFile); }
			 * catch (IOException e) { modelMap.put("success", false);
			 * modelMap.put("errMsg", e.getMessage()); return modelMap; }
			 */
//		ShopExecution se = shopService.addShop(shop, shopImgFile);
			ShopExecution se;
			try {
				se = shopService.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
				if (se.getState() == ShopStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", se.getStateInfo());
				}
			} catch (ShopOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}

			return modelMap;

		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "请输入店铺信息");
			return modelMap;

		}
		// 已经在上面写好了
		// 3.返回结果

	}

	/**
	 * 
	 * @param ins
	 * @param file
	 * 
	 *             //有设计不合理之处，产生过多的文件，有写入失败的风险 private static void
	 *             inputStreamToFile(InputStream ins,File file) { FileOutputStream
	 *             os = null;
	 * 
	 *             try { os = new FileOutputStream(file); int bytesRead = 0; byte[]
	 *             buffer = new byte[1024]; while ((bytesRead=ins.read(buffer))!=-1)
	 *             { os.write(buffer, 0, bytesRead); }
	 * 
	 *             } catch (Exception e) { throw new
	 *             RuntimeException("调用InputStreamToFile产生异常" + e.getMessage()); }
	 *             finally { try { if(os!=null) { os.close(); } if (ins!=null) {
	 *             ins.close();
	 * 
	 *             } } catch (IOException e) { throw new
	 *             RuntimeException("调用InputStreamToFile关闭IO产生异常" + e.getMessage());
	 *             } } }
	 */

}
