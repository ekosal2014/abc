package com.product.sale.dao.daoimpl;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.product.sale.dao.dao.ProductDao;
import com.product.sale.forms.Message;
import com.product.sale.forms.ProductForm;
import com.product.sale.model.Category;
import com.product.sale.model.Image;
import com.product.sale.model.Menu;
import com.product.sale.model.Product;
import com.product.sale.model.Users;
import com.product.sale.utils.Pagination;
import com.product.sale.utils.StringUtils;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Message productAdd(HttpServletRequest request, ProductForm form, MultipartFile[] files) {
		// TODO Auto-generated method stub
		Session session = null;
		Message msg     = new Message();
		try{
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Product  product  = new Product();
			Users    user     = new Users();
			Category category = new Category();
			Menu     menu     = new Menu();
			
			user = (Users)request.getSession().getAttribute("user");
			category.setCateId(form.getCateId());
			menu.setMenuId(form.getMenuId());
			product.setUser(user);
			product.setCategory(category);
			product.setMenu(menu);
			product.setpName(form.getpName());
			product.setpPrice(form.getpPrice());
			product.setPdiscount(form.getPdiscount());
			product.setPdescription(form.getPdescription());
			product.setpStartDt(StringUtils.getCurrentDate());
			product.setPsts("0");
			if (files != null && files.length > 0){
				product.setpImgDefault(files[0].getOriginalFilename());
			}
			
			session.save(product);
			
			String fileName = null;			
			if (files != null && files.length > 0){
				for (int i = 0; i < files.length; i++) {
					try{
					
						fileName = files[i].getOriginalFilename();							
						File imageFile = new File(request.getServletContext().getRealPath("/static/img"),fileName);
						System.out.println(request.getServletContext().getRealPath("/static/img"));
						files[i].transferTo(imageFile);
						
						Image img = new Image();
						img.setiName(fileName);
						img.setProduct(product);
						session.save(img);
						
					}catch(Exception e){
						e.printStackTrace();
						msg.setCode("9999");
						msg.setMsg("Item Save Error.");
					}
				}
			}
			
			session.getTransaction().commit();
			session.close();
			msg.setCode("0000");
			msg.setMsg("Item Is Save Completed.");
		}catch(Exception e){
			e.printStackTrace();
			msg.setCode("9999");
			msg.setMsg("Item Save Error.");
		}
		return msg;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Map> productList(HttpServletRequest request,Pagination pagination) {
		// TODO Auto-generated method stub
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery("SELECT new Map(P.pId AS P_ID, P.pName AS P_NAME, P.pPrice AS P_PRICE, P.pdiscount AS P_DISCOUND, DATE_FORMAT(P.pStartDt,'%d-%m-%Y') AS P_START_DT, P.psts AS P_STS) "+
			                                  "FROM Product P WHERE P.user.uId = :uid "+
											  "ORDER BY P.pStartDt DESC,P.psts ASC");
				  query.setParameter("uid", ((Users)request.getSession().getAttribute("user")).getuId());				  
				  query.setFirstResult(pagination.previousPage() * pagination.getPerPage());
				  query.setMaxResults(pagination.getPerPage());
			List<Map> list= (List<Map>)query.list();
		
			return list;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Message productDelete(HttpServletRequest request, int pId) {
		// TODO Auto-generated method stub
		Session session = null;
		Message msg = new Message();
		try{
			
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			
			Product productdb = (Product) session.createCriteria(Product.class)
					                             .add(Restrictions.eq("pId",pId))
					                             .uniqueResult();
			if (productdb != null){
				session.delete(productdb);
			}else{
				msg.setCode("9998");
				msg.setMsg("Item Delete Invalid!");
			}
			
			
			session.getTransaction().commit();
			session.close();
			msg.setCode("0000");
			msg.setMsg("Item Is Deleted Completed.");
			
		}catch(Exception e){
			msg.setCode("9998");
			msg.setMsg("Item Delete Error!");
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long productListCount(HttpServletRequest request) {
		Session session = null;
		try{
			session = sessionFactory.openSession();
		
			return (Long) session.createCriteria(Product.class)
					             .add(Restrictions.eq("user", (Users)request.getSession().getAttribute("user")))
					             .setProjection(Projections.rowCount()).uniqueResult();			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
}
