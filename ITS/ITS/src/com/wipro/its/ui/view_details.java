package com.wipro.its.ui;
import java.awt.*;

import javax.swing.*;

import com.wipro.its.listener.view_det_lis;

@SuppressWarnings("serial")
public class view_details extends JFrame {
	public JLabel l0,l1,l2,l3,lastlabel;
	public JTextField t2;
	public JComboBox<String> t1, t3;
	JTable jt;
	public JButton b1, b2;
	JPanel pan1;
	view_det_lis vl=new view_det_lis(this);

	public view_details()
	{
		setLayout(null);
		setSize(450,400);
		setLocation(230,240);
		setTitle("View Details Page"); 

		pan1=new JPanel();

		pan1.setLayout(null);
		pan1.setBounds(0,0,450,370);

		l0=new JLabel("View Candidate Details");
		l0.setForeground(Color.BLACK);
		l0.setFont(new Font("Times New Roman",Font.BOLD,20));

		l0.setBounds(120,5,200,50);

		l1=new JLabel("Primary Skills");
		t1=new JComboBox<String>();
		t1.addItem("C");
		t1.addItem("C++");
		t1.addItem("Java");
		t1.addItem("HTML");
		t1.addItem(".NET");

		l2=new JLabel("Experience");
		t2=new JTextField();

		l3=new JLabel("Qualification");
		t3=new JComboBox<String>();
		t3.addItem("B.Tech.");
		t3.addItem("B.E.");
		t3.addItem("B.Sc.");
		t3.addItem("M.Sc.");
		t3.addItem("MCA");

		lastlabel=new JLabel();

		b1=new JButton("View");
		b2=new JButton("Cancel");

		l1.setBounds(40,60,130,20);
		t1.setBounds(180,60,130,20);

		l2.setBounds(40,100,130,20);
		t2.setBounds(180,100,130,20);

		l3.setBounds(40,140,130,20);
		t3.setBounds(180,140,130,20);

		b1.setBounds(100,180,80,20);
		b2.setBounds(200, 180, 80, 20);
		lastlabel.setBounds(120,250,200,20);

		pan1.setBackground(Color.PINK);

		pan1.add(l0);    
		pan1.add(l1);
		pan1.add(t1);

		pan1.add(l2);
		pan1.add(t2);

		pan1.add(l3);
		pan1.add(t3);

		pan1.add(b1);
		pan1.add(b2);
		pan1.add(lastlabel);


		add(pan1);		

		b1.addActionListener(vl);
		b2.addActionListener(vl);

		setVisible(true);
		setResizable(false);

	}


}
