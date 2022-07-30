package com.project.Service;

import java.util.List;

import com.project.Model.AttendenceVO;
import com.project.Model.EmployeeVO;

public interface AttendenceService {

	void save(AttendenceVO AttendenceVO);

	List<AttendenceVO> search();

	List<AttendenceVO> findById(int id);
	
	List<AttendenceVO> findByEmpId(int emp_id);

}
