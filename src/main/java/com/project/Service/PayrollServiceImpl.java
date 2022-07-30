package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.PayrollDAO;
import com.project.Model.DesignationVO;
import com.project.Model.PayrollVO;

@Service
@Transactional
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	private PayrollDAO payrollDAO;

	@Override
	public void save(PayrollVO payrollVO) {
		this.payrollDAO.save(payrollVO);

	}

	@Override
	public List<PayrollVO> search() {

		return this.payrollDAO.search();
	}

	@Override
	public List<PayrollVO> findById(int id) {

		return this.payrollDAO.findById(id);
	}

	@Override
	public List<PayrollVO> findByDesignationID(int id) {
		return this.payrollDAO.findByDesignationID(id);
	}

	@Override
	public double calculatePayroll(double workingDays, double presentDays, double basicSalary, int allowanceLimit,
			int deductionLimit) {
		// TODO Auto-generated method stub
		return this.payrollDAO.calculatePayroll(workingDays, presentDays,  basicSalary,  allowanceLimit,
				 deductionLimit);
	}

}
