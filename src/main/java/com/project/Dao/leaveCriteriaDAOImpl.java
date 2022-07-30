package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Model.DesignationVO;
import com.project.Model.leaveCriteriaVO;
@Repository
public class leaveCriteriaDAOImpl  implements leaveCriteriaDAO{
		
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(leaveCriteriaVO leavecriteriaVO) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(leavecriteriaVO);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<leaveCriteriaVO> search() {
		

		List<leaveCriteriaVO> leaveCriteriaList=new ArrayList<leaveCriteriaVO>();
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from leaveCriteriaVO where status=true");
			leaveCriteriaList=(List<leaveCriteriaVO>) query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return leaveCriteriaList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<leaveCriteriaVO> findById(int id) {
		
		List<leaveCriteriaVO> leaveCriteriaList=new ArrayList<leaveCriteriaVO>();
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from leaveCriteriaVO where status=true and leaveId="+ id  );
			leaveCriteriaList=(List<leaveCriteriaVO>) query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return leaveCriteriaList;
	}
	}


