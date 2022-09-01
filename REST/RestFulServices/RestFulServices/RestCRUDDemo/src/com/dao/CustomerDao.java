package com.dao;

import java.util.HashMap;
import java.util.Map;

import com.bind.model.Customer;

public enum CustomerDao {
	instance;
	  
	  private Map<String, Customer> contentProvider = new HashMap<String, Customer>();
	  
	  private CustomerDao() {
	    
	    Customer customer = new Customer("1", "Sam","old");
	    
	    contentProvider.put("1", customer);
	    customer = new Customer("2", "John","newcustomer");
	  
	    contentProvider.put("2", customer);
	    
	  }
	  public Map<String, Customer> getModel(){
	    return contentProvider;
	  }
}
