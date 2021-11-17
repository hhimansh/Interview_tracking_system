package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.view_ratings;

public class view_ratings_lis implements ActionListener{

	view_ratings vr;


	public view_ratings_lis(view_ratings vr)
	{
		this.vr=vr;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vr.b1)
		{
			String id = vr.t1.getSelectedItem().toString();
			AdministratorClass adoa=new AdministratorClass();

			InterviewScheduleBean is =adoa.viewRatings(id);
			
			float tr=is.getTechRating();
			float hr=is.getEmpHRRating();

			float total=tr+hr;

			vr.l3.setText(""+tr);
			vr.l5.setText(""+hr);
			vr.l7.setText(""+total);
		}
		
		if(e.getSource()==vr.b2)
		{
			vr.dispose();
		}
	}
}