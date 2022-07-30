package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.Model.PayrollVO;
import com.project.Model.SalarySlipVO;

@Repository
@Transactional
@EnableTransactionManagement

public class SalarySlipDAOImpl implements SalarySlipDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void insert(SalarySlipVO salarySlipVO) {
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(salarySlipVO);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<SalarySlipVO> search() {
		List<SalarySlipVO> salaryList = new ArrayList<SalarySlipVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SalarySlipVO where status=true");
			salaryList =  query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return salaryList;
	}

}
