package com.wipro.its.ui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.listener.viewResults_HR_lis;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class viewResults_HR extends JFrame{

	public JLabel label1,label2,label3,label4,label5,label6;
	public JTextField t;
	public JButton b;
	public JComboBox<String> cb;
	
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	

	viewResults_HR_lis vl=new viewResults_HR_lis(this);
	
	public viewResults_HR()
	{
		setTitle("View Results");
		setBounds(365,265,340,290);
		setLayout(null);
		getContentPane().setBackground(Color.PINK);

		label1=new JLabel("View Results");
		label1.setBounds(110,10,300,40);
		label1.setFont(new Font("Serif", Font.PLAIN,20));

		label2=new JLabel("InterviewID");
		label2.setBounds(30,70,100,20);
		
       
		cb=new JComboBox<String>();
		try
		{
			
			pst = con.prepareStatement("SELECT INTERVIEWID FROM ITS_TBL_INTERVIEW_SCHEDULE");
			rs = pst.executeQuery();
			while(rs.next())
			{
				cb.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		cb.setBounds(150,70,130,20);
		
		label3=new JLabel("CandidateID");
		label3.setBounds(30,100,100,20);
	
		label4=new JLabel("---------------");				
		label4.setBounds(150,100,130,20);
		
		label5=new JLabel("Result");
		label5.setBounds(30,130,130,20);
		
		label6=new JLabel("----------------");
     	label6.setBounds(150,130,130,20);
		
		b=new JButton("Result");
		b.setBounds(110,200,80,20);

		add(label1);
		add(label2);
		add(cb);
		add(label3);
		add(label4);
		add(label5);
		add(label6);
		add(b);

		b.addActionListener(vl);
		setVisible(true);
		setResizable(false);

	}

}
