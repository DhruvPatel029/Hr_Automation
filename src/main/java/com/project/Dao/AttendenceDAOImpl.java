package com.project.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Model.AttendenceVO;
import com.project.Model.EmployeeVO;
@Repository
public class AttendenceDAOImpl implements AttendenceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(AttendenceVO attendenceVO) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(attendenceVO);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AttendenceVO> search() {
		List<AttendenceVO> AttendanceList=new ArrayList<AttendenceVO>();
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from AttendenceVO where status=true");
			AttendanceList=(List<AttendenceVO>) query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return AttendanceList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AttendenceVO> findById(int id) {
		List<AttendenceVO> AttendanceList=new ArrayList<AttendenceVO>();
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from AttendenceVO where status=true and id="+ id );
			AttendanceList=(List<AttendenceVO>) query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return AttendanceList;
	}

	@Override
	public List<AttendenceVO> findByEmpId(int emp_id) {
		// TODO Auto-generated method stub
		List<AttendenceVO> AttendanceList=new ArrayList<AttendenceVO>();
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from AttendenceVO where status=true and employeeVO="+ emp_id);
			AttendanceList=(List<AttendenceVO>) query.list();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return AttendanceList;
	}

}
