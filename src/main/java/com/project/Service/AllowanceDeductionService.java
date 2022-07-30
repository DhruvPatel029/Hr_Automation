package com.project.Service;
import java.util.List;

import com.project.Model.AllowanceDeductionVO;
public interface AllowanceDeductionService {

	void save(AllowanceDeductionVO allowanceDeductionVO);

	List<AllowanceDeductionVO> search();

	List<AllowanceDeductionVO> findById(int id);
	
	List<AllowanceDeductionVO> findByDesignationId(int id);


}
