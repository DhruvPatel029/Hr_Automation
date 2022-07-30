package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.project.Model.EmployeeVO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(EmployeeVO employeeVO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(employeeVO);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> search() {
		List<EmployeeVO> EmployeeList=new ArrayList<EmployeeVO>();
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			Query query=session.createQuery("from EmployeeVO where status=true");
			EmployeeList=(List<EmployeeVO>) query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return EmployeeList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> findById(int id) {
	
		List<EmployeeVO> EmployeeList=new ArrayList<EmployeeVO>();
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			
			Query query=session.createQuery("from EmployeeVO where status=true and id="+id);
			EmployeeList=(List<EmployeeVO>) query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return EmployeeList;
	}

	@Override
	public List<EmployeeVO> findByemployeeId(String id) {
		// TODO Auto-generated method stub
		List<EmployeeVO> EmployeeList=new ArrayList<EmployeeVO>();
		try
		{
			Session session = this.sessionFactory.getCurrentSession();
			
			Query query=session.createQuery("from EmployeeVO where status=true and Employee_id='"+id+"'");
			EmployeeList=(List<EmployeeVO>) query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return EmployeeList;
	}
	}

