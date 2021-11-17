package com.wipro.its.ui;
import java.awt.*;

import javax.swing.*;

import com.wipro.its.listener.add_det_lis;

@SuppressWarnings("serial")
public class add_details extends JFrame {
	public JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,lastlab;
	public JTextField t1,t2,t5,t6,t7,t8,t9,t10,t11,t12,t13,t15,t16,t17,t18;
	public JButton b1,b2;
	public JComboBox<String> cb, d, m, yr, ta1, ta2, t14;
	JPanel pan;

	add_det_lis adl=new add_det_lis(this);

	public add_details()
	{
		setSize(450,400);
		setLocation(230,240);
		setTitle("Add Candidate Details");
		getContentPane().setBackground(Color.pink);

		l1=new JLabel("First Name");
		t1=new JTextField(20);

		l2=new JLabel("Last Name");
		t2=new JTextField(20);

		l3=new JLabel("Date of Birth");

		d = new JComboBox<String>();
		for(int i=1; i<=31; i++)
		{
			if(i>=1 && i<=9)
			{
				d.addItem("0"+i);
			}
			else d.addItem(""+i);
		}

		m = new JComboBox<String>();
		for(int i=1; i<=12; i++)
		{
			if(i>=1 && i<=9)
			{
				m.addItem("0"+i);
			}
			else m.addItem(""+i);
		}

		yr = new JComboBox<String>();
		for(int i=1965; i<=2016; i++)
		{
			yr.addItem(""+i);
		}

		pan=new JPanel();
		pan.setLayout(new GridLayout(1,3));
		pan.setBackground(Color.CYAN);
		pan.add(d);
		pan.add(m);
		pan.add(yr);

		l4=new JLabel("Gender");
		cb=new JComboBox<>();
		cb.addItem("Male");
		cb.addItem("female");


		l5=new JLabel("Street");
		t5=new JTextField(20);

		l6=new JLabel("City");
		t6=new JTextField(20);

		l7=new JLabel("State");
		t7=new JTextField(20);

		l8=new JLabel("Pincode");
		t8=new JTextField(6);

		l9=new JLabel("Mobile No.");
		t9=new JTextField(10);

		l10=new JLabel("EmailId");
		t10=new JTextField(20);

		l11=new JLabel("Primary Skills");
		ta1=new JComboBox<String>();
		ta1.addItem("C");
		ta1.addItem("C++");
		ta1.addItem("Java");
		ta1.addItem("HTML");
		ta1.addItem(".NET");

		l12=new JLabel("Secondary Skills");
		ta2=new JComboBox<String>();
		ta2.addItem("C");
		ta2.addItem("C++");
		ta2.addItem("Java");
		ta2.addItem("HTML");
		ta2.addItem(".NET");

		l13=new JLabel("Experience");
		t13=new JTextField(10);

		l14=new JLabel("Qualification");
		t14=new JComboBox<String>();
		t14.addItem("B.Tech.");
		t14.addItem("B.E.");
		t14.addItem("B.Sc.");
		t14.addItem("M.Sc.");
		t14.addItem("MCA");

		l15=new JLabel("Designation");
		t15=new JTextField(10);

		l16=new JLabel("Notice Period");
		t16=new JTextField(10);

		l17=new JLabel("Location");
		t17=new JTextField(10);

		lastlab=new JLabel("");
		lastlab.setForeground(Color.RED);

		b1=new JButton("Submit");
		b2=new JButton("Reset");

		add(l1);
		add(t1);

		add(l2);
		add(t2);

		add(l3);
		add(pan);

		add(l4);
		add(cb);

		add(l5);
		add(t5);

		add(l6);
		add(t6);

		add(l7);
		add(t7);

		add(l8);
		add(t8);

		add(l9);
		add(t9);

		add(l10);
		add(t10);

		add(l11);
		add(ta1);


		add(l12);
		add(ta2);

		add(l13);
		add(t13);

		add(l14);
		add(t14);

		add(l15);
		add(t15);


		add(l16);
		add(t16);

		add(l17);
		add(t17);

		add(b1);
		add(b2);

		add(lastlab);

		b1.addActionListener(adl);
		b2.addActionListener(adl);

		setLayout(new GridLayout(20,2));
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new add_details();
	}
}
