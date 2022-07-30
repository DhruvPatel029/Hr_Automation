package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Model.AllowanceDeductionVO;

@Repository
public class AllowanceDeductionDAOImpl implements AllowanceDeductionDAO {

	
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public void save(AllowanceDeductionVO allowanceDeductionVO) {
		Session session=sessionfactory.getCurrentSession();
		session.saveOrUpdate(allowanceDeductionVO);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AllowanceDeductionVO> search() {
		List<AllowanceDeductionVO> allowanceDeductionlist=new ArrayList<AllowanceDeductionVO>();
		try
		{
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("from AllowanceDeductionVO where status=true");
		allowanceDeductionlist=(List<AllowanceDeductionVO>) query.list();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allowanceDeductionlist;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AllowanceDeductionVO> findById(int id) {
		List<AllowanceDeductionVO> allowanceDeductionlist=new ArrayList<AllowanceDeductionVO>();
	
		try
		{
			Session session=sessionfactory.getCurrentSession();
			Query query=session.createQuery("from AllowanceDeductionVO where status=true and allowanceDeductionId="+id);
			allowanceDeductionlist=(List<AllowanceDeductionVO>) query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allowanceDeductionlist;
		}
	@Override
	public List<AllowanceDeductionVO> findByDesignationId(int id) {
		// TODO Auto-generated method stub
		List<AllowanceDeductionVO> allowanceDeductionlist=new ArrayList<AllowanceDeductionVO>();
		
		try
		{
			Session session=sessionfactory.getCurrentSession();
			Query query=session.createQuery("from AllowanceDeductionVO where status=true and designationId="+id);
			allowanceDeductionlist=(List<AllowanceDeductionVO>) query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return allowanceDeductionlist;
	}
	}


