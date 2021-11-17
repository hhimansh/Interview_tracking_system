package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.its.bean.CandidateBean;
import com.wipro.its.service.HRPanelClass;
import com.wipro.its.ui.HRViewCandidate;
import com.wipro.its.ui.HRViewCandidateTbl;

public class HRViewCandidateListener implements ActionListener
{
	HRViewCandidate cand;
	HRPanelClass tUtil;

	public HRViewCandidateListener(HRViewCandidate cand) 
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
				tUtil=new HRPanelClass();
				String str=cand.box1.getSelectedItem().toString()+ "/" + cand.box2.getSelectedItem().toString()+ "/" +cand.box3.getSelectedItem().toString();
				SimpleDateFormat sd=new SimpleDateFormat("dd/MMM/yyyy");
				java.util.Date d1=sd.parse(str);
				java.sql.Date d2=new java.sql.Date(d1.getTime());



				ArrayList<CandidateBean> list=new ArrayList<CandidateBean>();

				list=tUtil.HRviewCandidates(cand.t1.getSelectedItem()+"", d2);
				Iterator<CandidateBean> it=list.iterator();
				while(it.hasNext())
				{
					CandidateBean c1 = it.next();
				}
				if(list!=null)
				{
					HRViewCandidateTbl tbl=new HRViewCandidateTbl(list);
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
