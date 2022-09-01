package com.resources;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.bind.model.Customer;
import com.dao.CustomerDao;




// Will map the resource to the URL customers
@Path("/customers")
public class CustomerResources {
	// Allows to insert contextual objects into the class, 
	  // e.g. ServletContext, Request, Response, UriInfo
	  @Context
	  UriInfo uriInfo;
	  @Context
	  Request request;


	  // Return the list of customers to the user in the browser
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  public List<Customer> getCustomersBrowser() {
	    List<Customer> customers = new ArrayList<Customer>();
	    customers.addAll(CustomerDao.instance.getModel().values());
	    return customers; 
	  }
	  
	  // Return the list of customers for applications
	  @GET
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public List<Customer> getCustomers() {
	    List<Customer> customers = new ArrayList<Customer>();
	    customers.addAll(CustomerDao.instance.getModel().values());
	    return customers; 
	  }
	  
	  
	  // retuns the number of customers
	  // Use http://localhost:8080/de.vogella.jersey.customer/rest/customers/count
	  // to get the total number of records
	  @GET
	  @Path("count")
	  @Produces(MediaType.TEXT_PLAIN)
	  public String getCount() {
	    int count = CustomerDao.instance.getModel().size();
	    return String.valueOf(count);
	  }
	  
	  @POST
	  @Produces(MediaType.TEXT_HTML)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public void newCustomer(@FormParam("id") String id,
	      @FormParam("name") String name,
	      @FormParam("description") String description,
	      @Context HttpServletResponse servletResponse) throws IOException {
	    Customer customer = new Customer(id,name,description);
	    if (description!=null){
	      customer.setDescription(description);
	    }
	    CustomerDao.instance.getModel().put(id, customer);
	    
	    servletResponse.sendRedirect("../create_customer.html");
	  }
	  
	  
	  // Defines that the next path parameter after customers is
	  // treated as a parameter and passed to the CustomerResources
	  // Allows to type http://localhost:8080/de.vogella.jersey.customer/rest/customers/1
	  // 1 will be treaded as parameter customer and passed to CustomerResource
	  @Path("{customer}")
	  public CustomerResource getCustomer(@PathParam("customer") String id) {
	    return new CustomerResource(uriInfo, request, id);
	  }
}
