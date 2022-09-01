package com.training.services;

import java.util.List;

import com.training.EmpDao;
import com.training.Employee;

public class EmployeeService {
	
	private EmpDao empDao=new EmpDao();
	
	public Employee addEmployee(Employee emp)
	{
		if(empDao.addEmployee(emp) > 0)
			return emp;
		return null;
	}

	public Employee getEmployee(long empId)
	{
		return empDao.getEmployee(empId);
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployees();
	}

	public int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return empDao.deleteEmployee(empId);
	}
	
}
