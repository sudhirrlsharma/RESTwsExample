package com.sudhir.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class SearchCeriteria {

	@QueryParam("sortOrder")
	@DefaultValue("ASC")
	private String sortOrder;
	
	@QueryParam("limit")
	@DefaultValue("3")
	private int limit;
	
	
	public SearchCeriteria() {
	}
	
	
	
	public SearchCeriteria(String sortOrder,int limit) {
		this.sortOrder=sortOrder;
		this.limit = limit;
				
	}



	public String getSortOrder() {
		return sortOrder;
	}



	public int getLimit() {
		return limit;
	}
	
}
