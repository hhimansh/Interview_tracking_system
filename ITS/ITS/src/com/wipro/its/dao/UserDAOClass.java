package com.wipro.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.util.DBUtil;

public class UserDAOClass implements UserDao 
{
	AdminstratorLoginDAO alDao;
	Connection con=DBUtil.getDBConnection("");
	String s;
	PreparedStatement pst;
	ResultSet rs;
	@Override
	public int checkLogin(CredentialsBean credentialsBean) 
	{
		try
		{
			s="select loginstatus from ITS_TBL_User_Credentials where userId=? AND password=?";
			pst= con.prepareStatement(s);
			pst.setString(1, credentialsBean.getUserID());
			pst.setString(2, credentialsBean.getPassword());
			rs=pst.executeQuery();
			rs.next();
			int status=rs.getInt(1);
			return status;
		}
		catch(Exception e)
		{
			return 0;
		}
	}

	@Override
	public boolean checkLogout(String userId) 
	{
		try
		{
			s="update ITS_TBL_User_Credentials set loginstatus=0 where userId=?";
			pst=con.prepareStatement(s);
			pst.setString(1, userId);
			rs=pst.executeQuery();
			con.commit();
			while(rs.next())
			{
				return true;
			}

			return false;

		}
		catch(Exception e)
		{
			return false;
		}

	}

	@Override
	public String doChangePassword(CredentialsBean credentialsBean,String newPassword)
	{
		try
		{
			s="update ITS_TBL_User_Credentials set password=? where userId=?";
			pst=con.prepareStatement(s);
			pst.setString(1, newPassword);
			pst.setString(2,credentialsBean.getUserID());
			int n=pst.executeUpdate();
			if(n>0)
			{
				return "Passowrd Changed";

			}
			con.commit();
			return null;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public String register(CredentialsBean credentialsBean) {
		try
		{
			String password="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
			String cmd = "SELECT userID FROM ITS_TBL_User_Credentials WHERE userID = ?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, credentialsBean.getUserID());
			rs = pst.executeQuery();
			if(rs.next())
			{
				return "EXIST";
			}
			else if(!(credentialsBean.getPassword().matches(password)))
			{
				return "WEAK PASS";
			}
			else
			{
				cmd = "INSERT INTO ITS_TBL_User_Credentials VALUES (?,?,?,?)";
				pst = con.prepareStatement(cmd);
				pst.setString(1, credentialsBean.getUserID());
				pst.setString(2, credentialsBean.getPassword());
				pst.setString(3, credentialsBean.getUserType());
				pst.setInt(4, credentialsBean.getLoginStatus());
				int a = pst.executeUpdate();
				if(a>0)
					return "SUCCESS";
				else return "FAIL";
			}
		}
		catch(Exception e)
		{
			//			e.printStackTrace();
			return "FAIL";
		}
	}

	@Override
	public boolean remember(CredentialsBean cBean)
	{
		try
		{
			String cmd = "INSERT INTO ITS_TBL_Remember VALUES(?,?)";
			pst = con.prepareStatement(cmd);
			pst.setString(1, cBean.getUserID());
			pst.setString(2, cBean.getPassword());
			int a = pst.executeUpdate();
			if(a>0)
				return true;
			else return false;
		}
		catch(Exception e)
		{
			//			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getPassword(String userID)
	{
		try
		{
			String cmd = "SELECT password FROM ITS_TBL_Remember WHERE userID = ?";
			pst = con.prepareStatement(cmd);
			pst.setString(1, userID);
			rs = pst.executeQuery();
			if(rs.next())
			{
				return rs.getString(1);
			}
			else return null;
		}
		catch(Exception e)
		{
			//			e.printStackTrace();
			return null;
		}
	}
}
