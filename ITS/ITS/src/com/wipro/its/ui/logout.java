package com.wipro.its.ui;
import java.awt.*;

import javax.swing.*;

import com.wipro.its.listener.lis_logout;

@SuppressWarnings("serial")
public class logout extends JFrame{

	ImageIcon img;
	JLabel imglb;
	public JLabel label1,label2,label3;
	String str;
	lis_logout lo=new lis_logout(this);

	public logout()
	{
		str="<html><body><p><B><a href>Click here to Login again</a></body></html>";
		setLayout(null);
		setSize(700,680);
		setTitle("Logout");

		getContentPane().setBackground(Color.orange);
		img=new ImageIcon("src\\images\\logout.jpg");
		imglb=new JLabel();
		imglb.setIcon(img);
		imglb.setBounds(100,150,200,200);


		label1=new JLabel("Interview Tracking System");
		label1.setBounds(200,30,450,100);
		label1.setFont(new Font("Serif", Font.PLAIN,32));

		label2=new JLabel("You are successfully logged out");
		label2.setBounds(320,200,500,100);
		label2.setFont(new Font("Serif", Font.PLAIN,30));

		label3=new JLabel(str);
		label3.setBounds(340,300,200,80);

		add(label1);
		add(imglb);
		add(label2);
		add(label3);

		label3.addMouseListener(lo);

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}