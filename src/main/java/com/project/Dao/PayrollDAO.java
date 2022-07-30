package com.project.Dao;

import java.util.List;

import com.project.Model.DesignationVO;
import com.project.Model.PayrollVO;

public interface PayrollDAO {

	void save(PayrollVO payrollVO);

	List<PayrollVO> search();

	List<PayrollVO> findById(int id);

	List<PayrollVO> findByDesignationID(int ids);

	double calculatePayroll(double workingDays, double presentDays, double basicSalary, int allowanceLimit,
			int deductionLimit);

	

}
