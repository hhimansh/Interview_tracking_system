package com.wipro.its.ui;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.listener.admin_edit_info_lis;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class admin_edit_info extends JFrame{
	
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9;
	public JTextField t2,t3,t4,t5,t6,t7,t8;
	public JButton b1;
	JPanel pan;
	public JComboBox<String> cb, t9;
	admin_edit_info_lis editlis = new admin_edit_info_lis(this);

	public admin_edit_info()
	{
	
		setSize(450,400);
		setLocation(230,240);
		setTitle("Edit Candidate Information");

		pan=new JPanel();

		pan.setLayout(null);
		pan.setBounds(0,0,350,300);
		pan.setBackground(Color.pink);
		l0=new JLabel("Edit Candidate Information");
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
		
		l2=new JLabel("Primary Skills");
		t2=new JTextField(15);
		
		l3=new JLabel("Secondary Skills");
		t3=new JTextField(15);
		
		l4=new JLabel("Experience");
		t4=new JTextField(15);
		
		l5=new JLabel("Qualification");
		t5=new JTextField(15);
	
		l6=new JLabel("Designation");
		t6=new JTextField(15);
		
		l7=new JLabel("Notice Period");
		t7=new JTextField(15);
		
		l8=new JLabel("Location");
		t8=new JTextField(15);
		
		l9=new JLabel("Share Details");
		t9=new JComboBox<String>();
		t9.addItem("No sharing");
		t9.addItem("Share with tech");
		t9.addItem("Share with HR");
		t9.addItem("Share with both");
		
		b1=new JButton("Edit");
		    
		    
		l0.setBounds(80,5,300,50);
		
		l1.setBounds(40,60,130,20);
		cb.setBounds(180,60,130,20);
		
		l2.setBounds(40,90,130,20);
		t2.setBounds(180,90,130,20);
		 
		l3.setBounds(40,120,130,20);
		t3.setBounds(180,120,130,20);

		l4.setBounds(40,150,130,20);
		t4.setBounds(180,150,130,20);
		
		l5.setBounds(40,180,130,20);
		t5.setBounds(180,180,130,20);
		 
		l6.setBounds(40,210,130,20);
		t6.setBounds(180,210,130,20);

		l7.setBounds(40,240,130,20);
		t7.setBounds(180,240,130,20);
		
		l8.setBounds(40,270,130,20);
		t8.setBounds(180,270,130,20);

		l9.setBounds(40,300,130,20);
		t9.setBounds(180,300,130,20);
		
		b1.setBounds(100,340,130,20);
		
		pan.add(l0);
		pan.add(l1);
		pan.add(cb);
		pan.add(l2);
		pan.add(t2);
		pan.add(l3);
		pan.add(t3);
		pan.add(l4);
		pan.add(t4);
		pan.add(l5);
		pan.add(t5);
		pan.add(l6);
		pan.add(t6);
		pan.add(l7);
		pan.add(t7);
		pan.add(l8);
		pan.add(t8);
		pan.add(l9);
		pan.add(t9);
		pan.add(b1);
		
		add(pan);
		
		b1.addActionListener(editlis);
		cb.addActionListener(editlis);
		
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new admin_edit_info();
	}
}