package com.wipro.its.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import com.wipro.its.listener.admin_lis;

@SuppressWarnings("serial")
public class admin extends JFrame {
	public JLabel imglb,ln,l,l1,l2,ab1,ab2,ab3,ab4,ab5,ab6,ab7,ab8,ab9,lastlabel,user;
	JPanel pan0,pan1,pan2;
	String str,str1,str2,str3,str4,str5,str6,str7,str8,str9;
	ImageIcon img;
	admin_lis al=new admin_lis(this);
	public static String userId;

	public admin(String userId)
	{
		admin.userId = userId;
		//       setTitle("                               INTERVIEW TRACKING SYSTEM");
		setLayout(null);
		setTitle("Admin");

		str="<html><body><p><B><a href>Logout</a></body></html>";
		str1="<html><body><p><a href>Home</a></body></html>";
		str2="<html><body><p><a href=>Add/Delete/Modify Candidate Details</a></body></html>";
		str3="<html><body><p><a href>View Candidate Details</a></body></html>";
		str4="<html><body><p><a href>Schedule Interview for Technical</a></body></html>";
		str5="<html><body><p><a href>Schedule Interview for HR</a></body></html>";
		str6="<html><body><p><a href>Share Info. with Tech and HR</a></body></html>";
		str7="<html><body><p><a href>View Ratings</a></body></html>";
		str8="<html><body><p><a href>Declare Final Results</a></body></html>";
		str9="<html><body><p><a href>Change Password</a></body></html>";

		img=new ImageIcon("src\\images\\images.jpg");


		pan0=new JPanel();      

		imglb=new JLabel();
		imglb.setIcon(img);

		ln=new JLabel("Interview Tracking System");
		ln.setForeground(Color.BLACK);
		ln.setFont(new Font("Times New Roman",Font.BOLD,30));

		l=new JLabel("ADMIN");
		l1=new JLabel(str1);
		l2=new JLabel(str);

		l.setForeground(Color.RED);
		l.setFont(new Font("Times New Roman",Font.BOLD,15));

		user = new JLabel(userId);
		user.setForeground(Color.black);
		user.setFont(new Font("Times New Roman",Font.BOLD,30));

		pan0.setBackground(Color.ORANGE);

		pan0.setLayout(null);
		pan0.setBounds(0,0,700,200);
		imglb.setBounds(0,1,230,160);


		ln.setBounds(300,60,400,50);
		l.setBounds(20,170,80,20);
		user.setBounds(200, 170, 80, 20);
		l1.setBounds(580,160,80,20);
		l2.setBounds(630,160,80,20);

		pan0.add(imglb);
		pan0.add(ln);
		pan0.add(l);
		pan0.add(user);
//		pan0.add(l1);
		pan0.add(l2);

		pan1=new JPanel();
		pan1.setBackground(Color.CYAN);

		ab1=new JLabel(str2);
		ab2=new JLabel(str3);
		ab3=new JLabel(str4);
		ab4=new JLabel(str5);
		ab5=new JLabel(str6);
		ab6=new JLabel(str7);
		ab7=new JLabel(str8);
		ab8=new JLabel(str9); 

		pan1.setBounds(0,200,200,420);
		pan1.setLayout(new GridLayout(8,1));


		pan1.add(ab1);
		pan1.add(ab2);
		pan1.add(ab3);
		pan1.add(ab4);
		pan1.add(ab5);
		pan1.add(ab6);
		pan1.add(ab7);
		pan1.add(ab8);

		pan2=new JPanel();
		pan2.setBackground(Color.BLUE);
		pan2.setBounds(200,200,650,420);

		lastlabel=new JLabel("Copyright @ 2014 Wipro Technologies. All rights reserved");
		lastlabel.setLayout(null);
		lastlabel.setBounds(200,620,500,20);

		l2.addMouseListener(al);
		ab1.addMouseListener(al);
		ab2.addMouseListener(al);
		ab5.addMouseListener(al);
		ab8.addMouseListener(al);
		ab6.addMouseListener(al);
		ab7.addMouseListener(al);
		ab3.addMouseListener(al);
		ab4.addMouseListener(al);

		add(pan0);
		add(pan1);
		add(pan2);


		setSize(700,680);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}
	public static void main(String[] args) {
		new admin("hello");
	}
}