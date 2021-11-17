package com.wipro.its.ui;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.listener.share_info_listener;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class share_info extends JFrame
{
	JLabel l0,l1;
	//public JTextField t1;
	public JComboBox<String> t2;
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	JPanel pan;
	public JButton b1,b2,b3,b4;
	share_info_listener li=new share_info_listener(this);
	
	public share_info()
	{
	
		setSize(450,400);
		setLocation(230,240);
		setTitle("Share Information Page"); 
		
		pan=new JPanel();
	
		pan.setLayout(null);
		pan.setBounds(0, 0,350,300);
		pan.setBackground(Color.PINK);
		
		l0=new JLabel("Share Details");
		 l0.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		l1=new JLabel("Candidate ID");
		b1=new JButton("Share with Tech");
		b2=new JButton("Share with HR");
		b3=new JButton("Share with Both");
		b4=new JButton("Share with none");
		
		l0.setBounds(120,5,200,50);
		
		l1.setBounds(40,80,130,20);
		
		
		b1.setBounds(40,140,130,20);
		b2.setBounds(200,140,130,20);
		b3.setBounds(40,180,130,20);
		b4.setBounds(200,180,130,20);
		
		t2=new JComboBox<String>();
		t2.setBounds(180,80,130,20);
		
		try
		{
			pst = con.prepareStatement("SELECT candidateID FROM ITS_TBL_Candidate");
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
		
		pan.add(l0);
		pan.add(l1);
		pan.add(t2);
		pan.add(b1);
		pan.add(b2);
		pan.add(b3);
		pan.add(b4);
		
		add(pan);
		
		b1.addActionListener(li);
		b2.addActionListener(li);
		b3.addActionListener(li);
		b4.addActionListener(li);
		
		
		setVisible(true);
		setResizable(false);
	}
}
