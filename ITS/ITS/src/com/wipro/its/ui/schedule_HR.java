package com.wipro.its.ui;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.listener.schedule_HR_lis;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class schedule_HR extends JFrame{

	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	JPanel pan,pan1,pan2;
	JLabel l0,l1,l2,l3,l4,l5;
	public JButton b1, b2;
	public JComboBox<String> d,m,yr,hrs,mins,t1,t2,t3;
	schedule_HR_lis hr = new schedule_HR_lis(this);

	public schedule_HR()
	{
		setTitle("HR Interview");
		setSize(450,400);
		setLocation(230,240);

		pan=new JPanel();
		pan.setLayout(null);
		pan.setBounds(0,0,350,300);
		pan.setBackground(Color.PINK);


		l0=new JLabel("Schedule For HR");
		l0.setFont(new Font("Times New Roman",Font.BOLD,20));

		l5=new JLabel("Minimum Tech Rating");
		l1=new JLabel("Candidate ID");
		l4=new JLabel("HR-ID");
		l2=new JLabel("Interview Date");
		l3=new JLabel("Interview Time");

		t1 = new JComboBox<String>();

		t2 = new JComboBox<String>();
		try
		{
			pst = con.prepareStatement("SELECT empHRId FROM ITS_TBL_HRPanel");
			rs = pst.executeQuery();
			while(rs.next())
			{
				t2.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		t3 = new JComboBox<String>();
		for(int i=1; i<5; i++)
		{
			for(int j=0; j<10; j++)
			{
				t3.addItem(i+"."+j);
			}
		}
		t3.addItem("5.0");
		
		pan1=new JPanel();

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
		for(int i=2016; i<=2017; i++)
		{
			yr.addItem(""+i);
		}

		pan1.add(d);
		pan1.add(m);
		pan1.add(yr);
		pan1.setLayout(new GridLayout(1,3));


		pan2=new JPanel();

		hrs = new JComboBox<String>();
		mins = new JComboBox<String>();

		for(int i=0; i<24; i++)
		{
			hrs.addItem(""+i);
		}

		for(int i=0; i<60; i++)
		{
			mins.addItem(""+i);
		}

		pan2.add(hrs);
		pan2.add(mins);
		pan2.setLayout(new GridLayout(1,2));


		b1=new JButton("Submit");
		b2 = new JButton("Cancel");

		l0.setBounds(120,5,200,50);

		l5.setBounds(40, 60, 130, 20);
		t3.setBounds(180, 60, 130, 20);
		
		l1.setBounds(40,100,130,20);
		t1.setBounds(180,100,180,20);

		l4.setBounds(40,140,130,20);
		t2.setBounds(180,140,180,20);

		l2.setBounds(40,180,130,20);
		pan1.setBounds(180,180,180,20);

		l3.setBounds(40,220,130,20);
		pan2.setBounds(180,220,180,20);

		b1.setBounds(140,270,80,20);
		b2.setBounds(230, 270, 80, 20);

		pan.add(l0);    
		pan.add(l1);
		pan.add(t1);
		pan.add(l4);
		pan.add(t2);
		pan.add(l2);
		pan.add(pan1);
		pan.add(l3);
		pan.add(pan2);
		pan.add(b1);
		pan.add(b2);
		pan.add(l5);
		pan.add(t3);

		add(pan);

		setVisible(true);
		setResizable(false);

		b1.addActionListener(hr);
		b2.addActionListener(hr);
		t3.addFocusListener(hr);
	}
}