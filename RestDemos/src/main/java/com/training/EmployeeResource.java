package com.training;

import java.util.List;

import com.training.services.EmployeeService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/employee")
public class EmployeeResource {

	private EmployeeService employeeService=new EmployeeService();
	
	@GET
	public String sayHello()
	{
		return "Hello! This is a Rest Service";
	}
	
	
	/*
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @GET
	 * 
	 * @Path("/getemployee") public Employee getEmployee() { return new
	 * Employee(1234, "sam", "sales"); }
	 */
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/getemployees")
	public List<Employee> getEmployees()
	{
		
		
		return employeeService.getAllEmployees();
	}
	
	/*
	 * @POST
	 * 
	 * @Path("addemployee") public int addEmployee(@FormParam("empId") long
	 * empId,@FormParam("name") String name,@FormParam("dept") String dept) { EmpDao
	 * empDao = new EmpDao();
	 * 
	 * int records = empDao.addEmployee(empId, name, dept); return records; }
	 */
	
	// http://localhost:8080/RestDemos/employee/deleteemployee/empid/1234
	@DELETE
	@Path("deleteemployee/empid/{empid}")
	public int deleteEmployee(@PathParam("empid") int empId)
	{
		
		return employeeService.deleteEmployee(empId);
	}
	
	
	//http://localhost:8080/RestDemos/employee/getemployee?empid=1234
	//@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("/getemployee")
	public Employee getEmployee(@QueryParam("empid") long empId)
	{
		
		return employeeService.getEmployee(empId);
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	@Path("addemployee")
	public Employee addEmployee(Employee emp) // requestbody
	{
		
		return employeeService.addEmployee(emp);
	}
	
	
}
