package com.wipro.its.ui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import com.wipro.its.listener.admin_2_lis;

@SuppressWarnings("serial")
public class admin_2 extends JFrame{

	JPanel pan,pan1;
	String str1,str2,str3;
	public JLabel l0,l1,l2,l3,l4;
	ImageIcon img;
	
	admin_2_lis al=new admin_2_lis(this);
	
	public admin_2()
	{
		setSize(450,360);
		setLocation(230,240);
		setTitle("add/modify/delete Candidate Details");
		
		
		pan=new JPanel();
		pan.setLayout(null);
		pan.setBounds(0,0,450,360);
		pan.setBackground(Color.pink);
		l0=new JLabel("Manage Candidate Information");
		l0.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		str1="<html><body><p><a href>To Add Candidate Information-Click here</a></body></html>";
	    str2="<html><body><p><a href>To Modify Candidate Information-Click here</a></body></html>";
	    str3="<html><body><p><a href>To Delete Candidate Information-Click here</a></body></html>";

	    img=new ImageIcon("src\\images\\interview.jpg");
	    
	   l1=new JLabel(str1);
	   l2=new JLabel(str2);
	   l3=new JLabel(str3);
	   l4=new JLabel();
        l4.setIcon(img);	   
	   
	   l0.setBounds(80,5,300,50);

	l1.setBounds(40,60,200,50);
	l2.setBounds(40,120,200,50);
	l3.setBounds(40,200,200,50);
	l4.setBounds(180,60,250,200);
	//l1.setBounds(40,60,130,20);
	
	
	pan.add(l0);
	pan.add(l1);
	pan.add(l2);
	pan.add(l3);
	pan.add(l4);
	
	l1.addMouseListener(al);
	l2.addMouseListener(al);
	l3.addMouseListener(al);
	
	
	add(pan);
	setVisible(true);
	}
}
