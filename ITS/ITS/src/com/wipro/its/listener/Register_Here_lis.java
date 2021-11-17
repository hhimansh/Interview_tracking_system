package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CredentialsBean;
import com.wipro.its.ui.Register_Here;
import com.wipro.its.util.UserClass;

public class Register_Here_lis implements ActionListener {

	Register_Here reg;

	public Register_Here_lis(Register_Here reg)
	{
		this.reg = reg;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==reg.reset)
		{
			reg.t1.setText(null);
			reg.password.setText(null);
			reg.confirmPassword.setText(null);
			reg.userType.setSelectedIndex(0);
			reg.last1.setText(null);
			reg.last2.setText(null);
			reg.last3.setText(null);
		}

		if(e.getSource()==reg.submit)
		{
			CredentialsBean cb = new CredentialsBean();
			cb.setUserID(reg.t1.getText());
			cb.setPassword(reg.password.getText());
			cb.setUserType(""+reg.userType.getSelectedItem().toString().charAt(0));
			cb.setLoginStatus(0);

			if(!(reg.password.getText().equals(reg.confirmPassword.getText())))
			{
				JOptionPane.showMessageDialog(reg, "Passwords do not match");
			}
			else
			{
				UserClass uc = new UserClass();
				String result = uc.register(cb);

				if(result.equalsIgnoreCase("EXIST"))
				{
					JOptionPane.showMessageDialog(reg, "UserID already exists");
				}
				
				else if(result.equals("WEAK PASS"))
				{
					reg.last1.setText("It must contain atleast one digit,one lowercase character");
					reg.last2.setText("one uppercase character,one special symbol and");
					reg.last3.setText("length must be between 6 and 20.");
					JOptionPane.showMessageDialog(reg, "Password Not too strong");
				}
				
				else if(result.equals("SUCCESS"))
				{
					JOptionPane.showMessageDialog(reg, "User registered successfully");
					reg.dispose();
				}

				else if(result.equals("FAIL"))
				{
					JOptionPane.showMessageDialog(reg, "User could not be registered");
				}
			}
		}
	}
}