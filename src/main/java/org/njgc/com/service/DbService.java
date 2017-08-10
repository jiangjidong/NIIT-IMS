package org.njgc.com.service;

import java.util.List;

import org.njgc.com.bean.Info;
import org.njgc.com.bean.Information;
import org.njgc.com.bean.Login;

public interface DbService {
	
	public void showMsg();
	
	//db
	public int insert(Info info);
	
	public int delete(int id);
	
	public int update(Info info);
	
	public List<Info> getInfo(int id);
	
	public int getLoginResult(Login login);
	
	public int insertLogin(Login login);
	
	public List<Information> getInformation(String name);	
}
