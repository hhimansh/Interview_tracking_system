package com.wipro.its.util;

import com.wipro.its.bean.CredentialsBean;

public interface User
{
	String login(CredentialsBean credentialsBean);
	boolean logout(String userId);
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	String register(CredentialsBean credentialsBean);
}
