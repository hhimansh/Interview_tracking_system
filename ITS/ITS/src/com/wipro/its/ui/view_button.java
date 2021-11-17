package com.wipro.its.ui;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.dao.AdministratorDAO;
import com.wipro.its.listener.view_button_lis;

@SuppressWarnings("serial")
public class view_button extends JFrame {

	view_details vd;
	AdministratorDAO adao;
	
	ArrayList<CandidateBean> cb = new ArrayList<CandidateBean>();

	public JLabel l1,l2;
	JTable jt;
	JScrollPane sp;
	JPanel pan;
	String str1,str2;
	public JButton b1;
	
	 view_button_lis vl=new  view_button_lis(this);
	

	public view_button(ArrayList<CandidateBean> cb)
	{
		setTitle("Candidates");
	    this.cb = cb;
		setSize(450,400);
		setLocation(230,240);
		setLayout(null);
		pan=new JPanel();

		pan.setLayout(null);
		pan.setBounds(0,0,450,400);
		pan.setBackground(Color.pink);

		String column[]={"Candidate-ID","Primary Skills","Sec. Skills","Experience","Qualification"};
		String rows[][]=new String[cb.size()][5];

		int i=0;

		Iterator<CandidateBean> it=cb.iterator();

		while(it.hasNext())
		{
			i=0;
			while(i<cb.size())
			{
				CandidateBean cb1 = it.next();
				rows[i][0] = cb1.getCandidateID();
				rows[i][1] = cb1.getPrimarySkills();
				rows[i][2] = cb1.getSecondarySkills();
				rows[i][3] = ""+cb1.getExperience();
				rows[i][4] = cb1.getQualification();
				i++;
			}
		}

		jt=new JTable(rows,column);
		jt.setBackground(Color.pink);
		
		sp=new JScrollPane(jt);

		sp.setBounds(0,0,430,200);

		sp.setBackground(Color.PINK);

		pan.add(sp);
		pan.setVisible(true);

		add(pan);
		setVisible(true);
		setResizable(false);
	}
}