package com.wipro.its.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wipro.its.bean.CandidateBean;

@SuppressWarnings("serial")
public class HRViewCandidateTbl extends JFrame
{
	public JTable table;
	CandidateBean cBean;
	String column_data[]={"ID","Pskills","Sskills","Exp","Qual","Desig"};
	ArrayList<CandidateBean> list1;
	
	JPanel panel;


	public HRViewCandidateTbl(ArrayList<CandidateBean> list1)
	{
		 //setSize(470,400);
		setBounds(365,265,340,290);
		setTitle("Candidates");
		getContentPane().setBackground(Color.white);
		setLayout(new FlowLayout());
		System.out.println(list1);
		this.list1=list1;
	
		Iterator<CandidateBean> it=list1.iterator();
		String row_data[][]=new String[list1.size()+1][6];

		int i=0;
		while(it.hasNext())
		{
			cBean=new CandidateBean();
			cBean=it.next();
			row_data[i][0]=cBean.getCandidateID();
			row_data[i][1]=cBean.getPrimarySkills();
			row_data[i][2]=cBean.getSecondarySkills();
			row_data[i][3]=cBean.getExperience()+"";
			row_data[i][4]=cBean.getQualification();
			row_data[i][5]=cBean.getDesignation();
			i++;

		}
		table=new JTable(row_data,column_data);
		table.setBackground(Color.white);
		
		Dimension tableSize = new Dimension(280, 280);
		this.table.setPreferredSize(tableSize);
		
		for(int j=0; j<column_data.length; j++)
		{
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(j).setPreferredWidth(15);
		}
		
		JScrollPane sc=new JScrollPane(table);
		sc.setPreferredSize(new Dimension(300,260));
		
		panel=new JPanel();
		panel.add(sc);
		
		add(sc);
		setVisible(true);
}
}
