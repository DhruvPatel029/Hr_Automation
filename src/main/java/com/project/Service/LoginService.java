package com.project.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.LoginDAO;
import com.project.Model.LoginVO;
import com.project.Model.RegisterVO;
@Service
public class LoginService {

	@Autowired
	 private LoginDAO loginDAO;

	@Transactional
	public void insertRegister(RegisterVO registerVO) {
		loginDAO.register(registerVO);
	}

	@Transactional
	public void insertLogin(LoginVO loginVO) {
		// TODO Auto-generated method stub
		loginDAO.insertLogin(loginVO);
	}

	@Transactional
	public List searchLoginID(String loginService) {
		// TODO Auto-generated method stub
		List ls = loginDAO.searchLoginID(loginService);
		return ls;
	}
}