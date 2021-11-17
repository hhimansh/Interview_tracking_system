package com.wipro.its.ui;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.listener.ViewInfoListener;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class ViewInfo extends JFrame
{
	public JLabel candidateID, primarySkills, secondarySkills, experience, qualification, designation, noticePeriod, location;
	public JLabel l1,l2,l3,l4,l5,l6,l7;
	public JComboBox<String> t1;
	public JButton button;
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	ViewInfoListener vi=new ViewInfoListener(this);

	public ViewInfo()
	{
		setTitle("View Candidates Info");
		setLayout(null);
		setBounds(365,265,340,290);
		getContentPane().setBackground(Color.PINK);
		candidateID = new JLabel("CandidateID");
		
		l1=new JLabel();
		l1.setVisible(false);
		
		primarySkills = new JLabel("Primary Skills:");
		primarySkills.setVisible(false);
		
		l2=new JLabel();
		l2.setVisible(false);
		
		secondarySkills = new JLabel("Secondary Skills:");
		secondarySkills.setVisible(false);
		
		l3=new JLabel();
		l3.setVisible(false);
		
		experience = new JLabel("Experience:");
		experience.setVisible(false);
		
		l4=new JLabel();
		l4.setVisible(false);
		
		qualification = new JLabel("Qualification:");
		qualification.setVisible(false);
		
		l5=new JLabel();
		l5.setVisible(false);
		
		designation = new JLabel("Designation:");
		designation.setVisible(false);
		
		l6=new JLabel();
		l6.setVisible(false);
		
		noticePeriod = new JLabel("Notice Period:");
		noticePeriod.setVisible(false);
		
		l7=new JLabel();
		l7.setVisible(false);
		
		location = new JLabel("Location:");
		location.setVisible(false);

		button=new JButton("View");

		t1 = new JComboBox<String>();
		candidateID.setBounds(40, 20, 100, 20);
		t1.setBounds(180,20,100,20);
		try
		{
			pst = con.prepareStatement("SELECT CANDIDATEID FROM ITS_TBL_CANDIDATE");
			rs = pst.executeQuery();
			while(rs.next())
			{
				t1.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		button.setBounds(120, 50, 80, 20);
		primarySkills.setBounds(40, 80, 100, 20);
		l1.setBounds(180, 80, 100, 20);
		secondarySkills.setBounds(40, 100, 100, 20);
		l2.setBounds(180, 100, 100, 20);
		experience.setBounds(40, 120, 100, 20);
		l3.setBounds(180, 120, 100, 20);
		qualification.setBounds(40, 140, 100, 20);
		l4.setBounds(180, 140, 100, 20);
		designation.setBounds(40, 160, 100, 20);
		l5.setBounds(180, 160, 100, 20);
		noticePeriod.setBounds(40, 180, 100, 20);
		l6.setBounds(180, 180, 100, 20);
		location.setBounds(40, 200, 100, 20);
		l7.setBounds(180, 200, 100, 20);

		button.addActionListener(vi);
		add(t1);
		add(candidateID);
		add(primarySkills);
		add(l1);
		add(secondarySkills);
		add(l2);
		add(experience);
		add(l3);
		add(qualification);
		add(l4);
		add(designation);
		add(l5);
		add(noticePeriod);
		add(l6);
		add(location);
		add(l7);
		add(button);
		setVisible(true);
	}
}