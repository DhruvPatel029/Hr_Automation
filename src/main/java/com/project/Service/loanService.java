package com.project.Service;

import java.util.List;

import com.project.Model.loanVO;

public interface loanService {

	void save(loanVO loanVO);

	List<loanVO> search();

	List<loanVO> findById(int id);

}
