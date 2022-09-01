package com.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class EmpDao {
	
	//Connect to database
	/*
	 * private String jdbcDriverClass = "com.mysql.cj.jdbc.Driver"; private String
	 * dbUrl = "jdbc:mysql://localhost:3306/training"; private String
	 * username="root"; private String password="root";
	 */
	
	private Connection connection;
	public EmpDao()
	{
		/*
		 * try { //step 1 load the driver Class.forName(jdbcDriverClass); //Step 2 get
		 * the connection
		 * 
		 * connection = DriverManager.getConnection(dbUrl,username,password);
		 * if(connection!=null) System.out.println("Ping Successful");
		 * 
		 * } catch (ClassNotFoundException e) {
		 * 
		 * e.printStackTrace(); } catch (SQLException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
		connection = new DbConnection().getConnection();
		System.out.println(connection);
		if(connection != null)
			System.out.println("Ping Successful..");
	}
	
	public int addEmployee(Employee emp)
	{
		//Step 3
		String template = "insert into employee values(?,?,?)";
		try(PreparedStatement pstmt = connection.prepareStatement(template)) {
		
		pstmt.setLong(1, emp.getEmpCode());
		pstmt.setString(2, emp.getName());
		pstmt.setString(3, emp.getDept());
		
		return pstmt.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace(); return -1;
		}
		
	}
	
	public List<Employee> getAllEmployees()
	{
		String template = "select * from employee";
		List<Employee> empList=new ArrayList<>();
		try(Statement stmt = connection.createStatement())
		{
			ResultSet rs = stmt.executeQuery(template);
			while(rs.next())
			{
				Employee emp=new Employee();
				//System.out.println(rs.getLong(1)+" "+rs.getString(2)rs.getString(2)+" "+rs+" "+rs.getString(3));
			emp.setEmpCode(rs.getLong(1));
			emp.setName(rs.getString(2));
			emp.setDept(rs.getString(3));
			empList.add(emp);
						
			}
			return empList;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace(); return empList;
		}
	}
	
	public int deleteEmployee(long empId)
	{
		String template = "delete from employee where empid=?";
		try(PreparedStatement pstmt = connection.prepareStatement(template)) {
		
		pstmt.setLong(1, empId);
				
		return pstmt.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace(); return -1;
		}
		
	}
	
	public Employee getEmployee(long empId)
	{
		String template = "select * from employee where empid=?";
		
		try(PreparedStatement pstmt = connection.prepareStatement(template))
		{
			pstmt.setLong(1,empId);
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next())
				return null;
			else
			{
				Employee emp=new Employee();
				//System.out.println(rs.getLong(1)+" "+rs.getString(2)rs.getString(2)+" "+rs+" "+rs.getString(3));
			emp.setEmpCode(rs.getLong(1));
			emp.setName(rs.getString(2));
			emp.setDept(rs.getString(3));
			
			return emp;
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();return null;
		}
	}
	
	public int updateDept(long empId,String newDept)
	{
		return -1;
	}
	
	public static void main(String[] args) {
		
		EmpDao empDao =new EmpDao();
		System.out.println(empDao.getAllEmployees());
	}

}
