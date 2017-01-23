package com.product.sale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_location")
public class Location {

		@Id
		@Column(name="L_ID")
		private int lId;
		
		public int getlId() {
			return lId;
		}

		public void setlId(int lId) {
			this.lId = lId;
		}

		public String getlName() {
			return lName;
		}

		public void setlName(String lName) {
			this.lName = lName;
		}

		@Column(name="L_NAME")
		private String lName;
}
