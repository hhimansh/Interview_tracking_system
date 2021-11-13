package com.wipro.its.dao;

import com.wipro.its.bean.CredentialsBean;

public interface UserDao 
{
	int checkLogin(CredentialsBean credentialsBean);
	boolean checkLogout(String userId);
	String doChangePassword(CredentialsBean credentialsBean, String newPassword);
	String register(CredentialsBean credentialsBean);
	boolean remember(CredentialsBean cBean);
	String getPassword(String userID);
}