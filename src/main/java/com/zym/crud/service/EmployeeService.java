package com.zym.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zym.crud.bean.Employee;
import com.zym.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;

	public List<Employee> getAll() {
		
		return employeeMapper.selectByExampleWithDep(null);
	}

}
