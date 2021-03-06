package com.zym.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zym.crud.bean.Employee;
import com.zym.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pageNumber",defaultValue="1")Integer pn,Model model) {
		PageHelper.startPage(pn, 5);
		List<Employee> emps = employeeService.getAll();
		PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps, 5);
		model.addAttribute("pageInfo", pageInfo);
		return "list";
	}

}
