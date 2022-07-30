package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Model.DepartmentVO;
import com.project.Dao.DepartmentDAO;
@Repository
public class DepartmentDAOImpl implements DepartmentDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(DepartmentVO departmentVO) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(departmentVO);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentVO> search() {
		List<DepartmentVO> departmentList=new ArrayList<DepartmentVO>();
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from DepartmentVO where status=true");
			departmentList=(List<DepartmentVO>) query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return departmentList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentVO> findById(int id) {
		List<DepartmentVO> departmentList=new ArrayList<DepartmentVO>();
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from DepartmentVO where status=true and departmentId="+ id );
			departmentList=(List<DepartmentVO>) query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return departmentList;
	}

}
