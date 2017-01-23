package com.product.sale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_category")
public class Category implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CATE_ID")
	private int cateId;
	
	@Column(name="CATE_NAME")
	private String cateName;
	
	@Column(name="CATE_PARENTS")
	private int cateParents;

	
	@Column(name="CATE_URL")
	private String url;
	
	@Column(name="CATE_STS")
	private String sts;
	
	@Column(name="CATE_ORDER")
	private String order;
	
	@ManyToOne
	@JoinColumn(name="U_ID")
	private Users user;
	
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getCateParents() {
		return cateParents;
	}
	public void setCateParents(int cateParents) {
		this.cateParents = cateParents;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	
	
}
