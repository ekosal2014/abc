package com.product.sale.enums;

public enum UserType {
	USER("0"),
	ADMIN("1"),
	;
	
	private final String value;
	
	private UserType (String value){
		this.value=value;
	}
	
	public String getLabel(){
		
		String label = "";
		
		if ("0".equals(value)){
			label = "USER";
		}else{
			label = "ADMIN";
		}
		
		return label;
		
	}
	
	public UserType fromValue(String value){
		
		for(UserType my: UserType.values()){
			if (my.value==value){
				return my;
			}
		}
		return null;
		
	}
	
	public String getValue(){
		return value;
	}
}
