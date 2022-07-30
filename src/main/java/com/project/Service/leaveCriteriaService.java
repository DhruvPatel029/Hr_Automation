package com.project.Service;

import java.util.List;


import com.project.Model.leaveCriteriaVO;

public interface leaveCriteriaService {

	void save(leaveCriteriaVO leavecriteriaVO);
	 List<leaveCriteriaVO> search();
	List<leaveCriteriaVO> findById(int id);


}
