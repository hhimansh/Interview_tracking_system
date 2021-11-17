package com.wipro.its.ui;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.listener.HRSubmitRatingListener;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class HRSubmitRating extends JFrame
{
	public JLabel label,l1,l2,l3,l4;
	public JComboBox<String> t1,t2,t3;
	public JButton b1;
	public JButton b2;
	HRSubmitRatingListener rate=new HRSubmitRatingListener(this);
	
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");

	public HRSubmitRating()
	{
		setTitle("Submit Ratings");
		setBounds(365,265,340,290);
		setLayout(null);
		getContentPane().setBackground(Color.PINK);
		
		label=new JLabel("Submit Rating");
		label.setBounds(110,10,300,40);
		label.setFont(new Font("Serif", Font.PLAIN,20));

		l1=new JLabel("InterviewId");
		l1.setBounds(30,80,100,20);
		
		
		
		l2=new JLabel("empHRId");
		l2.setBounds(30,110,100,20);
		
		l3=new JLabel("Rating");
		l3.setBounds(30,140,100,20);
		t3=new JComboBox<String>();
		t3.setBounds(150,140,140,20);
		for(int i=1; i<5; i++)
		{
			for(int j=0; j<10; j++)
			{
				t3.addItem(i+"."+j);
			}
		}
		t3.addItem("5.0");
		
		b1=new JButton("Submit");
		b1.setBounds(80,190,80,20);
		b2=new JButton("Reset");
		b2.setBounds(180,190,80,20);
	
		l4=new JLabel();
		l4.setBounds(100,210,200,20);
		
		
		
		 t1 = new JComboBox<String>();
		 t1.setBounds(150,80,140,20);
			try
			{
				pst = con.prepareStatement("SELECT INTERVIEWID FROM ITS_TBL_INTERVIEW_SCHEDULE");
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
			
			
			
			t2=new JComboBox<String>();
			t2.setBounds(150,110,140,20);
			
			try
			{
				pst = con.prepareStatement("SELECT DISTINCT empHRID FROM ITS_TBL_INTERVIEW_SCHEDULE");
				rs = pst.executeQuery();
				while(rs.next())
				{
					t2.addItem(rs.getString(1));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		
		add(label);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b1);
		add(b2);
		add(l4);
		
		b1.addActionListener(rate);
		b2.addActionListener(rate);
		//t3.addFocusListener(rate);
		setVisible(true);
		setResizable(false);
		

	}
}

