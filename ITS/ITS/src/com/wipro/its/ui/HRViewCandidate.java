package com.wipro.its.ui;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import com.wipro.its.listener.HRViewCandidateListener;
import com.wipro.its.util.DBUtil;

@SuppressWarnings("serial")
public class HRViewCandidate extends JFrame
{
	JLabel label1,label2,label;
	public JComboBox<String> t1;
	public JButton b;
	JPanel panel1,panel2,panel3;
	public JComboBox<String> box1,box2,box3;

	HRViewCandidateListener v=new HRViewCandidateListener(this);
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");

	public HRViewCandidate()
	{
		setTitle("View Candidates");
		getContentPane().setBackground(Color.PINK);
		setBounds(365,265,340,290);
		setLayout(new FlowLayout());

		String []str1={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		box1=new JComboBox<String>(str1);

		String []str2={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		box2=new JComboBox<String>(str2);

		String []str3={"2016","2017"};
		box3=new JComboBox<String>(str3);

		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setPreferredSize(new Dimension(340,110));
		panel1.setBackground(Color.pink);

		label=new JLabel("Candidate Details");
		label.setBounds(110,10,300,40);
		label.setFont(new Font("Serif", Font.PLAIN,20));
		label1=new JLabel("EmpHRId");
		label1.setBounds(40,80,60,20);

		t1=new JComboBox<String>();
		t1.setBounds(150,80,130,20);
		panel1.add(label);
		panel1.add(label1);

		t1 = new JComboBox<String>();
		t1.setBounds(150,80,140,20);
		try
		{
			pst = con.prepareStatement("SELECT DISTINCT empHRid FROM ITS_TBL_INTERVIEW_SCHEDULE");
			rs = pst.executeQuery();
			while(rs.next())
			{
				t1.addItem(rs.getString(1));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		panel1.add(t1);

		panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.pink);
		panel2.setPreferredSize(new Dimension(340,50));

		label2=new JLabel("Interview Date");
		label2.setBounds(40,20,100,20);
		panel2.add(label2);
		box1.setBounds(150,20,50,20);
		panel2.add(box1);
		box2.setBounds(200,20,50,20);
		panel2.add(box2);
		box3.setBounds(250,20,60,20);
		panel2.add(box3);

		panel3=new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(Color.pink);
		panel3.setPreferredSize(new Dimension(340,50));
		b=new JButton("View");
		b.setBounds(130,20,70,20);
		panel3.add(b);

		add(panel1);
		add(panel2);
		add(panel3);

		b.addActionListener(v);

		setResizable(false);
		setVisible(true);
	}
}