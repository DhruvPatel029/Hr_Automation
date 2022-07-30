package com.project.Service;

import java.util.List;

import com.project.Model.EmployeeVO;

public interface EmployeeService {

	void save(EmployeeVO EmployeeVO);

	List<EmployeeVO> search();

	List<EmployeeVO> findById(int id);
	
	List<EmployeeVO> findByemployeeId(String id);

}
