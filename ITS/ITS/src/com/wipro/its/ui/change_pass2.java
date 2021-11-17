package com.wipro.its.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.wipro.its.listener.hr_Change_Password_Listener;

@SuppressWarnings("serial")
public class change_pass2 extends JFrame{
	JPanel pan;
	public JPasswordField t1;
	public JPasswordField t2;
	public JPasswordField t3;
	JLabel l0;
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public JButton b1;
	public JLabel last1,last2,last3;

	hr_Change_Password_Listener ad= new hr_Change_Password_Listener(this);




	public change_pass2(String userId1)
	{		

		setSize(340,290);
		setLocation(365,265);
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
		
		b1=new JButton("OK");

		l0.setBounds(120,5,200,50);

		l1.setBounds(40,60,130,20);
		t1.setBounds(180,60,130,20);

		l2.setBounds(40,100,130,20);
		t2.setBounds(180,100,130,20);

		l3.setBounds(40,140,130,20);
		t3.setBounds(180,140,130,20);
		
		last1.setLayout(null);
		last1.setBounds(40,190,300,20);
		last1.setForeground(Color.RED);
		last2.setLayout(null);
		last2.setBounds(40,210,300,20);
		last2.setForeground(Color.RED);
		last3.setBounds(40,230,300,20);
		last3.setForeground(Color.RED);

		b1.setBounds(140,170,60,20);


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
		
		pan.add(b1);
		b1.addActionListener(ad);
		add(pan);

		setVisible(true);
		setResizable(false);
	}
}