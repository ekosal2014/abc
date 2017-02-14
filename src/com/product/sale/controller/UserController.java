package com.product.sale.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.hibernate.type.descriptor.java.MutabilityPlan;
import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.product.sale.configuration.security.CustomSuccessConfiguration;
import com.product.sale.enums.UserSts;
import com.product.sale.forms.Message;
import com.product.sale.forms.ProductForm;
import com.product.sale.model.Menu;
import com.product.sale.model.Product;
import com.product.sale.model.Users;
import com.product.sale.service.service.CategoryService;
import com.product.sale.service.service.MenuService;
import com.product.sale.service.service.ProductService;
import com.product.sale.service.service.UserService;
import com.product.sale.utils.CheckEmail;
import com.product.sale.utils.Pagination;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	SessionRegistry sessionRegistry;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CategoryService categorySerivce;
	
	@Autowired 
	MenuService menuService;
	

	@Autowired
	ProductService productService;
	
	@Autowired
	CustomSuccessConfiguration customSuccessConfirguation;
	
	
	@RequestMapping(value = {"/","list"}, method = RequestMethod.GET)
	public String userHomePage(HttpSession session,HttpServletRequest request){
		userService.listUser();
		return  checkUserUrlSts(session,request, "index");
	}
	
	@RequestMapping(value="/Logout", method = RequestMethod.GET)
	public String userLogOut(HttpSession session, HttpServletRequest request, HttpServletResponse respone){		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ( auth != null){
			new SecurityContextLogoutHandler().logout(request, respone, auth);
		}
		
		
		for (Object principal : sessionRegistry.getAllPrincipals()){
			
			if (principal instanceof User) {
                UserDetails userDetails = (UserDetails) principal;                
                for (SessionInformation information : sessionRegistry.getAllSessions(userDetails, true)) {
                    information.expireNow();
                }                
            }
			
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String userDashboard(HttpSession session, HttpServletResponse response,HttpServletRequest request,ModelMap map){	
		map.addAttribute("user",(Users)request.getSession().getAttribute("user"));
		return checkUserUrlSts(session,request, "index");
		
	}
	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public String userProInfo(HttpSession session, HttpServletResponse response,HttpServletRequest request,ModelMap map){
		map.addAttribute("user",(Users)request.getSession().getAttribute("user"));
		return checkUserUrlSts(session,request, "profile");
	}
	
	
	@RequestMapping(value="/profile_edit", method = RequestMethod.GET)
	public String userProfileEdit(HttpSession session, HttpServletResponse response,HttpServletRequest request,ModelMap map){
		Users user = (Users) request.getSession().getAttribute("user");
        map.addAttribute("user",user);
		return "user/profile_edit";
	}
	
	@RequestMapping(value="/form_profile_upload", method = RequestMethod.POST)
	public @ResponseBody String userProfileUpdateImage(HttpServletRequest request,@ModelAttribute Users user,@RequestParam("image") MultipartFile file){
		
		if (request.getSession().getAttribute("user") == null){
			return "0";
		}

		if (file != null){
			try{
				File imageFile = new File(request.getServletContext().getRealPath("/static/user/img"),file.getOriginalFilename());
				System.out.println(request.getServletContext().getRealPath("/static/user/img"));
				file.transferTo(imageFile);
				user.setImageName(file.getOriginalFilename());
				if (userService.UpdateUserImage(user,request))
					return "1";					
				
			}catch(Exception e){
				e.printStackTrace();
				return "2";
			}
		
		}
		return "2";
	}
	
	@RequestMapping(value="/form_profile_info", method = RequestMethod.POST)
	public @ResponseBody String userUpdateProfile(@ModelAttribute Users user,HttpServletRequest request){
		
		if (request.getSession().getAttribute("user") == null){
			return "0";
		}
		
		if (userService.UpdateUserInformation(user,request)){
			return "1";
		}
		
		return "2";
	}
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String userProductInformation(HttpSession session,HttpServletRequest request,ModelMap map){
		
		Pagination pagination = new Pagination();		
		pagination.setCurrentPage(1);
		pagination.setPerPage(15);
		pagination.setTotalCount(productService.productListCount(request,""));
		pagination.setTotalPage(pagination.TotalPage());
		List<Map>  ListHolder = productService.productList(request,pagination,"");	
		map.put("pagedListHolder", ListHolder);
		map.put("pagination", pagination);
	
		return checkUserUrlSts(session,request, "product");
	}
	
	@RequestMapping(value="/search-product", method = RequestMethod.GET)
	public @ResponseBody ModelMap userProductInformationPage(HttpSession session,HttpServletRequest request,@RequestParam int size,@RequestParam int page,@RequestParam String name){
		
		Pagination pagination = new Pagination();
		ModelMap map = new ModelMap();
		pagination.setCurrentPage(page);
		pagination.setPerPage(size);
		map.put("List", productService.productList(request,pagination,name.trim()));
		pagination.setTotalCount(productService.productListCount(request,name.trim()));
		pagination.setTotalPage(pagination.TotalPage());		
		map.put("pagination", pagination);
		return map;

		
	}
	
	@RequestMapping(value="/cadenlar", method = RequestMethod.GET)
	public String userCanlendar(HttpSession session,HttpServletRequest request){
		return checkUserUrlSts(session,request, "calendar");
	}
	
	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String userAddProduct(HttpSession session,HttpServletRequest request,ModelMap map){
		Users user = new Users();
		user.setuId(0);
		map.put("menu", menuService.ListMenu((Users)request.getSession().getAttribute("user")));
		map.put("category", categorySerivce.ListCategory(user));
		return checkUserUrlSts(session,request, "addProduct");
	}
	
	
	@RequestMapping(value="/add-product", method = RequestMethod.POST)
	public @ResponseBody Message userAddProduct(HttpServletRequest request,@ModelAttribute ProductForm form,@RequestParam("file[]") MultipartFile[] multi) throws JsonGenerationException, JsonMappingException, IOException{
		return productService.productAdd(request, form, multi);
	}
	
	@RequestMapping(value="/delete-product", method = RequestMethod.GET)
	public @ResponseBody String userDeleteProduct(@RequestParam int pId,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{	
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(productService.productDelete(request, pId));
		return json;
	}
	
	
	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public String userCategory(HttpSession session,HttpServletRequest request,ModelMap map){
		 map.put("menu", menuService.ListMenu((Users)request.getSession().getAttribute("user")));	
		return checkUserUrlSts(session,request, "menu");
	}
	
	@RequestMapping(value="/addMenu", method = RequestMethod.GET)
	public String userCategoryView(HttpServletRequest request,HttpSession session,ModelMap map){	
		if (request.getSession().getAttribute("user") == null){
			return "redirect:/login?logout";
		}
	    map.put("menu", menuService.ListMenu((Users)request.getSession().getAttribute("user")));	    
		return checkUserUrlSts(session,request, "addMenu");
	}
	
	@RequestMapping(value="/menuAdd", method = RequestMethod.POST)
	public @ResponseBody String userMenuAdd(HttpServletRequest request,HttpSession session,@ModelAttribute Menu menu) throws JsonGenerationException, JsonMappingException, IOException{	
		if (request.getSession().getAttribute("user") == null){
			return "redirect:/login?logout";
		}
		
		Users user = (Users) request.getSession().getAttribute("user");
		menu.setUser(user);		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(menuService.MenuAdd(menu, request));
		return json;
		
	}
	
	@RequestMapping(value="/listcategory", method = RequestMethod.POST)
	public @ResponseBody String userListCategory(HttpServletRequest request){
		if (request.getSession().getAttribute("user") == null){
			return "redirect:/login?logout";
		}
		String data = new Gson().toJson(categorySerivce.ListCategory((Users)request.getSession().getAttribute("user")));
		return data;
	}
	
	@RequestMapping(value="/delete-menu", method = RequestMethod.GET)
	public @ResponseBody String userCategoryDelete(@RequestParam("id") int id,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		if (request.getSession().getAttribute("user") == null){
			return "redirect:/login?logout";
		}
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(menuService.MenuDelete(id, request));
		return json;
	}
	
	@RequestMapping(value="/remove-menu", method = RequestMethod.GET)
	public @ResponseBody String userCategoryRemove(@RequestParam("id") int id,HttpServletRequest request){
		if (request.getSession().getAttribute("user") == null){
			return "redirect:/login?logout";
		}
		return menuService.MenuRemove(id, request).toString();
	}
	
	@RequestMapping(value="/update-menu", method = RequestMethod.POST/*,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE*/)
	public @ResponseBody String userUdateCategory(@RequestBody ArrayList<Menu> list,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(menuService.MenuUpdate(list, request));
		return json;
	}
	
	@RequestMapping(value="/name-menu", method = RequestMethod.POST/*,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE*/)
	public @ResponseBody String userUdateCategoryName(@RequestBody Menu menu,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException{
		if (request.getSession().getAttribute("user") == null){
			return "redirect:/login?logout";
		}
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(menuService.MenuUpdateName(menu, request));
		return json;
	}
	
	/*@RequestMapping(value="/Layout", method = RequestMethod.GET)
	public String userMenu(HttpSession session,HttpServletRequest request){		
		return checkUserUrlSts(session,request, "layout");
	}*/
	
	@RequestMapping(value="/email", method = RequestMethod.GET)
	public String useremail(HttpSession session,HttpServletRequest request,ModelMap map){
		map.put("email", CheckEmail.check("pop.gmail.com", "pop3", "ekosal2014@gmail.com", "bmyncvxibaywftpx"));
		return checkUserUrlSts(session,request, "email");
	}
	
	@RequestMapping(value="/emaillist", method = RequestMethod.GET)
	public @ResponseBody String useremaillist(HttpSession session,HttpServletRequest request,ModelMap map) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		//String json = ow.writeValueAsString(CheckEmail.check("pop.gmail.com", "pop3", "ekosal2014@gmail.com", "bmyncvxibaywftpx"));
		return "";
	}
	
	@RequestMapping(value="/form_upload", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String userFormUpload(@RequestParam("image[]") MultipartFile[] files,HttpServletRequest requet){

		List<String> fileNameLst = new ArrayList<String>();
		String fileName = null;
	    Gson gson = new Gson();
		if (files != null && files.length > 0){
			for (int i = 0; i < files.length; i++) {
				try{
					fileName = files[i].getOriginalFilename();
					fileNameLst.add(fileName);
					File imageFile = new File(requet.getServletContext().getRealPath("/static/img"),fileName);
					System.out.println(requet.getServletContext().getRealPath("/static/img"));
					files[i].transferTo(imageFile);
				}catch(Exception e){
					e.printStackTrace();
					return "false";
				}
			}
		}
		String data = gson.toJson(fileNameLst);
		return data;
		
	}
	
	private String checkUserUrlSts(HttpSession session,HttpServletRequest request, String page){		
		String url = null;
		try{
			session = request.getSession(false);
			url = !((Users)session.getAttribute("user")).getuSts().equals(UserSts.INACTIVE.getValue()) ?  "user/"+page : "redirect:/user/profile_edit"; 	
		
		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/login?logout";
		}
		return url;
	}
    
	private String validateSession(HttpServletRequest request){
		if (request.getSession().getAttribute("user") == null){
			return "0";
		}
		return null;
	}
}
