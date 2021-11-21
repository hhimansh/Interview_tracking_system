package com.wipro.its.util;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.dao.AdminstratorLoginDAO;

public class AuthenticationClass implements Authentication
{
	CredentialsBean cBean;
	AuthenticationClass aClass;
	AdminstratorLoginDAO aloginDao;
	boolean result;
	String value;

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) 
	{
		if((credentialsBean.getUserID()==null)||(credentialsBean.getUserID().isEmpty())||(credentialsBean.getPassword()==null)|| (credentialsBean.getPassword().isEmpty()))
		{
			return false;
		}
		else
		{
			aloginDao= new AdminstratorLoginDAO();
			result=aloginDao.checkAuthenticate(credentialsBean);
			return result;
		}
	}



	@Override
	public String authorize(String userID) 
	{
		cBean= new CredentialsBean();

		aloginDao= new AdminstratorLoginDAO();
		value=aloginDao.checkAuthorize(userID);
		return value;

	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean,int loginStatus) 
	{
		aloginDao= new AdminstratorLoginDAO();
		result=aloginDao.changeStatus(credentialsBean, loginStatus);
		if(result==true)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public String forgotPassword(CredentialsBean cb)
	{
		if(cb==null)
			return null;
		if(cb.getUserID()==null || cb.getUserID().isEmpty())
			return null;
		aloginDao = new AdminstratorLoginDAO();
		String pass = aloginDao.forgotPassword(cb);
		return pass;
	}
}