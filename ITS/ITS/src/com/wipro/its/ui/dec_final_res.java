package com.wipro.its.ui;

import javax.swing.*;

import com.wipro.its.listener.dec_final_res_lis;
import com.wipro.its.util.DBUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class dec_final_res extends JFrame {
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	JLabel l0,l1,l2, shareLabel, overallRating;
	public JComboBox<String> t1, overallCombo;
	JPanel pan;
	public JButton b1, b2;
	public JComboBox<String> shareChoice;
	dec_final_res_lis resl = new dec_final_res_lis(this);

	public dec_final_res()
	{
		setTitle("Declare Results");
		setSize(450,400);
		setLocation(230,240);

		pan=new JPanel();
		pan.setSize(350,300);
		pan.setLayout(null);
		pan.setBounds(0, 0,350,80);
		pan.setBackground(Color.PINK);

		overallRating = new JLabel("Minimum overall rating");
		
		overallCombo = new JComboBox<String>();
		overallCombo = new JComboBox<String>();
		for(int i=1; i<10; i++)
		{
			for(int j=0; j<10; j++)
			{
				overallCombo.addItem(i+"."+j);
			}
		}
		overallCombo.addItem("10.0");
		
		l0=new JLabel("Declare Final Results");
		l0.setFont(new Font("Times New Roman",Font.BOLD,20));

		l1=new JLabel("Interview ID");
		t1=new JComboBox<String>();
		
		try
		{
			pst = con.prepareStatement("SELECT interviewID FROM ITS_TBL_Interview_Schedule");
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

		shareLabel = new JLabel("Do you want to share result?");

		shareChoice = new JComboBox<String>();
		shareChoice.addItem("Yes");
		shareChoice.addItem("No");

		b1=new JButton("Declare");
		b2=new JButton("Cancel");
		
		l2=new JLabel();
		l2.setVisible(false);

		l0.setBounds(120,5,200,50);
		
		overallRating.setBounds(40,80,130,20);
		overallCombo.setBounds(220,80,130,20);
		
		l1.setBounds(40,110,130,20);
		t1.setBounds(220,110,130,20);

		shareLabel.setBounds(40, 140, 200, 20);
		shareChoice.setBounds(220, 140, 130, 20);

		b1.setBounds(120,180,80,20);
		b2.setBounds(220,180,80,20);

		pan.add(l0);
		pan.add(overallRating);
		pan.add(overallCombo);
		pan.add(l1);
		pan.add(t1);
		pan.add(shareLabel);
		pan.add(shareChoice);
		pan.add(b1);
		pan.add(b2);
		pan.add(l2);

		add(pan);

		setVisible(true);
		setResizable(false);

		b1.addActionListener(resl);
		b2.addActionListener(resl);
	}
}