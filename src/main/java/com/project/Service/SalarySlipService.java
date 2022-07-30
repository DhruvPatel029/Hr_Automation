package com.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.Dao.SalarySlipDAO;
import com.project.Model.SalarySlipVO;

@Service
public class SalarySlipService {
	@Autowired
	SalarySlipDAO salarySlipDAO;

	@Transactional
	public void insert(SalarySlipVO salarySlipVO) {
		this.salarySlipDAO.insert(salarySlipVO);
		
	}

	public List<SalarySlipVO> search(){
		return this.salarySlipDAO.search();
	}

}
