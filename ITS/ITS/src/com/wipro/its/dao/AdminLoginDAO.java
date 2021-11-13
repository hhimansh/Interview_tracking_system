package com.wipro.its.dao;

import com.wipro.its.bean.CredentialsBean;

public interface AdminLoginDAO 
{
	public boolean checkAuthenticate(CredentialsBean credentialsBean);
	public String  checkAuthorize(String userId);
	public boolean changeStatus(CredentialsBean credentialsBean,int loginStatus);
	String forgotPassword(CredentialsBean cb);
}