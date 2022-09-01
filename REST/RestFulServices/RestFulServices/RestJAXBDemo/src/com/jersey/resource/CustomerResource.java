package com.jersey.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jaxb.model.Customer;

@Path("/customer")
public class CustomerResource {
	@GET
	  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	  public Customer getXML() {
	    Customer customer = new Customer();
	    customer.setCustId(123);
	    customer.setCustName("This is my first Customer");
	    return customer;
	  }
	  
	  // This can be used to test the integration with the browser
	  @GET
	  @Produces({ MediaType.TEXT_XML })
	  public Customer getHTML() {
	    Customer customer = new Customer();
	    customer.setCustId(124);
	    customer.setCustName("This is my Second Customer");
	    return customer;
	  }

}
