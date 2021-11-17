package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.ui.ForgetPassword;
import com.wipro.its.util.AuthenticationClass;

public class Forget_password_lis implements ActionListener
{
	ForgetPassword f;

	public Forget_password_lis(ForgetPassword f) 
	{
		this.f=f;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==f.submit)
		{
			AuthenticationClass ac = new AuthenticationClass();
			CredentialsBean cb = new CredentialsBean();
			cb.setUserID(f.t1.getText());
			cb.setUserType(""+f.userType.getSelectedItem().toString().charAt(0));
			String pass = ac.forgotPassword(cb);
			if(pass!=null)
			{
				f.label3.setVisible(true);
				f.label4.setText(pass);
			}
			else JOptionPane.showMessageDialog(f, "Wrong details entered");
		}
		
		if(e.getSource()==f.cancel)
		{
			f.dispose();
		}
	}
}