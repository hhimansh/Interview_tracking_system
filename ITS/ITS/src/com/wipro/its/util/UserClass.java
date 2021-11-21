package com.wipro.its.util;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.dao.UserDAOClass;

public class UserClass implements User
{
	UserDAOClass uDao;
	int value;
	@Override
	public String login(CredentialsBean credentialsBean) 
	{
		if(credentialsBean.getUserID()==null || credentialsBean.getUserID().isEmpty() || credentialsBean.getPassword()==null ||credentialsBean.getPassword().isEmpty())
		{
			return null;
		}
		uDao= new UserDAOClass();
		value=uDao.checkLogin(credentialsBean);
		if(value==credentialsBean.getLoginStatus())
		{
			return "Logged in";
		}
		return null;
	}

	@Override
	public boolean logout(String userId)
	{
		if(userId==null ||userId.isEmpty())
		{
			return false;
		}
		uDao= new UserDAOClass();
		boolean b=uDao.checkLogout(userId);
		return b;
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean,String newPassword)
	{

		if(credentialsBean.getPassword()==null || credentialsBean.getPassword().isEmpty())
		{
			return null;
		}
		if(newPassword.isEmpty() ||newPassword==null)
		{
			return null;
		}

		uDao=new UserDAOClass();
		String value= uDao.doChangePassword(credentialsBean, newPassword);
		return value;
	}

	@Override
	public String register(CredentialsBean credentialsBean) {
		if(credentialsBean==null)
			return "FAIL";
		if(credentialsBean.getUserID()==null || credentialsBean.getUserID().isEmpty())
			return "FAIL";
		if(credentialsBean.getPassword()==null || credentialsBean.getPassword().isEmpty())
			return "FAIL";
		uDao = new UserDAOClass();
		String value = uDao.register(credentialsBean);
		return value;
	}
}