package com.product.sale.enums;

public enum UserSts {

	DELETE("0"), 
	ACTIVE("1"),
	LOCK("2"),
	INACTIVE("3"),
	;
	
	private String value;
	
	private UserSts (String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public UserSts fromValue(String value){
		for(UserSts my: UserSts.values()){
			if (my.value == value){
				return my;
			}
		}
		return null;
	}
	
	public String getLabel(){
		
		String label = "";
		if ("1".equals(value)){
			label = "ACTIVE";
		}else if ("2".equals(value)){
			label = "LOCK";
		}else if ("3".equals(value)){
			label = "INACTIVE";
		}else{
			label = "DELETE";
		}
		
		return label;
	}
}
