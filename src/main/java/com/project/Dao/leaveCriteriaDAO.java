package com.project.Dao;

import java.util.List;

import com.project.Model.leaveCriteriaVO;

public interface leaveCriteriaDAO {

	void save(leaveCriteriaVO leavecriteriaVO);
	 List<leaveCriteriaVO> search();
	List<leaveCriteriaVO> findById(int id);

}
