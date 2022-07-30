package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.leaveCriteriaDAO;
import com.project.Model.leaveCriteriaVO;
@Service
@Transactional
public class leaveCriteriaServiceImpl implements leaveCriteriaService {

	
		
	@Autowired
	private leaveCriteriaDAO leavecriteriaDAO;
	@Override
	public void save(leaveCriteriaVO leavecriteriaVO) {
		this.leavecriteriaDAO.save(leavecriteriaVO);
	}

	@Override
	public List<leaveCriteriaVO> search() {
		
		return this.leavecriteriaDAO.search();
	}

	@Override
	public List<leaveCriteriaVO> findById(int id) {
		return this.leavecriteriaDAO.findById(id);
	}

}
