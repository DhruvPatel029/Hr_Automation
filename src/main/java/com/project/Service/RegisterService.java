package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.Dao.RegisterDAO;
import com.project.Model.RegisterVO;

@Service
public class RegisterService {
	
	@Autowired RegisterDAO registerDAO;
	
	@Transactional
	public void insertRegister(RegisterVO registerVO) {
		this.registerDAO.insertRegister(registerVO);
	}

}
