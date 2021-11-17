package com.wipro.its.ui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.dao.ScheduleDAO;
import com.wipro.its.listener.admin_delete_lis;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class admin_delete_info extends JFrame{

	JPanel pan;
	public JLabel l0,l1;
	public JComboBox<String> cb;
	public JButton b;
	ScheduleDAO sdao;
	
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	admin_delete_lis adl=new admin_delete_lis(this);
	
	public admin_delete_info()
	{
		setSize(450,400);
		setLocation(230,240);
		setTitle("Delete Candidate");

		pan=new JPanel();

		pan.setLayout(null);
		pan.setBounds(0,0,350,300);
		pan.setBackground(Color.pink);
		l0=new JLabel("Delete Candidate Information");
		l0.setFont(new Font("Times New Roman",Font.BOLD,20));

		l1=new JLabel("CandidateID");
		cb=new JComboBox<String>();
	   
		try
		{
			pst = con.prepareStatement("SELECT candidateID FROM ITS_TBL_Candidate");
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
		
	    b=new JButton("Delete");
	    
	    l0.setBounds(80,5,300,50);
		l1.setBounds(40,80,130,20);
		cb.setBounds(180,80,130,20);
		b.setBounds(100,150,80,20);

		pan.add(l0);
		pan.add(l1);
		pan.add(cb);
		pan.add(b);
		
		add(pan);
		
		b.addActionListener(adl);
		
		setVisible(true);
		setResizable(false);
	}
	
	@SuppressWarnings("unused")
	public static void main(String []args)
	{
		admin_delete_info f=new admin_delete_info();
	}
}
