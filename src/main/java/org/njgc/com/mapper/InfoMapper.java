package org.njgc.com.mapper;

import java.util.List;

import org.njgc.com.bean.Info;

public interface InfoMapper {
	
	public List<Info> queryInfos();
	
	public Info queryInfo(int id);
	
	public int queryCount();
	
	public int insertInfo(Info info);
	
	public int updateInfo(Info info);
	
	public int deleteInfo(Info info);
	
	public int deleteInfo(int id);
}
