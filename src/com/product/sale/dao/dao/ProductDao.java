package com.product.sale.dao.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


import com.product.sale.forms.Message;
import com.product.sale.forms.ProductForm;
import com.product.sale.model.Product;
import com.product.sale.utils.Pagination;

public interface ProductDao{	

	public Message productAdd(HttpServletRequest request,ProductForm form, MultipartFile[] multi);
	public List<Map> productList(HttpServletRequest request,Pagination pagination, String name);
	public Long productListCount(HttpServletRequest request,String name);
	public Message productDelete(HttpServletRequest request,int pId);
	
}
