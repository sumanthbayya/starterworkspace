package com.sumanthbayya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sumanthbayya.services.DepartmentService;
import com.sumanthbayya.vo.DepartmentVo;

@RestController
@RequestMapping(value = "v1/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DepartmentVo> getDepartments(){
		return departmentService.getDepartments();
		
	}
	
	@RequestMapping(value = "/updateDepartments", method = RequestMethod.POST)
	public String updateDepartment(@RequestBody List<DepartmentVo> departmentList) {
		return departmentService.updateDepartments(departmentList);
	}
	
	@RequestMapping(value = "/addDepartments", method = RequestMethod.POST)
	public String addDepartment(@RequestBody List<DepartmentVo> departmentList) {
		return departmentService.addDepartments(departmentList);
	}

}
