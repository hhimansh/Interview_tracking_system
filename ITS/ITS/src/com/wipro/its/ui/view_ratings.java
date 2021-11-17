package com.wipro.its.ui;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.listener.view_ratings_lis;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class view_ratings extends JFrame{

	public JLabel l0,l1,l2,l3,l4,l5,l6,l7;
	public JComboBox<String> t1;
	JPanel pan;
	public JButton b1, b2;
	
	view_ratings_lis vl=new view_ratings_lis(this);
	
	  PreparedStatement pst;
		ResultSet rs;
		Connection con = DBUtil.getDBConnection("");
	
	public view_ratings()
	{
	
		setSize(450,400);
		setLocation(230,240);
		 setTitle("View Ratings Page"); 
		
		pan=new JPanel();
		
		pan.setLayout(null);
		pan.setBounds(0, 0,350,300);
		pan.setBackground(Color.PINK);
		
		l0=new JLabel("View Ratings");
		 l0.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		l1=new JLabel("Interview ID");
		//t1=new JTextField(6);
		 
        t1 = new JComboBox<String>();
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
		
		l2=new JLabel("Tech Ratings");
		l3=new JLabel("**********");
		
		l4=new JLabel("HR Ratings");
		l5=new JLabel("**********");
		
		l6=new JLabel("Overall Ratings");
		l7=new JLabel("**********");
		
		b1=new JButton("View");
		b2=new JButton("Cancel");
				
		l0.setBounds(120,5,200,50);
		
		l1.setBounds(40,80,130,20);
		t1.setBounds(180,80,130,20);
		
		l2.setBounds(40,120,130,20);
		l3.setBounds(180,120,130,20);
		
		l4.setBounds(40,160,130,20);
		l5.setBounds(180,160,130,20);
		
		l6.setBounds(40,200,130,20);
		l7.setBounds(180,200,130,20);
		
		b1.setBounds(100,250,80,20);
		b2.setBounds(200,250,80,20);
		
		pan.add(l0);
		pan.add(l1);
		pan.add(t1);
		pan.add(l2);
		pan.add(l3);
		pan.add(l4);
		pan.add(l5);
		pan.add(l6);
		pan.add(l7);

		pan.add(b1);
		pan.add(b2);
		
		add(pan);
		
		b1.addActionListener(vl);
		b2.addActionListener(vl);
		setVisible(true);
		setResizable(false);
		
	}
}
