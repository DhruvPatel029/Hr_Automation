package com.project.Service;
import java.util.List;

import com.project.Model.DesignationVO;
import com.project.Model.PayrollVO;
public interface PayrollService {

	
	void save(PayrollVO payrollVO);

	List<PayrollVO> search();

	List<PayrollVO> findById(int id);

	List<PayrollVO> findByDesignationID(int id);

	double calculatePayroll(double workingDays, double presentDays, double basicSalary, int allowanceLimit,
			int deductionLimit);

	

	

}
