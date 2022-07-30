package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.AllowanceDeductionDAO;
import com.project.Model.AllowanceDeductionVO;

@Service
@Transactional
public class AllowanceDeductionServiceImpl implements AllowanceDeductionService {

	
		
	@Autowired
	private AllowanceDeductionDAO allowancedeductionDAO;
	@Override
	public void save(AllowanceDeductionVO allowanceDeductionVO) {
		this.allowancedeductionDAO.save(allowanceDeductionVO);
		
	}
	@Override
	public List<AllowanceDeductionVO> search() {
		
		return this.allowancedeductionDAO.search();
	}
	@Override
	public List<AllowanceDeductionVO> findById(int id) {
		
		return this.allowancedeductionDAO.findById(id);
	}
	@Override
	public List<AllowanceDeductionVO> findByDesignationId(int id) {
		// TODO Auto-generated method stub
		return this.allowancedeductionDAO.findByDesignationId(id);
	}

}
