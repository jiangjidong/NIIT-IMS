package org.njgc.com.mapper;

import java.util.List;

import org.njgc.com.bean.Information;

public interface InformationMapper {
	
	public List<Information> queryInfos();
	
	
	public List<Information> queryInfoByName(String name);
}
