package com.product.sale.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tbl_User")
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="U_ID")
	private int uId;
	
	@Column(name="U_FIRSTNAME")
	private String uFirstName;
	
	@Column(name="U_LASTNAME")
	private String uLastName;
	
	@Column(name="U_GENDER")
	private String uGender;
	
	@Column(name="U_PHONE")
	private String uPhone;
	
	@Column(name="U_ADDRESS")
	private String uAddress;
	
	@Column(name="U_EMAIL", unique=true, nullable=false)
	private String uEmail;
	
	@Column(name="U_PASSWORD", nullable=false)
	private String uPassWord;
	
	@Column(name="U_STS")
	private String uSts;
	
	@Column(name="U_TXT")
	private String uTxt;
	
	@Column(name="U_NOTE")
	private String uNote;
	
	@Column(name="U_LOGIN_DATE")
	private String ulogindt;
	
	@Column(name="U_CODE")
	private String uCode;
	
	@Column(name="U_FACEBOOK")
	private String uFaceBook;
	
	@Column(name="U_TWITTER")
	private String uTwitter;
	
	@Column(name="U_SKYPE")
	private String uSkype;
	
	@Column(name="U_GOOGLE_PLUS")
	private String uGooglePlus;
	
	@Column(name="U_PHOTO")
	private String imageName;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)	
	private Set<Category> category = new HashSet<Category>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)	
	private Set<Menu> menu = new HashSet<Menu>();

	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getUlogindt() {
		return ulogindt;
	}
	public void setUlogindt(String ulogindt) {
		this.ulogindt = ulogindt;
	}
	public String getuCode() {
		return uCode;
	}
	public void setuCode(String uCode) {
		this.uCode = uCode;
	}
	
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuFirstName() {
		return uFirstName;
	}
	public void setuFirstName(String uFirstName) {
		this.uFirstName = uFirstName;
	}
	public String getuLastName() {
		return uLastName;
	}
	public void setuLastName(String uLastName) {
		this.uLastName = uLastName;
	}
	public String getuGender() {
		return uGender;
	}
	public void setuGender(String uGender) {
		this.uGender = uGender;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPassWord() {
		return uPassWord;
	}
	public void setuPassWord(String uPassWord) {
		this.uPassWord = uPassWord;
	}
	
	public String getuSts() {
		return uSts;
	}
	public void setuSts(String uSts) {
		this.uSts = uSts;
	}
	public String getuTxt() {
		return uTxt;
	}
	public void setuTxt(String uTxt) {
		this.uTxt = uTxt;
	}
	public String getuNote() {
		return uNote;
	}
	public void setuNote(String uNote) {
		this.uNote = uNote;
	}
	
	public String getuFaceBook() {
		return uFaceBook;
	}
	public void setuFaceBook(String uFaceBook) {
		this.uFaceBook = uFaceBook;
	}
	public String getuTwitter() {
		return uTwitter;
	}
	public void setuTwitter(String uTwitter) {
		this.uTwitter = uTwitter;
	}
	public String getuSkype() {
		return uSkype;
	}
	public void setuSkype(String uSkype) {
		this.uSkype = uSkype;
	}
	public String getuGooglePlus() {
		return uGooglePlus;
	}
	public void setuGooglePlus(String uGooglePlus) {
		this.uGooglePlus = uGooglePlus;
	}
	
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	
	
	
}
