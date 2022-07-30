package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.Dao.DesignationDAO;

import com.project.Model.DesignationVO;
@Service
@Transactional
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationDAO designationDAO;
	@Override
	public void save(DesignationVO designationVO) {
		this.designationDAO.save(designationVO);
		
	}

	@Override
	public List<DesignationVO> search() {
		
		return this.designationDAO.search();
	}
	@Override
	public List<DesignationVO> findById(int id) {
		
		return this.designationDAO.findById(id);

}
}
