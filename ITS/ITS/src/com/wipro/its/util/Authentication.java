package com.wipro.its.util;

import com.wipro.its.bean.CredentialsBean;

public interface Authentication 
{
	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userID);
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
	String forgotPassword(CredentialsBean cb);
}