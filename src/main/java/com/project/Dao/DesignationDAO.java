package com.project.Dao;

import java.util.List;


import com.project.Model.DesignationVO;

public interface DesignationDAO {


	 void save(DesignationVO designationVO);
		 
		 List<DesignationVO> search();
		

		List<DesignationVO> findById(int id);

		
}
