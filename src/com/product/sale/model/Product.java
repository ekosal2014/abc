package com.product.sale.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="P_ID")
	private int pId;
	
	@Column(name="P_NAME")
	private String pName;
	
	@Column(name="P_PRICE")
	private int pPrice;
	
	@Column(name="P_DISCOUND")
	private int pdiscount;
	
	@Column(name="P_DEFAULD_IMAGE")
	private String pImgDefault;
	
	@Column(name="P_DECRIPTION")
	private String pdescription;
	
	@Column(name="P_START_DT")
	private String pStartDt;
	
	@Column(name="P_STS")
	private String psts;
	
	@ManyToOne
	@JoinColumn(name="CATE_ID")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="U_ID")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="MENU_ID")
	private Menu menu;
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private Set<Image> img = new HashSet<Image>();
	
	
	
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getPdiscount() {
		return pdiscount;
	}
	public void setPdiscount(int pdiscount) {
		this.pdiscount = pdiscount;
	}
	public String getpImgDefault() {
		return pImgDefault;
	}
	public void setpImgDefault(String pImgDefault) {
		this.pImgDefault = pImgDefault;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Set<Image> getImg() {
		return img;
	}
	public void setImg(Set<Image> img) {
		this.img = img;
	}
	public String getpStartDt() {
		return pStartDt;
	}
	public void setpStartDt(String pStartDt) {
		this.pStartDt = pStartDt;
	}
	public String getPsts() {
		return psts;
	}
	public void setPsts(String psts) {
		this.psts = psts;
	}
	
}
