package org.njgc.com.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.njgc.com.mapper.InfoMapper;
import org.njgc.com.mapper.InformationMapper;
import org.njgc.com.mapper.LoginMapper;
import org.njgc.com.bean.Info;
import org.njgc.com.bean.Information;
import org.njgc.com.bean.Login;
import org.njgc.com.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;

public class DbServiceImpl implements DbService {
	

	private InfoMapper infoMapper;
	public void setInfoMapper(InfoMapper infoMapper) {
			this.infoMapper = infoMapper;
		}
	
    @Autowired
	private LoginMapper loginMapper;
	public void setLoginMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	
	private InformationMapper informationMapper;
	public void setInformationMapper(InformationMapper informationMapper) {
		this.informationMapper = informationMapper;
	}

	private String msg;
	private DataSource ds;
	
	public void setMsg(String msg) {
		this.msg = msg;
		
	}
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	



	@Override
	public void showMsg() {
		System.out.println("This is "+msg);
	}

	@Override
	public int insert(Info info) {
		if(info == null){
			return 0;
		}
		if(info.getIntro() == null){
			info.setIntro("");
		}
		
		String sql = "insert into info (name,intro) values (?,?)";
		Connection con = null;
		
		try{
			con = ds.getConnection();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, info.getName());
			ps.setString(2, info.getIntro());
			
			int result = ps.executeUpdate();
			return result;

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}

	@Override
	public int delete(int id) {
		String sql = "delete from info where id = ? ";
		Connection con = null;
		
		try{
			con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			int result = ps.executeUpdate();
			return result;

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public int update(Info info) {
		if(info == null){
			return 0;
		}
		if(info.getIntro() == null){
			info.setIntro("");
		}
		
		String sql = "update info set name = ?,intro = ? where id=?";
		Connection con = null;
		
		try{
			con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, info.getName());
			ps.setString(2, info.getIntro());
			ps.setInt(3, info.getId());
			
			int result = ps.executeUpdate();
			return result;

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public List<Info> getInfo(int id) {
		if(id==0){
			return infoMapper.queryInfos();
		}else{
			List<Info> infoList=new ArrayList<>();
			infoList.add(infoMapper.queryInfo(id));
			return infoList;
		}
		
		/*String sql = "select * from info ";
		Connection con = null;
		
		try{
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			if(id != 0){
				sql += " where id = "+id;
			}
			sql += " order by id";
			ResultSet rs = stmt.executeQuery(sql);
			
			List<Info> infoList = new ArrayList<>();
			while(rs.next()){
				Info inf = new Info();
				inf.setId(rs.getInt("id"));
				inf.setName(rs.getString("name"));
				inf.setIntro(rs.getString("intro"));
				infoList.add(inf);
			}
			
			return infoList;

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return null;*/
	}

	@Override
	public int getLoginResult(Login login) {
		// TODO Auto-generated method stub		
		return loginMapper.getLoginResult(login);	
		//return null;
	}

	@Override
	public int insertLogin(Login login) {
		// TODO Auto-generated method stub
		return loginMapper.insertLogin(login);
	}

	@Override
	public List<Information> getInformation(String name) {
		// TODO Auto-generated method stub
		/*if(name==""){
			return informationMapper.queryInfos();
		}else{
			List<Information> infoList=new ArrayList<>();
			infoList.add(informationMapper.queryInfoByName(name));
			return infoList;
		}*/
		
		return informationMapper.queryInfoByName("Tom");		
	}

}
