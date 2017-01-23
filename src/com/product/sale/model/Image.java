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
@Table(name="tbl_image")
public class Image {
	@Id
	@Column(name="I_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iId;
	
	@Column(name="I_NAME")
	private String iName;
	
	@ManyToOne
	@JoinColumn(name="P_ID")
	private Product product;

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

}
