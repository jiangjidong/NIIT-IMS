package org.njgc.com.mapper;

import java.util.List;

import org.njgc.com.bean.Info;
import org.njgc.com.bean.Login;

public interface LoginMapper {
	
	public int getLoginResult(Login login);	
	
	public int insertLogin(Login login);
}
