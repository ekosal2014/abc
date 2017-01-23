package com.product.sale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MENU_ID")
	private int menuId;
	
	@Column(name="MENU_NAME")
	private String menuName;
	
	@Column(name="MENU_PARENTS")
	private int menuParents;

	
	@Column(name="MENU_URL")
	private String url;
	
	@Column(name="MENU_STS")
	private String sts;
	
	@Column(name="MENU_ORDER")
	private String order;
	
	@ManyToOne
	@JoinColumn(name="U_ID")
	private Users user;
	
	
	
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuParents() {
		return menuParents;
	}

	public void setMenuParents(int menuParents) {
		this.menuParents = menuParents;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	
	
}
