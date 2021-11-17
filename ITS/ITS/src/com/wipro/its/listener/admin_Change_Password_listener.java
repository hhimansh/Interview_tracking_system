package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.ui.LoginPage;
import com.wipro.its.ui.admin;
import com.wipro.its.ui.change_pass;
import com.wipro.its.util.DBUtil;
import com.wipro.its.util.UserClass;

public class admin_Change_Password_listener implements ActionListener
{
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	UserClass uc = new UserClass();
	change_pass cp;
	admin ad;
	CredentialsBean cBean;
	LoginPage lp;
	public String password="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	public admin_Change_Password_listener(change_pass cp)
	{
		this.cp=cp;
	}


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) 
	{

		if(e.getSource()==cp.b1)
		{
			String fetchedPass = "";
			try
			{
				String cmd = "SELECT password FROM ITS_TBL_User_Credentials WHERE UserId = ?";
				pst = con.prepareStatement(cmd);
				pst.setString(1, admin.userId);
				rs = pst.executeQuery();
				rs.next();
				fetchedPass = rs.getString(1);
			}
			catch(Exception e1)
			{
				
			}
			cBean= new CredentialsBean();

			cBean.setUserID(admin.userId);

			cBean.setPassword(cp.t1.getText());
			String enter_new_psd=cp.t2.getText();

			String re_enter_psd=cp.t3.getText();
			
			if(!(cBean.getPassword().equals(fetchedPass)))
			{
				JOptionPane.showMessageDialog(cp, "The current password is not valid");
			}
			else if(cBean.getPassword()==null ||cBean.getPassword().isEmpty())
			{
				JOptionPane.showMessageDialog(cp, "Please Enter Password");
			}
			else if(enter_new_psd==null||enter_new_psd.isEmpty() )
			{
				JOptionPane.showMessageDialog(cp, "Please Enter The New Password");
			}
			
			else if(!(enter_new_psd.equals(re_enter_psd)))
			{
				JOptionPane.showMessageDialog(cp,"New Password and Confirmed Password Not Matched");
			}

			else if(enter_new_psd.equals(re_enter_psd))
			{
				 if(!(enter_new_psd.matches(password)))
				 {
					 cp.last1.setText("It must contain atleast one digit,");
					 cp.last2.setText("one lowercase character,");
					 cp.last3.setText("one uppercase character,");
					 cp.last4.setText("one special symbol and");
					 cp.last5.setText("length between 6 and 20");
					JOptionPane.showMessageDialog(cp, "Password Not too strong");
				 }
				 else
				 {
					 uc.changePassword(cBean, enter_new_psd);
					 JOptionPane.showMessageDialog(cp,"Changed Successfully");
					 cp.dispose();
				 }
			}
		}
		
		if(e.getSource()==cp.b2)
		{
			cp.dispose();
		}
	}
}