package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.AttendenceDAO;
import com.project.Model.AttendenceVO;
import com.project.Model.EmployeeVO;

@Service
@Transactional
public class AttendenceServiceImpl implements AttendenceService {


	@Autowired
	private AttendenceDAO AttendanceDao;
	@Override
	public void save(AttendenceVO AttendenceVO) {
		this.AttendanceDao.save(AttendenceVO);
		
	}

	@Override
	public List<AttendenceVO> search() {
		
		return this.AttendanceDao.search();
	}

	@Override
	public List<AttendenceVO> findById(int id) {
		
		return this.AttendanceDao.findById(id);
		
	}

	@Override
	public List<AttendenceVO> findByEmpId(int emp_id) {
		// TODO Auto-generated method stub
		return this.AttendanceDao.findByEmpId(emp_id);
	}


}
