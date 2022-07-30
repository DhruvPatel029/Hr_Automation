package com.project.Service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.DepartmentDAO;
import com.project.Model.DepartmentVO;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	
	@Autowired
	private DepartmentDAO departmentDao;
	@Override
	public void save(DepartmentVO departmentVO) {
		this.departmentDao.save(departmentVO);
		
	}

	@Override
	public List<DepartmentVO> search() {
		
		return this.departmentDao.search();
	}

	@Override
	public List<DepartmentVO> findById(int id) {
		
		return this.departmentDao.findById(id);
		
	}

}
