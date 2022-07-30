package com.project.Dao;

import java.util.List;

import com.project.Model.loanVO;

public interface loanDAO {

	void save(loanVO loanVO);

	List<loanVO> search();

	List<loanVO> findById(int id);

}
