package com.project.Dao;

import java.util.List;

import com.project.Model.DepartmentVO;

public interface DepartmentDAO {

	
	 void save(DepartmentVO departmentVO);
	 
	 List<DepartmentVO> search();

	List<DepartmentVO> findById(int id);
}
