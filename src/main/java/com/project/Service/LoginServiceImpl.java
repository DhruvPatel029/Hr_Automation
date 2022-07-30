package com.project.Service;

import java.util.List;

import com.project.Model.LoginVO;
import com.project.Model.RegisterVO;

public interface LoginServiceImpl {

	public void insertRegister(RegisterVO registerVO);
	
	public void insertLogin(LoginVO loginVO);
	
	public List searchLoginID(String loginService);
}
