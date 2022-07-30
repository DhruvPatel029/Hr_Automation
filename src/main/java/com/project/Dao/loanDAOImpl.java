package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.project.Model.loanVO;
@Repository
public class loanDAOImpl implements loanDAO {
		
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(loanVO loanVO) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(loanVO);
		
	}

	@Override
	public List<loanVO> search() {
		 List<loanVO> loanList=new ArrayList<loanVO>();
		 try
			{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from loanVO where status=true");
			loanList=(List<loanVO>) query.list();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return loanList;
		}

	@Override
	public List<loanVO> findById(int id) {
	
		 List<loanVO> loanList=new ArrayList<loanVO>();
		 try
			{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from loanVO where status=true and id="+id );
			loanList=(List<loanVO>) query.list();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return loanList;
		}
	}
	

