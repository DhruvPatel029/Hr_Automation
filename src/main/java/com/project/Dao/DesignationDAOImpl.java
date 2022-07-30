package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.project.Model.DesignationVO;
@Repository
public class DesignationDAOImpl implements DesignationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(DesignationVO designationVO) {
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(designationVO);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DesignationVO> search() {
		
			List<DesignationVO> designationList=new ArrayList<DesignationVO>();
			try{
				Session session=sessionFactory.getCurrentSession();
				Query query=session.createQuery("from DesignationVO where status=true");
				designationList=(List<DesignationVO>) query.list();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return designationList;
		}
	@SuppressWarnings("unchecked")
	@Override
	public List<DesignationVO> findById(int id) {
		
		List<DesignationVO> designationList=new ArrayList<DesignationVO>();
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from DesignationVO where status=true and designationId="+ id  );
			designationList=(List<DesignationVO>) query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return designationList;
	}
	}
	


