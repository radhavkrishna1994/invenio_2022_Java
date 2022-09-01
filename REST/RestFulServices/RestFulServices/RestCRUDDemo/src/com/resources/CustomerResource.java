package com.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.bind.model.Customer;
import com.dao.CustomerDao;

public class CustomerResource {
	@Context
	  UriInfo uriInfo;
	  @Context
	  Request request;
	  String id;
	  public CustomerResource(UriInfo uriInfo, Request request, String id) {
	    this.uriInfo = uriInfo;
	    this.request = request;
	    this.id = id;
	  }
	  
	  //Application integration     
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Customer getCustomer() {
	    Customer Customer = CustomerDao.instance.getModel().get(id);
	    if(Customer==null)
	      throw new RuntimeException("Get: Customer with " + id +  " not found");
	    return Customer;
	  }
	  
	  // For the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public Customer getCustomerHTML() {
	    Customer Customer = CustomerDao.instance.getModel().get(id);
	    if(Customer==null)
	      throw new RuntimeException("Get: Customer with " + id +  " not found");
	    return Customer;
	  }
	  
	  @PUT
	  @Consumes(MediaType.APPLICATION_XML)
	  public Response putCustomer(JAXBElement<Customer> Customer) {
	    Customer c = Customer.getValue();
	    return putAndGetResponse(c);
	  }
	  
	  @DELETE
	  public void deleteCustomer() {
	    Customer c = CustomerDao.instance.getModel().remove(id);
	    if(c==null)
	      throw new RuntimeException("Delete: Customer with " + id +  " not found");
	  }
	  
	  private Response putAndGetResponse(Customer Customer) {
	    Response res;
	    if(CustomerDao.instance.getModel().containsKey(Customer.getCustId())) {
	      res = Response.noContent().build();
	    } else {
	      res = Response.created(uriInfo.getAbsolutePath()).build();
	    }
	    CustomerDao.instance.getModel().put(Customer.getCustId()+"", Customer);
	    return res;
	  }
}
