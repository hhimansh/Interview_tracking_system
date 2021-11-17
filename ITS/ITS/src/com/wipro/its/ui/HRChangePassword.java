package com.wipro.its.ui;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class HRChangePassword extends JFrame
{

	JLabel lab1,lab2,lab3,label;
	JPasswordField t1,t2,t3;
	JButton button1,button2;


	public HRChangePassword()
	{
		setBounds(365,265,340,290);
		setLayout(null);

		//getContentPane().setBackground(Color.white);
		label=new JLabel("Change Password");
		label.setBounds(90,10,300,40);
		label.setFont(new Font("Serif", Font.PLAIN,20));


		lab1=new JLabel("Old Password");
		lab1.setBounds(30,80,100,20);
		t1=new JPasswordField(20);
		t1.setBounds(150,80,140,20);

		lab2=new JLabel("New Password");
		lab2.setBounds(30,110,100,20);
		t2=new JPasswordField(20);
		t2.setBounds(150,110,140,20);

		lab3=new JLabel("Confirm Password");
		lab3.setBounds(30,140,120,20);
		t3=new JPasswordField(20);
		t3.setBounds(150,140,140,20);


		button1=new JButton("OK");
		button1.setBounds(80,190,80,20);
		button2=new JButton("Cancel");
		button2.setBounds(180,190,80,20);





		add(label);
		add(lab1);
		add(t1);
		add(lab2);
		add(t2);
		add(lab3);
		add(t3);
		add(button1);
		add(button2);

		setResizable(false);
		setVisible(true);


	}

}
