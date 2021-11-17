package com.wipro.its.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.wipro.its.bean.InterviewScheduleBean;
import com.wipro.its.service.AdministratorClass;
import com.wipro.its.ui.schedule_HR;
import com.wipro.its.util.DBUtil;

public class schedule_HR_lis implements ActionListener, FocusListener {
	PreparedStatement pst;
	ResultSet rs;
	Connection con = DBUtil.getDBConnection("");
	
	schedule_HR hr;
	public String minRating="1.0";
	public schedule_HR_lis(schedule_HR hr)
	{
		this.hr = hr;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==hr.b1)
		{
			AdministratorClass ad = new AdministratorClass();
			InterviewScheduleBean isb = new InterviewScheduleBean();
			isb.setCandidateID(hr.t1.getSelectedItem().toString());

			isb.setEmpHRID(hr.t2.getSelectedItem().toString());

			try
			{
				String dob = hr.d.getSelectedItem().toString() +"/"+ hr.m.getSelectedItem().toString() +"/"+ hr.yr.getSelectedItem().toString();
				SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date date = sd.parse(dob);
				isb.setEmpHRInterviewDate(date);
			}
			catch(Exception e1)
			{
//				e1.printStackTrace();
			}

			isb.setEmpHRInterviewTime(hr.hrs.getSelectedItem().toString()+":"+hr.mins.getSelectedItem().toString());

			boolean result = ad.scheduleInterviewForHR(isb);
			if(result==true)
			{
				JOptionPane.showMessageDialog(hr,"HR Interview Scheduled Successfully");
				hr.dispose();
			}
			if(result==false)
			{
				JOptionPane.showMessageDialog(hr,"Interview could not be scheduled");
			}
		}
		
		if(e.getSource()==hr.b2)
		{
			hr.dispose();
		}
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==hr.t3)
		{
			minRating = hr.t3.getSelectedItem().toString();
			try
			{
				pst = con.prepareStatement("SELECT candidateID FROM ITS_TBL_Interview_Schedule WHERE TechRating >= ?");
				
				pst.setDouble(1, Double.parseDouble(minRating));
				rs = pst.executeQuery();
				hr.t1.removeAllItems();
				while(rs.next())
				{
					hr.t1.addItem(rs.getString(1));
				}
			}
			catch(Exception e1)
			{
//				e1.printStackTrace();
			}
		}
	}
}