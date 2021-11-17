package com.wipro.its.ui;
import java.awt.*;

import javax.swing.*;

import com.wipro.its.listener.admin_Change_Password_listener;


@SuppressWarnings("serial")
public class change_pass extends JFrame{
	JPanel pan;
	public JPasswordField t1;
	public JPasswordField t2;
	public JPasswordField t3;
	JLabel l0;
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public JButton b1, b2;
	admin ad1;
	public JLabel last1,last2,last3,last4,last5;

	admin_Change_Password_listener ad= new admin_Change_Password_listener(this);

	public change_pass(String userId)
	{		

		setSize(450,400);
		setLocation(230,240);
		setTitle("Change Password");

		pan=new JPanel();

		pan.setLayout(null);
		pan.setBounds(0,0,350,300);
		pan.setBackground(Color.pink);
		l0=new JLabel("Change Password");
		l0.setFont(new Font("Times New Roman",Font.BOLD,20));

		l1=new JLabel("Current Password");
		t1=new JPasswordField(20);

		l2=new JLabel("New Password");
		t2=new JPasswordField(20);

		l3=new JLabel("Re-Enter Password");
		t3=new JPasswordField(20);

		
		last1= new JLabel();
		last2= new JLabel();
		last3= new JLabel();
		last4= new JLabel();
		last5= new JLabel();
		
		b1=new JButton("OK");
		b2=new JButton("Cancel");

		l0.setBounds(120,5,200,50);

		l1.setBounds(40,60,130,20);
		t1.setBounds(180,60,130,20);

		l2.setBounds(40,100,130,20);
		t2.setBounds(180,100,130,20);

		l3.setBounds(40,140,130,20);
		t3.setBounds(180,140,130,20);
		
		last1.setLayout(null);
		last1.setBounds(90,230,300,20);
		last1.setForeground(Color.RED);
		last2.setLayout(null);
		last2.setBounds(90,250,300,20);
		last2.setForeground(Color.RED);
		last3.setBounds(90,270,300,20);
		last3.setForeground(Color.RED);
		last4.setBounds(90,290,300,20);
		last4.setForeground(Color.RED);
		last5.setBounds(90,310,300,20);
		last5.setForeground(Color.RED);

		b1.setBounds(100,190,80,20);
		b2.setBounds(200,190,80,20);

		pan.add(l0);
		pan.add(l1);
		pan.add(t1);

		pan.add(l2);
		pan.add(t2);

		pan.add(l3);
		pan.add(t3);
		pan.add(last1);
		pan.add(last2);
		pan.add(last1);
		pan.add(last3);
		pan.add(last4);
		pan.add(last5);
		
		pan.add(b1);
		pan.add(b2);
		b1.addActionListener(ad);
		b2.addActionListener(ad);
		add(pan);

		setVisible(true);
		setResizable(false);
	}
}