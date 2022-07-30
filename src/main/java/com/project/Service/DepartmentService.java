package com.project.Service;

import java.util.List;

import com.project.Model.DepartmentVO;

public interface DepartmentService {
	
	void save(DepartmentVO departmentVO);

	List<DepartmentVO> search();

	List<DepartmentVO> findById(int id);

}
