package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.dao.UserDAOClass;
import com.wipro.its.ui.ForgetPassword;
import com.wipro.its.ui.HRPanel;
import com.wipro.its.ui.LoginPage;
import com.wipro.its.ui.Register_Here;
import com.wipro.its.ui.TechPanel;
import com.wipro.its.ui.admin;
import com.wipro.its.ui.contact_us;
import com.wipro.its.util.AuthenticationClass;

public class login_lis implements ActionListener, MouseListener, FocusListener {

	LoginPage lp;
	AuthenticationClass aUtil;
	UserDAOClass udao;
	admin ad;
	TechPanel tp;
	HRPanel hr;

	public login_lis(LoginPage lp)
	{
		this.lp=lp;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		CredentialsBean cBean= new CredentialsBean();

		if(e.getSource()==lp.button)
		{
			aUtil= new AuthenticationClass();
			cBean.setUserID(lp.text1.getText());
			cBean.setPassword(lp.text2.getText());
			
			boolean a= aUtil.authenticate(cBean);

			if(a==true)
			{
				if(lp.box.isSelected())
				{
					udao = new UserDAOClass();
					udao.remember(cBean);
				}
				
				String value=aUtil.authorize(cBean.getUserID());
				if(value.equals("A"))
				{
					udao = new UserDAOClass();
					int status = udao.checkLogin(cBean);
					if(status==1)
					{
						JOptionPane.showMessageDialog(lp, "User Already Logged In");
					}
					else
					{
						aUtil.changeLoginStatus(cBean, 1);
						ad=new admin(cBean.getUserID());
						ad.setVisible(true);
						lp.setVisible(false);
					}
				}
				if(value.equals("T"))
				{
					udao = new UserDAOClass();
					int status = udao.checkLogin(cBean);
					if(status==1)
					{
						JOptionPane.showMessageDialog(lp, "User Already Logged In");
					}
					else
					{
						aUtil.changeLoginStatus(cBean,1);
						tp=new TechPanel(cBean.getUserID());
						tp.setVisible(true);
						lp.setVisible(false);
					}
				}
				if(value.equals("H"))
				{
					udao = new UserDAOClass();
					int status = udao.checkLogin(cBean);
					if(status==1)
					{
						JOptionPane.showMessageDialog(lp, "User Already Logged In");
					}
					else
					{
						aUtil.changeLoginStatus(cBean,1);
						hr=new HRPanel(cBean.getUserID());
						hr.setVisible(true);
						lp.setVisible(false);
					}
				}
			}


			else 
			{
				if(cBean.getUserID()==null || cBean.getUserID().isEmpty())
				{
					JOptionPane.showMessageDialog(lp,"Please Enter UserID");
				}
				
				else if(cBean.getPassword()==null || cBean.getPassword().isEmpty())
				{
					JOptionPane.showMessageDialog(lp,"Please Enter Password");
				}
				else
				{
					JOptionPane.showMessageDialog(lp,"Please Enter the Correct Id And Password");
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lp.label3)
		{
			new Register_Here();
			lp.dispose();
		}
		
		if(e.getSource()==lp.lab1)
		{
			new ForgetPassword();
			lp.dispose();
		}
		
		if(e.getSource()==lp.l3)
		{
			new contact_us();
		}
		
		if(e.getSource()==lp.l2){
			JOptionPane.showMessageDialog(lp, "This is Interview Tracking System");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==lp.text1)
		{
			String userID = lp.text1.getText();
			udao = new UserDAOClass();
			String password = udao.getPassword(userID);
			if(password!=null)
			{
				lp.text2.setText(password);
			}
		}
	}
}