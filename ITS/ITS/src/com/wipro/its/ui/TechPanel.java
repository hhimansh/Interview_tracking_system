package com.wipro.its.ui;
import java.awt.*;

import javax.swing.*;

import com.wipro.its.listener.TechPanel_lis;

@SuppressWarnings("serial")
public class TechPanel extends JFrame
{
	public JLabel l,l1,l2,l3,ab1,ab2,ab3,ab4,user,ab;
	JPanel panel1,panel2,panel3,panel4,panel5;
	String str1,str2,str3,str4,str5,str6,str;
	JLabel label1,imglb;
	ImageIcon img;
	TechPanel_lis tl=new TechPanel_lis(this);

	public static String userId1;

	public TechPanel(String userId1)
	{
		TechPanel.userId1=userId1;
		setTitle("TechPanel");
		setLayout(new FlowLayout());
		setSize(720,620);
		getContentPane().setBackground(Color.orange);

		str1="<html><body><p><a href>Logout</a></body></html>";
		str2="<html><body><p><a href>Home</a></body></html>";
		str3="<html><body><p><a href>View Candidates to be Interviewed</a></body></html>";
		str4="<html><body><p><a href>Submit Interview Rating</a></body></html>";
		str5="<html><body><p><a href>View Final Results</a></body></html>";
		str="<html><body><p><a href>View Candidate Information</a></body></html>";
		str6="<html><body><p><a href>Change Password</a></body></html>";


		ab1=new JLabel(str3);
		ab2=new JLabel(str4);
		ab3=new JLabel(str5);
		ab=new JLabel(str);
		ab4=new JLabel(str6);


		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(Color.orange);
		panel1.setPreferredSize(new Dimension(700,170));

		label1=new JLabel("INTERVIEW TRACKING SYSTEM");
		label1.setFont(new Font("Serif", Font.PLAIN,25));
		label1.setBounds(300,70,500,30);
		img=new ImageIcon("src\\images\\images.jpg");
		imglb=new JLabel();
		imglb.setIcon(img);
		imglb.setBounds(0,0,250,200);
		panel1.add(label1);
		panel1.add(imglb);


		panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.orange);
		panel2.setPreferredSize(new Dimension(700,50));

		l=new JLabel("TechPanel");
		l.setForeground(Color.black);
		l.setFont(new Font("Serif", Font.PLAIN,17));
		l.setBounds(20,20,150,25);
		user = new JLabel(userId1);
		user.setForeground(Color.RED);
		user.setFont(new Font("Times New Roman",Font.BOLD,30));
		user.setBounds(290,20,150,25);
		l2=new JLabel(str2);
		l2.setBounds(600,20,150,25);
		l1=new JLabel(str1);
		l1.setBounds(650,20,150,25);

		panel2.add(l);
		panel2.add(user);
//		panel2.add(l2);
		panel2.add(l1);

		panel3=new JPanel();
		panel3.setPreferredSize(new Dimension(700,300));
		panel3.setLayout(new GridLayout(0,2));
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		p4.setBackground(Color.BLUE);

		p3.setBackground(Color.CYAN);
		p3.setLayout(new GridLayout(5,0));

		p3.add(ab1);
		p3.add(ab2);
		p3.add(ab3);
		p3.add(ab);
		p3.add(ab4);

		panel3.add(p3);
		panel3.add(p4);


		panel5=new JPanel();
		panel5.setBackground(Color.pink);
		panel5.setPreferredSize(new Dimension(700,50));
		l3=new JLabel("Copyright @ 2014 Wipro Technologies. All rights reserved");
		panel5.add(l3);

		add(panel1);
		add(panel2);
		add(panel3);
		add(panel5);

		l1.addMouseListener(tl);
		ab1.addMouseListener(tl);
		ab2.addMouseListener(tl);
		ab3.addMouseListener(tl);
		ab4.addMouseListener(tl);
		ab.addMouseListener(tl);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String []args)
	{
		TechPanel a = new TechPanel("tech");
	}	
}