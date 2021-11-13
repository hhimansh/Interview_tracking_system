package com.wipro.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.util.DBUtil;

public class AdminstratorLoginDAO implements AdminLoginDAO  
{
	Connection con=DBUtil.getDBConnection("");
	String s;
	PreparedStatement pst;
	ResultSet rs;
	CredentialsBean credentialsBean;

	@Override
	public boolean checkAuthenticate(CredentialsBean credentialsBean) 
	{
		try
		{
			s="Select userId,password from ITS_TBL_User_Credentials where userId=? AND password=?";
			pst=con.prepareStatement(s);
			pst.setString(1,credentialsBean.getUserID());
			pst.setString(2,credentialsBean.getPassword());
			rs=pst.executeQuery();
			while(rs.next())
			{
				return true;
			}
			return false;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public String checkAuthorize(String userId) 
	{
		credentialsBean= new CredentialsBean();
		try
		{
			 s="select userType from ITS_TBL_User_Credentials where userid=?";
			pst=con.prepareStatement(s);
			pst.setString(1,userId);
			rs= pst.executeQuery();
			if(rs.next())
			{
				return rs.getString(1);
			}
			else 
				return null;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return null;
		}
		
	}
	

	@Override
	public boolean changeStatus(CredentialsBean credentialsBean, int loginStatus)
	{
		try
		{
			s="update ITS_TBL_User_Credentials set Loginstatus=? where userId=?";
			pst=con.prepareStatement(s);
			pst.setInt(1, loginStatus);
			pst.setString(2,credentialsBean.getUserID());
			int a = pst.executeUpdate();
			if(a>0)
			{
				return true;
			}
			return false;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String forgotPassword(CredentialsBean cb)
	{
		try
		{
			String cmd = "SELECT password FROM ITS_TBL_User_credentials WHERE userID = ? AND userType = ?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, cb.getUserID());
			pst.setString(2, cb.getUserType());
			rs = pst.executeQuery();
			if(rs.next())
				return rs.getString(1);
			else return null;
		}
		catch(Exception e)
		{
//			e.printStackTrace();
			return null;
		}
	}
}
