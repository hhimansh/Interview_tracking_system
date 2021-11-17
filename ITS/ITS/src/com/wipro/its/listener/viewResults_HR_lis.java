package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.service.HRPanelClass;
//import com.wipro.its.service.TechPanelClass;
import com.wipro.its.ui.viewResults_HR;

public class viewResults_HR_lis implements ActionListener
{
	HRPanelClass tpc;
	viewResults_HR vr;
	
	public viewResults_HR_lis(viewResults_HR vr)
	{
		this.vr=vr;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vr.b)
		{
			
			tpc=new HRPanelClass();
			InterviewScheduleBean isb=tpc.HRviewFinalResults(vr.cb.getSelectedItem().toString());
			
			if(isb==null)
			{
      		   JOptionPane.showMessageDialog(vr, "The result is not shared by admin");
				vr.label4.setText(null);
				vr.label6.setText(null);		
			}
			else if(isb!=null)
			{
				String candid=isb.getCandidateID();
				String Result=isb.getResult();

				vr.label4.setText(candid);
				vr.label6.setText(Result);
			}
		}
		
	}

}
