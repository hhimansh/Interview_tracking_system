package com.wipro.its.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.its.listener.login_lis;

@SuppressWarnings("serial")
public class LoginPage extends JFrame
{
	public JLabel imglb,l1,l2,l3,label1,label2,label3,lab1,lab2,lab3,username,password,imgln,lab4,lab5,lab6,lab7;
	JPanel pan1,pan2,pan3;
	String str,str1,str3,str4;
	ImageIcon img,img1;

	public JTextField text1;
	public JPasswordField text2;
	public JButton button;
	public JCheckBox box;
	login_lis al=new login_lis(this);

	public LoginPage()
	{
		setLayout(null);
		setSize(700,700);
		getContentPane().setBackground(Color.pink);

		setTitle("Login Page");

		str="<html><body><p><B><a href>About Us</a></body></html>";
		str1="<html><body><p><a href>Contact Us</a></body></html>";

		str3="<html><body><p><a href>Click here to reset it</a></body></html>";
		str4="<html><body><p><a href>Register Here</a></body></html>";

		img=new ImageIcon("src\\images\\images.jpg");

		pan1=new JPanel();  
		pan1.setBackground(Color.ORANGE);
		pan1.setLayout(null);
		pan1.setBounds(0,0,700,200);


		imglb=new JLabel();
		imglb.setIcon(img);
		imglb.setBounds(0,1,230,160);



		l1=new JLabel("Interview Tracking System");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Times New Roman",Font.BOLD,30));
		l1.setBounds(300,60,400,50);

		l2=new JLabel(str);
		l2.setBounds(550,160,80,20);

		l3=new JLabel(str1);
		l3.setBounds(610,160,80,20);

		pan1.add(imglb);
		pan1.add(l1);
		pan1.add(l2);
		pan1.add(l3);



		pan2=new JPanel();

		pan2.setBackground(Color.LIGHT_GRAY);
		pan2.setLayout(null);
		pan2.setBounds(0,200,400,420);

		lab4=new JLabel("Welcome");
		lab4.setBounds(130,20,200,30);
		lab4.setFont(new Font("Times New Roman",Font.BOLD,40));

		img1=new ImageIcon("src\\images\\img4.jpg");

		imgln=new JLabel();
		imgln.setIcon(img1);
		imgln.setLayout(null);
		imgln.setBounds(55,35,400,300);

		lab5=new JLabel("    Empowers recruiters with a complete applicant tracking");
		lab5.setBounds(10,320,400,20);
		lab6=new JLabel("    functionality in every step of staffing and recruiting process");
		lab6.setBounds(10,340,400,20);
		lab7=new JLabel("     right from sourcing to hiring candidates");
		lab7.setBounds(10,360,400,20);

		pan2.add(lab4);
		pan2.add(imgln);
		pan2.add(lab5);
		pan2.add(lab6);
		pan2.add(lab7);




		pan3=new JPanel();
		pan3.setBackground(Color.cyan);
		pan3.setLayout(null);
		pan3.setBounds(400,200,300,420);

		label1=new JLabel("Login");
		label1.setBounds(25,20,50,20);

		username=new JLabel("Username");
		username.setBounds(25,50,60,20);
		text1=new JTextField(30);
		text1.setBounds(25,80,220,25);

		password=new JLabel("Password");
		password.setBounds(25,120,60,20);

		text2=new JPasswordField(30);
		text2.setBounds(25,150,220,25);

		box=new JCheckBox("Remember me on this computer");
		box.setBounds(25,190,250,20);

		button=new JButton("Login");
		button.setBounds(100,230,80,30);

		label2=new JLabel("Forget your password?");
		label2.setBounds(25,275,150,15);

		lab1=new JLabel(str3);
		lab1.setBounds(100,300,150,15);

		label3=new JLabel(str4);
		label3.setBounds(25,340,80,15);

		lab2=new JLabel("New User?");
		lab2.setBounds(130,340,80,15);


		pan3.add(label1);
		pan3.add(username);
		pan3.add(text1);
		pan3.add(password);
		pan3.add(text2);
		pan3.add(box);
		pan3.add(button);
		pan3.add(label2);
		pan3.add(lab1);
		pan3.add(label3);
		pan3.add(lab2);


		lab3=new JLabel("Copyright @ 2014 Wipro Technologies. All rights reserved");
		lab3.setBounds(200,630,450,20);


		add(pan1);
		add(pan2);
		add(pan3);

		add(lab3);
		button.addActionListener(al);
		label3.addMouseListener(al);
		lab1.addMouseListener(al);
		text1.addFocusListener(al);
		l2.addMouseListener(al);
		l3.addMouseListener(al);

		setVisible(true);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		LoginPage l=new LoginPage();
	}
}