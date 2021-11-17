package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.ui.LoginPage;
import com.wipro.its.ui.HRPanel;
import com.wipro.its.ui.admin;
import com.wipro.its.ui.change_pass2;
import com.wipro.its.util.DBUtil;
import com.wipro.its.util.UserClass;

public class hr_Change_Password_Listener implements ActionListener
{
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");

	UserClass uc = new UserClass();
	change_pass2 cp;
	admin ad;
	CredentialsBean cBean;
	LoginPage lp;
	public String password="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

	public hr_Change_Password_Listener(change_pass2 cp) 
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
				pst.setString(1, HRPanel.userId2);
				rs = pst.executeQuery();
				rs.next();
				fetchedPass = rs.getString(1);
			}
			catch(Exception e1)
			{
//				e1.printStackTrace();
			}
			cBean= new CredentialsBean();

			cBean.setUserID(HRPanel.userId2);

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
					cp.last1.setText("Atleast one digit, one lowercase,");
					cp.last2.setText("one uppercase, one special character and");
					cp.last3.setText("length between 6 and 20 required");
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
	}
}