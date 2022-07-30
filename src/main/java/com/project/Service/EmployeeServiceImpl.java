package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.EmployeeDAO;
import com.project.Model.EmployeeVO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO addEmployeeDAO;

	@Override
	public void save(EmployeeVO EmployeeVO) {
		this.addEmployeeDAO.save(EmployeeVO);

	}


	public List<EmployeeVO> search() {

		return this.addEmployeeDAO.search();
	}


	@Override
	public List<EmployeeVO> findById(int id) {
	
		return this.addEmployeeDAO.findById(id);
	}


	@Override
	public List<EmployeeVO> findByemployeeId(String id) {
		// TODO Auto-generated method stub
		return this.addEmployeeDAO.findByemployeeId(id);
	}

}
