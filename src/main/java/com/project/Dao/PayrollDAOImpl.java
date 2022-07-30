package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Model.DesignationVO;
import com.project.Model.PayrollVO;

@Repository
public class PayrollDAOImpl implements PayrollDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(PayrollVO payrollVO) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(payrollVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PayrollVO> search() {
		List<PayrollVO> payrollList = new ArrayList<PayrollVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from PayrollVO where status=true");
			payrollList = (List<PayrollVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PayrollVO> findById(int id) {

		List<PayrollVO> payrollList = new ArrayList<PayrollVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from PayrollVO where status=true and payrollId=" + id);
			payrollList = (List<PayrollVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollList;
	}

	@Override
	public List<PayrollVO> findByDesignationID(int des) {
		List<PayrollVO> payrollList = new ArrayList<PayrollVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from PayrollVO where designationVO = " + des);
			payrollList = (List<PayrollVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return payrollList;

	}

	@Override
	public double calculatePayroll(double workingDays, double presentDays, double basicSalary, int allowanceLimit,
			int deductionLimit) {
		// TODO Auto-generated method stub
		double absentDays = workingDays - presentDays;
		double daySalary = basicSalary/workingDays;
		double salary_1 = basicSalary - (absentDays*daySalary);
		//double awlded = Double.parseDouble((allowanceLimit-deductionLimit)/100);
		
		//System.out.println("alw-ded:::::: "+awlded);
		double totalAllowanceDeduction =((basicSalary)*(allowanceLimit)/100)-((basicSalary)*(deductionLimit)/100);
		System.out.println("totalAllowanceDeduction::::::"+totalAllowanceDeduction);
		double finalSalary = salary_1 + totalAllowanceDeduction;
		System.out.println("finalSalary ::::::"+finalSalary);
		return finalSalary;
	}
	
	

}
