package com.fang.fangshop.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fang.fangshop.core.been.Catalog;
import com.fang.fangshop.core.common.ManageContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.fang.fangshop.services.impl.CatalogServiceImpl;

@Controller
@RequestMapping(value="/manage/product")
public class ProductController {
	
//	@Autowired
//	private CatalogServiceImpl catalogService;
//
//	@RequestMapping(value="selectList")
//	public String productEdit(ModelMap map){
////		List<Catalog> catalogList = new ArrayList<Catalog>();
////		catalogList = ConvertListToTreeData.getTreeData(catalogService.selectList(null));
////		if(catalogList != null && catalogList.size()>0){
////			map.addAttribute("catalogs", catalogList);
////		}
//		return "manage/product/productEdit";
//	}
//
//	@RequestMapping(value="uploadImg")
//	public String uploadImg(@RequestParam MultipartFile inputFile) throws IOException{
//		String fileName = inputFile.getOriginalFilename();
//		InputStream inputStream = inputFile.getInputStream();
//		uploadImgToServer((FileInputStream)inputStream, fileName);
//		return "";
//	}
//
//	public void uploadImgToServer(FileInputStream fileInputSteam,String fileName) throws IOException{
//		File file = new File(ManageContainer.manage_product_img+fileName);
//		byte[] buffer = new byte[1024];
//		int temp =0 ;
//		boolean b = file.createNewFile();
//		if(b){
//			FileOutputStream fileOutputStream = new FileOutputStream(file);
//			while((temp=fileInputSteam.read(buffer))!=-1){
//				fileOutputStream.write(buffer);
//			}
//		}

//	}
}
