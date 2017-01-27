package com.product.sale.service.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.product.sale.dao.dao.ProductDao;
import com.product.sale.forms.Message;
import com.product.sale.forms.ProductForm;
import com.product.sale.model.Product;
import com.product.sale.service.service.ProductService;
import com.product.sale.utils.Pagination;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public Message productAdd(HttpServletRequest request, ProductForm form, MultipartFile[] multi) {
		// TODO Auto-generated method stub
		return productDao.productAdd(request, form, multi);
	}

	@Override
	public List<Map> productList(HttpServletRequest request,Pagination pagination,String name) {
		// TODO Auto-generated method stub
		return productDao.productList(request,pagination,name);
	}

	@Override
	public Message productDelete(HttpServletRequest request, int pId) {
		// TODO Auto-generated method stub
		return productDao.productDelete(request, pId);
	}

	@Override
	public Long productListCount(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return productDao.productListCount(request);
	}

}
