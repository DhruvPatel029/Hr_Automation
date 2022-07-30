package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.loanDAO;
import com.project.Model.loanVO;
@Service
@Transactional
public class loanServiceImpl implements loanService{
	
	@Autowired
	private loanDAO loandao;
	
	
	public void save(loanVO loanVO) {
		this.loandao.save(loanVO);
		
	}


	@Override
	public List<loanVO> search() {
		
		return this.loandao.search();
	}


	@Override
	public List<loanVO> findById(int id) {
		
		return this.loandao.findById(id);
	}

}
