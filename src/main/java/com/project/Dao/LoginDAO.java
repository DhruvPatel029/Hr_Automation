package com.project.Dao;

import java.util.List;

import com.project.Model.LoginVO;
import com.project.Model.RegisterVO;

public interface LoginDAO {

	public void register(RegisterVO registerVO);

	public void insertLogin(LoginVO loginVO);

	public List searchLoginID(String loginService);

}
