package com.project.Dao;

import java.util.List;

import com.project.Model.SalarySlipVO;

public interface SalarySlipDAO {

public	void insert(SalarySlipVO salarySlipVO);

public List<SalarySlipVO> search();

}
