package com.project.Service;

import java.util.List;


import com.project.Model.DesignationVO;

public interface DesignationService {

 void save(DesignationVO designationVO);
	 
	 List<DesignationVO> search();
	 List<DesignationVO> findById(int id);
}
