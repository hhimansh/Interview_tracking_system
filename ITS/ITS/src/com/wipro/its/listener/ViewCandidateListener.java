package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.service.TechPanelClass;
import com.wipro.its.ui.ViewCandidate;
import com.wipro.its.ui.ViewCandidateTbl;

public class ViewCandidateListener implements ActionListener
{
	ViewCandidate cand;
	TechPanelClass tUtil;

	public ViewCandidateListener(ViewCandidate cand) 
	{
		this.cand=cand;
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==cand.b)
		{
			try
			{
				tUtil=new TechPanelClass();
				String str=cand.box1.getSelectedItem().toString()+ "/" + cand.box2.getSelectedItem().toString()+ "/" +cand.box3.getSelectedItem().toString();
				SimpleDateFormat sd=new SimpleDateFormat("dd/MMM/yyyy");
				java.util.Date d1=sd.parse(str);
				java.sql.Date d2=new java.sql.Date(d1.getTime());


				ArrayList<CandidateBean> list=new ArrayList<CandidateBean>();

				list=tUtil.viewCandidates(cand.t1.getSelectedItem()+"", d2);
				Iterator<CandidateBean> it=list.iterator();
				while(it.hasNext())
				{
					CandidateBean c1 = it.next();		
				}
				if(list!=null)
				{
					ViewCandidateTbl tbl = new ViewCandidateTbl(list);
				}
				else

					JOptionPane.showMessageDialog(cand, "value does not exist");
			}
			catch(Exception e1)
			{
//				e1.printStackTrace();
			}

		}

	}
}