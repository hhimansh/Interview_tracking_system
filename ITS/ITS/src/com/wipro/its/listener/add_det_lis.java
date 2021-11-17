package com.wipro.its.listener;

import java.awt.event.*;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.bean.ProfileBean;
import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.add_details;

public class add_det_lis implements ActionListener {

	add_details add;
	String email="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	String digits = "^[0-9]*$";
	String alphabets = "^[a-zA-Z]+$";
	public add_det_lis(add_details add)
	{
		this.add=add;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==add.b1)
		{
			if(add.t1.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter first name");
			else if(!(add.t1.getText().matches(alphabets)))
				JOptionPane.showMessageDialog(add, "Only Alphabets");
			else if(add.t2.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the last name");
			else if(!(add.t2.getText().matches(alphabets)))
				JOptionPane.showMessageDialog(add, "Only Alphabets");
			else if(add.t5.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter Street");
			else if(!(add.t5.getText().matches(alphabets)))
				JOptionPane.showMessageDialog(add, "Only Alphabets");
			else if(add.t6.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the city");
			else if(!(add.t6.getText().matches(alphabets)))
				JOptionPane.showMessageDialog(add, "Only Alphabets");
			else if(add.t7.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the state");
			else if(!(add.t7.getText().matches(alphabets)))
				JOptionPane.showMessageDialog(add, "Only Alphabets");
			else if(add.t8.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the pincode");
			else if(!(add.t8.getText().matches(digits)))
				JOptionPane.showMessageDialog(add, "Invalid Pin Code");
			else if(add.t8.getText().length()!=6)
				JOptionPane.showMessageDialog(add, "Pin code is not valid");
			else if(add.t9.getText().length()!=10)
				JOptionPane.showMessageDialog(add, "Mobile number is not valid");
			else if(!(add.t9.getText().matches(digits)))
				JOptionPane.showMessageDialog(add, "Mobile number is not valid");
			else if(add.t10.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the email ID");
			else if(!(add.t10.getText().matches(email)))
				JOptionPane.showMessageDialog(add, "Please enter valid email ID");
			else if(add.t13.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the Experience");
			else if(add.t15.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the Designation");
			else if(!(add.t15.getText().matches(alphabets)))
				JOptionPane.showMessageDialog(add, "Only Alphabets");
			else if(add.t16.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the Notice Period");
			else if(add.t17.getText().length()==0)
				JOptionPane.showMessageDialog(add, "Please enter the Location");
			else if(!(add.t17.getText().matches(alphabets)))
				JOptionPane.showMessageDialog(add, "Only Alphabets");
			else
			{
				AdministratorClass ad = new AdministratorClass();
				CandidateBean candbean = new CandidateBean();
				ProfileBean pb = new ProfileBean();
				pb.setFirstName(add.t1.getText());
				pb.setLastName(add.t2.getText());
				pb.setGender(add.cb.getSelectedItem().toString());
				pb.setStreet(add.t5.getText());
				pb.setCity(add.t6.getText());
				pb.setState(add.t7.getText());
				pb.setPincode(add.t8.getText());
				pb.setMobileNo(add.t9.getText());
				pb.setEmailID(add.t10.getText());
				pb.setLocation(add.t17.getText());

				try
				{
					String dob = add.d.getSelectedItem().toString() +"/"+ add.m.getSelectedItem().toString() +"/"+ add.yr.getSelectedItem().toString();
					SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date date = sd.parse(dob);
					pb.setDateOfBirth(date);
				}
				catch(Exception e1)
				{
//					e1.printStackTrace();
				}

				candbean.setPrimarySkills(add.ta1.getSelectedItem().toString());
				candbean.setSecondarySkills(add.ta2.getSelectedItem().toString());
				try
				{
					candbean.setExperience(Double.parseDouble(add.t13.getText()));
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(add, "Please enter valid experience value");
				}
				candbean.setQualification(add.t14.getSelectedItem().toString());
				candbean.setDesignation(add.t15.getText());
				try
				{
					candbean.setNoticePeriod(Integer.parseInt(add.t16.getText()));
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(add, "Please enter valid experience value");
				}
				candbean.setLocation(add.t17.getText());

				String result = ad.addCandidate(pb,candbean);
				
				if(result.equals("SUCCESS"))
				{
					JOptionPane.showMessageDialog(add,"User added successfully");
					add.dispose();
				}
			}
		}
	  
		if(e.getSource()==add.b2)
		{
			add.t1.setText(null);
			add.t2.setText(null);
			add.t5.setText(null);
			add.t6.setText(null);
			add.t7.setText(null);
			add.t8.setText(null);
			add.t9.setText(null);
			add.t10.setText(null);
			add.ta1.setSelectedIndex(0);
			add.ta2.setSelectedIndex(0);
			add.t13.setText(null);
			add.t14.setSelectedIndex(0);
			add.t15.setText(null);
			add.t16.setText(null);
			add.t17.setText(null);
			add.lastlab.setText("");
		}
   }
}
